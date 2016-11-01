package com.software.server.web.base;

import com.software.server.redis.RedisConfig;
import com.software.server.service.base.ServiceConfig;
import com.software.server.web.shiro.ShiroConfig;
import org.springframework.core.annotation.Order;
import org.springframework.mobile.device.DeviceResolverRequestFilter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

/*
 * 所有实现了WebApplicationInitializer接口的类都会在容器启动时自动被加载运行，用@Order注解设定加载顺序
 * 这是servlet3.0+后加入的特性，web.xml中可以不需要配置内容，都硬编码到WebApplicationInitializer的实现类中
 */
@Order(2)
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /*
	 * 应用上下文，除web部分
	 */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    /*
	 * web上下文
	*/
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    /*
     * DispatcherServlet的映射路径
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /*
	 * 注册过滤器，映射路径与DispatcherServlet一致，路径不一致的过滤器需要注册到另外的WebApplicationInitializer中
	 */
    @Override
    protected Filter[] getServletFilters() {
        // 字符集过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        // 终端过滤器
        DeviceResolverRequestFilter deviceFilter = new DeviceResolverRequestFilter();

        //
//        DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
//        delegatingFilterProxy.setTargetBeanName("shiroFilter");
        return new Filter[] {characterEncodingFilter,deviceFilter};
    }

    /*
	 * 可以注册DispatcherServlet的初始化参数，等等
	 */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        super.customizeRegistration(registration);
    }


    @Override
    protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
        return new SmartDispatcherServlet(servletAppContext);
    }

    /*
         * 创建一个可以在非spring管理bean中获得spring管理的相关bean的对象：CP_SpringContext.getBean(String beanName)
         */
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        WebApplicationContext ctx = super.createRootApplicationContext();
        ApplicationContextUtil.getInstance().setApplicationContext(ctx);
        return ctx;
    }
}
