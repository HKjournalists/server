package com.software.server.web.base;

import com.software.server.web.core.AppPropertyEditorRegister;
import org.hibernate.validator.HibernateValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.mobile.device.site.SitePreferenceHandlerInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.List;


@Configuration
@ComponentScan(
        basePackages = "com.software.server.web",
        useDefaultFilters = false,
        includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class, ControllerAdvice.class})
})
public class MvcConfig  extends WebMvcConfigurationSupport {

    private static final Logger logger = LoggerFactory.getLogger(MvcConfig.class);

    @Override
    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 描述 : <注册消息资源处理器>. <br>
     *<p>
     <使用方法说明>
     </p>
     * @return
     */
    @Bean
    public ViewResolver viewResolver(){
        logger.debug("viewResolver");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer(){
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/ftls/");
        freeMarkerConfigurer.setDefaultEncoding("UTF-8");
        return freeMarkerConfigurer;
    }


    @Bean
    public ViewResolver ftlViewResolver(){
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(true);
        resolver.setSuffix(".ftl");
        resolver.setPrefix("");
        resolver.setContentType("text/html;charset=UTF-8");
        resolver.setRequestContextAttribute("request");
        resolver.setExposeRequestAttributes(true);
        resolver.setExposeSessionAttributes(true);
        resolver.setExposeSpringMacroHelpers(true);
        return resolver;
    }

    /**
     * 描述 : <注册消息资源处理器>. <br>
     *<p>
     <使用方法说明>
     </p>
     * @return
     */
    @Bean
    public MessageSource messageSource() {
        logger.debug("messageSource");
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("WEB-INF/messages/messages");
        messageSource.setCacheSeconds(10);
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }

    /**
     * 描述 : <资源访问处理器>. <br>
     *<p>
       <可以在jsp中使用/static/**的方式访问/WEB-INF/static/下的内容>
     </p>
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.debug("addResourceHandlers");
        registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
        super.addResourceHandlers(registry);
    }

    /**
     * 描述 : <文件上传处理器>. <br>
     *<p>
     <使用方法说明>
     </p>
     * @return
     */
    @Bean(name="multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver(){
        logger.debug("CommonsMultipartResolver");
        CommonsMultipartResolver  multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8");
        multipartResolver.setMaxUploadSize(10485760000L);
        multipartResolver.setMaxInMemorySize(40960);
        return multipartResolver;
    }

    /**
     * 配置 contentNegotiatingViewResolver
     * @param manager
     * @return
     */
    @Bean(name="contentNegotiatingViewResolver")
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        logger.debug("Created ContentNegotiatingViewResolver");
        return resolver;
    }

    /**
     * 描述 : <配置内容视图>. <br>
     *<p>
     <使用方法说明>
     </p>
     * @return
     */
    @Override
    protected void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(true).
                useJaf(false).
                favorParameter(true).
                parameterName("mediaType").
                ignoreAcceptHeader(true).
                defaultContentType(MediaType.TEXT_HTML).
                mediaType("xml", MediaType.APPLICATION_XML).
                mediaType("html",MediaType.TEXT_HTML).
                mediaType("json", MediaType.APPLICATION_JSON);
    }

    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.extendMessageConverters(converters);
    }

    @Override
    protected ConfigurableWebBindingInitializer getConfigurableWebBindingInitializer() {
        ConfigurableWebBindingInitializer initializer = super.getConfigurableWebBindingInitializer();
        initializer.setPropertyEditorRegistrars(new PropertyEditorRegistrar[]{new AppPropertyEditorRegister()});
        return initializer;
    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setProviderClass(HibernateValidator.class);
        validator.setValidationMessageSource(messageSource());
        return validator;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DeviceResolverHandlerInterceptor());
        registry.addInterceptor(new SitePreferenceHandlerInterceptor());
    }
}
