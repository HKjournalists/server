package com.software.server.common.constant;

/**
 * 性别
 */
public enum SexEnum {

    MAN("0","男"),WOMAN("1","女"),UNKOWM("2","未知");

    private SexEnum(String key,String value){
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

    public static SexEnum fromRaw(String key){
        SexEnum result = SexEnum.UNKOWM;
        for (SexEnum e: SexEnum.values()) {
            if (e.getKey().equals(key)) {
                return e;
            }
        }
        return result;
    }
}
