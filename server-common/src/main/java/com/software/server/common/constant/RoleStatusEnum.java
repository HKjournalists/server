package com.software.server.common.constant;

/**
 * 角色状态枚举
 */
public enum  RoleStatusEnum {

    NORMAL("0","正常"),DELETED("1","已删除");

    private RoleStatusEnum(String key,String value){
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

    public static RoleStatusEnum fromRaw(String key){
        RoleStatusEnum result = RoleStatusEnum.NORMAL;
        for (RoleStatusEnum e: RoleStatusEnum.values()) {
            if (e.getKey().equals(key)) {
                return e;
            }
        }
        return result;
    }

}
