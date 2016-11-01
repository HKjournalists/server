package com.software.server.common.constant;

/**
 * 用户等级
 */
public enum  UserGradeEnum {

    NORMAL("00","普通会员"),GOLD("01","黄金会员"),DIAMOND("02","钻石会员"),CROWN("03","皇冠会员");

    private UserGradeEnum(String key, String value){
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

    public static UserGradeEnum fromRaw(String key){
        UserGradeEnum result = UserGradeEnum.NORMAL;
        for (UserGradeEnum e: UserGradeEnum.values()) {
            if (e.getKey().equals(key)) {
                return e;
            }
        }
        return result;
    }
}
