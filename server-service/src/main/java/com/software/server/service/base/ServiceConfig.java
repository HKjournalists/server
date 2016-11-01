package com.software.server.service.base;

import com.software.server.dao.base.DaoConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Import(DaoConfig.class)
@ComponentScan(basePackages = "com.software.server.service"
        ,useDefaultFilters = false
        ,includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class, Component.class})})
public class ServiceConfig {
}
