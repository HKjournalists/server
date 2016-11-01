package com.software.server.common.constant;

/**
 * 用户手机认证状态枚举
 */
public enum UserMobileStatusEnum {

    UNVERIFIED("0","未认证"),VERIFIED("1","已认证");

    private UserMobileStatusEnum(String key, String value){
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

    public static UserMobileStatusEnum fromRaw(String key){
        UserMobileStatusEnum result = UserMobileStatusEnum.UNVERIFIED;
        for (UserMobileStatusEnum e: UserMobileStatusEnum.values()) {
            if (e.getKey().equals(key)) {
                return e;
            }
        }
        return result;
    }

}
