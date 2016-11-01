package com.software.server.common.constant;

/**
 * 用户邮箱认证状态
 */
public enum UserEmailStatusEnum {

    UNVERIFIED("0","未认证"),VERIFIED("1","已认证");

    private UserEmailStatusEnum(String key, String value){
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

    public static UserEmailStatusEnum fromRaw(String key){
        UserEmailStatusEnum result = UserEmailStatusEnum.UNVERIFIED;
        for (UserEmailStatusEnum e: UserEmailStatusEnum.values()) {
            if (e.getKey().equals(key)) {
                return e;
            }
        }
        return result;
    }

}
