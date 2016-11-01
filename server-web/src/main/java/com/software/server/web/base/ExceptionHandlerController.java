package com.software.server.web.base;

import com.software.server.common.constant.Constants;
import com.software.server.common.exception.BaseException;
import com.software.server.common.model.RespEntity;
import com.software.server.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * 处理所有的异常
 */
@ControllerAdvice
public class ExceptionHandlerController {

    @Autowired
    private MessageSource messageSource;

    /**
     * 处理异常
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RespEntity handleException(Exception ex,HttpServletRequest request){
        RespEntity model = new RespEntity ();
        String errorcode = Constants.DEFAULT_ERROR_CODE;
        String errorMsg;
        if (ex instanceof BaseException) {
            BaseException baseException = (BaseException) ex;
            errorcode = StringUtils.trimNull(baseException.getErrorCode());
            errorMsg = StringUtils.trimNull (baseException.getMessage ());
            errorMsg = messageSource.getMessage (errorcode, baseException.getArgs (), errorMsg, Locale.getDefault ());
        } else {
            errorMsg = messageSource.getMessage (errorcode, null, StringUtils.trimNull(ex.getMessage(),"服务器忙，稍后重试"), Locale.getDefault());
        }
        model.setErrorcode(errorcode);
        model.setErrormsg(errorMsg);
        return model;
    }
}
