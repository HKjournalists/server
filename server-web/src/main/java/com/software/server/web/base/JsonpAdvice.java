package com.software.server.web.base;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Created by jk on 16/6/3.
 */
@Order(2)
@ControllerAdvice(basePackages = "com.software.server.web")
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
    public JsonpAdvice() {
        super("callback", "jsonp"); //指定jsonpParameterNames
    }
}
