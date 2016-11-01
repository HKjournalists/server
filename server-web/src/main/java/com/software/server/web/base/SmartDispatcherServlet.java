package com.software.server.web.base;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Map;

/**
 * Created by jk on 16/5/31.
 */
public class SmartDispatcherServlet extends DispatcherServlet {

    public SmartDispatcherServlet() {
        super();
    }

    public SmartDispatcherServlet(WebApplicationContext webApplicationContext) {
        super(webApplicationContext);
    }

    @Override
    protected View resolveViewName(String viewName, Map<String, Object> model, Locale locale, HttpServletRequest request) throws Exception {
        // viewName 中无前缀时，根据不同设备冲重写 viewName
//        if(StringUtils.hasText(viewName) && !viewName.contains(":")) {
//            // 当前设备
//            Device device = DeviceUtils.getRequiredCurrentDevice(request);
//            if(device.isMobile()) {
//                viewName = "mobile/" + viewName;
//            } else if(device.isTablet()) {
//                viewName = "tablet/" + viewName;
//            } else {
//                viewName = "normal/" + viewName;
//            }
//        }
        return super.resolveViewName(viewName, model, locale, request);
    }

}
