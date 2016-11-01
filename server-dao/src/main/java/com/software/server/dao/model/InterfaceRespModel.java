package com.software.server.dao.model;

import com.software.server.dao.base.BaseDaoModel;

import java.util.Date;

/**
 * 接口响应实体类
 */
public class InterfaceRespModel extends BaseDaoModel {

    // 主键ID
    private long id;

    // 参数等级
    private int level;

    // 父节点ID
    private long pid;

    // 接口
    private long interfaceId;

    // 英文参数名称
    private String enName;

    // 中文名称
    private String zhName;

    // 参数类型 响应参数类型 00-String 01-Int 02-Double 03-DATE 04-ARRAY 05-OBJECT
    private String type;

    // 是否必须 0-非必须 1-必须
    private String require;

    // 描述
    private String desc;

    // 示例
    private String demo;

    // 创建时间
    private Date createTime;

    // 是否是公共
    private String isCommon;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(long interfaceId) {
        this.interfaceId = interfaceId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIsCommon() {
        return isCommon;
    }

    public void setIsCommon(String isCommon) {
        this.isCommon = isCommon;
    }

    @Override
    public String toString() {
        return "InterfaceRespModel{" +
                "id=" + id +
                ", level=" + level +
                ", pid=" + pid +
                ", interfaceId=" + interfaceId +
                ", enName='" + enName + '\'' +
                ", zhName='" + zhName + '\'' +
                ", type='" + type + '\'' +
                ", require='" + require + '\'' +
                ", desc='" + desc + '\'' +
                ", demo='" + demo + '\'' +
                ", createTime=" + createTime +
                ", isCommon='" + isCommon + '\'' +
                '}';
    }
}
