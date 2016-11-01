package com.software.server.web.base;

import org.springframework.context.ApplicationContext;


public class ApplicationContextUtil {

    private static ApplicationContext applicationContext;

    private static ApplicationContextUtil springContext;

    private ApplicationContextUtil(){

    }

    public static ApplicationContextUtil getInstance() {
        if (springContext == null) {
            springContext = new ApplicationContextUtil();
        }
        return springContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

    /**
     * 描述 : <获得applicationContext中的对象>. <br>
     *<p>
     <使用方法说明>
     </p>
     * @param clazz
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return ApplicationContextUtil.getInstance().getApplicationContext().getBean(clazz);
    }

}
