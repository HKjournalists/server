package com.software.server.common.model;

import com.software.server.common.constant.Constants;
import com.software.server.common.utils.StringUtils;

/**
 * 响应bean
 */
public class RespEntity <T extends Object> {

    private T result;

    private String errormsg = Constants.SUCCESS_MSG;

    private String errorcode = Constants.SUCCESS_CODE;

    private boolean successfull = true;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public boolean isSuccessfull() {
        return Constants.SUCCESS_CODE.equals(StringUtils.trimNull(errorcode));
    }
}
