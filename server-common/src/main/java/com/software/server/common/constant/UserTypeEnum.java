package com.software.server.common.constant;

/**
 * 用户类型枚举
 */
public enum  UserTypeEnum {

    P("0","个人用户"),O("1","机构用户");

    private UserTypeEnum(String key, String value){
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

    public static UserTypeEnum fromRaw(String key){
        UserTypeEnum result = UserTypeEnum.P;
        for (UserTypeEnum e: UserTypeEnum.values()) {
            if (e.getKey().equals(key)) {
                return e;
            }
        }
        return result;
    }

}
