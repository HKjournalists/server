package com.software.server.common.utils;

import com.software.server.common.constant.Constants;
import com.software.server.common.exception.ApplicationException;

/**
 * Created by jk on 16/6/12.
 */
public class RandomNumberUtil {

    /**
     * 获取短信验证码
     *
     * @return
     * @throws Exception
     */
    public static String getValidationCode() {

        String validationCode = "";
        try {
            // 默认生成4位的数字短信验证码
            validationCode = RandomCodeUtil.getRandomCode();
        }catch (Exception e) {
            throw new ApplicationException(Constants.DEFAULT_ERROR_CODE);
        }

        return validationCode;
    }

    /**
     * 随机生成盐
     */
    public static String getSalt() {
        String salt = "";
        try {
            salt = RandomCodeUtil.getRandomCode(6, RandomCodeUtil.RandomCodeLevel.MEDIUM, true).toUpperCase();
        }catch (Exception e) {
            throw new ApplicationException(Constants.DEFAULT_ERROR_CODE);
        }
        return salt;
    }

    public static String getPassword() {
        String password = "";
        try {
            password = RandomCodeUtil.getRandomCode(6, RandomCodeUtil.RandomCodeLevel.SIMPLE, false);
        }catch (Exception e) {
            throw new ApplicationException(Constants.DEFAULT_ERROR_CODE);
        }
        return password;
    }

}
