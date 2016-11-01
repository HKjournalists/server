package com.software.server.common.utils;

import com.software.server.common.constant.Constants;
import com.software.server.common.exception.ApplicationException;

/**
 * Created by jk on 16/6/12.
 */
public class CommonUtils {

    /**
     * 用户密码加密
     * @param sourcePassword
     * @param salt
     * @return
     * @throws Exception
     */
    public static String EncryptPassword(String sourcePassword, String salt) {
        try {
            String key = MD5Encrypt.EncodeMD5Hex(salt);
            String key8 = key.substring(0, 8).toUpperCase();
            String password = DESEncrypt.encryptForString(sourcePassword, key8);
            String password2 = MD5Encrypt.EncodeMD5Hex(password + MD5Encrypt.EncodeMD5Hex(salt));
            return password2;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApplicationException(e, Constants.DEFAULT_ERROR_CODE);
        }
    }
}
