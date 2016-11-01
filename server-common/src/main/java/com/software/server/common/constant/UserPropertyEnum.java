package com.software.server.common.constant;

/**
 * 用户属性枚举
 */
public enum  UserPropertyEnum {

    C("C","C端用户"),B("B","B端用户");

    private UserPropertyEnum(String key, String value){
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

    public static UserPropertyEnum fromRaw(String key){
        UserPropertyEnum result = UserPropertyEnum.C;
        for (UserPropertyEnum e: UserPropertyEnum.values()) {
            if (e.getKey().equals(key)) {
                return e;
            }
        }
        return result;
    }

}
