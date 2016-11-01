package com.software.server.common.constant;

/**
 * 用户登录类型
 */
public enum UserLoginTypeEnum {

    MOBILE("00","手机号登录"),EMAIL("01","邮箱登录"),USERNAME("02","用户名");

    private UserLoginTypeEnum(String key, String value){
        this.key = key;
        this.value = value;
    }

    private String key;

    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static UserLoginTypeEnum fromRaw(String key){
        UserLoginTypeEnum result = UserLoginTypeEnum.USERNAME;
        for (UserLoginTypeEnum e: UserLoginTypeEnum.values()) {
            if (e.getKey().equals(key)) {
                return e;
            }
        }
        return result;
    }
}
