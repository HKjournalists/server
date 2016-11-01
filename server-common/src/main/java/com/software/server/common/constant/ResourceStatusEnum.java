package com.software.server.common.constant;

/**
 * 资源状态枚举
 */
public enum  ResourceStatusEnum {

    NORMAL("0","正常"),DELETED("1","已删除");

    private ResourceStatusEnum(String key,String value){
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

    public static ResourceStatusEnum fromRaw(String key){
        ResourceStatusEnum result = ResourceStatusEnum.NORMAL;
        for (ResourceStatusEnum e: ResourceStatusEnum.values()) {
            if (e.getKey().equals(key)) {
                return e;
            }
        }
        return result;
    }
}
