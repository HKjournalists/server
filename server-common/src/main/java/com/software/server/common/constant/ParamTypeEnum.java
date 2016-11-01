package com.software.server.common.constant;

/**
 * 参数类型
 */
public enum ParamTypeEnum {

    // 字符串类型
    STRINGTYPE("00","String"),
    // 整型
    INTTYPE("01","Int"),
    // 浮点型
    DOUBLETYPE("02","Double"),
    // 日期类型
    DATETYPE("03","Date"),
    // 对象类型
    OBJECTTYPE("04","Object");

    private ParamTypeEnum(String key,String value){
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

    public static ParamTypeEnum fromRaw(String key){
        ParamTypeEnum result = ParamTypeEnum.STRINGTYPE;
        for (ParamTypeEnum e: ParamTypeEnum.values()) {
            if (e.getKey().equals(key)) {
                return e;
            }
        }
        return result;
    }
}
