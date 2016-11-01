package com.software.server.web.base;

import com.software.server.service.base.ServiceConfig;
import com.software.server.web.shiro.ShiroConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by jk on 16/5/31.
 */
@Configuration
@Import({ServiceConfig.class})
public class WebAppConfig {

}
