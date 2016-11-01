package com.software.server.common.constant;

/**
 * 用户状态枚举
 */
public enum UserStatusEnum {

    UNVERIFIED("00","未认证"),VERIFIED("01","已认证"),LOCKED("02","已锁定"),DELETED("03","已删除"),BLACKLIST("04","已拉黑");

    private UserStatusEnum(String key, String value){
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

    public static UserStatusEnum fromRaw(String key){
        UserStatusEnum result = UserStatusEnum.UNVERIFIED;
        for (UserStatusEnum e: UserStatusEnum.values()) {
            if (e.getKey().equals(key)) {
                return e;
            }
        }
        return result;
    }

}
