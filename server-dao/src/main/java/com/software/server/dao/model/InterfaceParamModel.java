package com.software.server.dao.model;

import com.software.server.dao.base.BaseDaoModel;

import java.util.Date;

public class InterfaceParamModel extends BaseDaoModel {

    private long id;

    private String enName;

    private String zhName;

    private long interfaceId;

    private String require;

    private String desc;

    private String demo;

    private String type;

    private String isCommon;

    private Date createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(long interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsCommon() {
        return isCommon;
    }

    public void setIsCommon(String isCommon) {
        this.isCommon = isCommon;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getZhName() {
        return zhName;
    }

    public void setZhName(String zhName) {
        this.zhName = zhName;
    }

    @Override
    public String toString() {
        return "InterfaceParamModel{" +
                "id=" + id +
                ", enName='" + enName + '\'' +
                ", zhName='" + zhName + '\'' +
                ", interfaceId=" + interfaceId +
                ", require='" + require + '\'' +
                ", desc='" + desc + '\'' +
                ", demo='" + demo + '\'' +
                ", type='" + type + '\'' +
                ", isCommon='" + isCommon + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
