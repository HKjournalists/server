package com.software.server.web.base;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.util.Log4jConfigListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by jk on 16/5/31.
 */
@Order(1)
public class CommonWebInitializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        servletContext.setInitParameter("webAppRootKey","software.root");

        // 配置log4j
        servletContext.setInitParameter("log4jConfigLocation", "/WEB-INF/log/log4j.properties");
        servletContext.addListener(Log4jConfigListener.class);

    }
}
