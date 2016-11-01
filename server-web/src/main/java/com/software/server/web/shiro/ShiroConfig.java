package com.software.server.web.shiro;

import com.software.server.common.constant.Constants;
import com.software.server.service.interfaces.IResourceService;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.*;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;


/**
 * shiro配置类
 */
@Configuration
public class ShiroConfig {


    @Autowired
    private IResourceService permissionService;

    /**
     * 指定验证用户对应realm
     * @return
     */
    @Bean
    public MyRealm myRealm(){
        MyRealm myRealm = new MyRealm();
        return myRealm;
    }

    /**
     * 安全管理器
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm());
        manager.setSessionManager(sessionManager());
        manager.setCacheManager(cacheManager());
        return manager;
    }


    /**
     * 基于Form表单的身份验证过滤器
     * @return
     */
    @Bean
    public FormAuthenticationFilter formAuthenticationFilter(){
        FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
        formAuthenticationFilter.setUsernameParam("username");
        formAuthenticationFilter.setPasswordParam("password");
        formAuthenticationFilter.setRememberMeParam("rememberMe");
        formAuthenticationFilter.setLoginUrl(Constants.LOGIN_URL);
        return formAuthenticationFilter;
    }

    /**
     * 指定本系统SESSIONID, 默认为: JSESSIONID 问题: 与SERVLET容器名冲突, 如JETTY, TOMCAT 等默认JSESSIONID,
     * 当跳出SHIRO SERVLET时如ERROR-PAGE容器会为JSESSIONID重新分配值导致登录会话丢失!
     * @return
     */
    @Bean
    public SimpleCookie sessionIdCookie(){
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(-1);
        simpleCookie.setName("sid");
        return simpleCookie;
    }

    /**
     * CAS认证过滤器
     * @return
     */
    @Bean
    public CasFilter casFilter(){
        CasFilter casFilter = new CasFilter();
        casFilter.setFailureUrl(Constants.LOGIN_URL);
        return casFilter;
    }



    /**
     * 自定义会话管理配置
     * @return
     */
    @Bean
    public DefaultWebSessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(1800000L);
        sessionManager.setSessionValidationInterval(900000);
        //sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdCookie(sessionIdCookie());
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionDAO(sessionDAO());
        return sessionManager;
    }


    /**
     * 配置shiro拦截的路径
     * @return
     */
    @Bean
    public ChainDefinitionSectionMetaSource chainDefinitionSectionMetaSource()throws Exception{
        ChainDefinitionSectionMetaSource metaSource = new ChainDefinitionSectionMetaSource();
        metaSource.setFilterChainDefinitions("classpath:config/shiroChainDefinition.ini");
        return metaSource;
    }

    /**
     * 权限过滤器
     * @return
     */
    @Bean(name="shiroFilter")
    public ShiroFilterFactoryBean shiroFilter()throws Exception{
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        shiroFilterFactoryBean.setLoginUrl(Constants.LOGIN_URL);
        shiroFilterFactoryBean.setSuccessUrl(Constants.INDEX_URL);
        shiroFilterFactoryBean.setUnauthorizedUrl(Constants.UNAUTHORIZED_URL);
        Map<String,Filter> filterMap = new HashMap<String,Filter>();
        filterMap.put("cas",casFilter());
        filterMap.put("authc", formAuthenticationFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(chainDefinitionSectionMetaSource().getObject());
        return shiroFilterFactoryBean;
    }


    /**
     * 在方法中 注入  securityManager ，进行代理控制
     * @return
     */
    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean(){
        MethodInvokingFactoryBean factoryBean = new MethodInvokingFactoryBean();
        factoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        factoryBean.setArguments(new Object[]{securityManager()});
        return factoryBean;
    }

    /**
     * 保证实现了Shiro内部lifecycle函数的bean执行
     * @return
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        LifecycleBeanPostProcessor postProcessor = new LifecycleBeanPostProcessor();
        return postProcessor;
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        return new DefaultAdvisorAutoProxyCreator();
    }

    /**
     * 启用shrio授权注解拦截方式
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor sourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        sourceAdvisor.setSecurityManager(securityManager());
        return sourceAdvisor;
    }


    /**
     * 缓存管理器 使用Ehcache实现
     * @return
     */
    @Bean
    public EhCacheManager cacheManager(){
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
        return cacheManager;
    }

    /**
     * 会话DAO
     * @return
     */
    @Bean
    public SessionDAO sessionDAO(){
        EnterpriseCacheSessionDAO sessionDAO = new EnterpriseCacheSessionDAO();
        sessionDAO.setSessionIdGenerator(sessionIdGenerator());
        sessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
        return sessionDAO;
    }

    /**
     * 凭证匹配器
     * @return
     */
    @Bean
    public EhcacheLoginMatcher  credentialsMatcher(){
        EhcacheLoginMatcher ehcacheLoginMatcher = new EhcacheLoginMatcher(cacheManager());
        ehcacheLoginMatcher.setHashAlgorithmName("md5");
        ehcacheLoginMatcher.setHashIterations(2);
        ehcacheLoginMatcher.setStoredCredentialsHexEncoded(true);
        return ehcacheLoginMatcher;
    }

    /**
     * 会话ID生成器
     * @return
     */
    @Bean
    public JavaUuidSessionIdGenerator sessionIdGenerator(){
        return new JavaUuidSessionIdGenerator();
    }
}
