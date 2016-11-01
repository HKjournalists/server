package com.software.server.dao.model;

import com.software.server.dao.base.BaseDaoModel;

/**
 * 权限
 */
public class ResourceModel extends BaseDaoModel {

    // ID 主键
    private long id;

    // 资源名称
    private String resName;

    // 资源key
    private String resKey;

    // 资源value
    private String resValue;

    // 资源类型
    private String resType;

    // 资源状态 0-正常 1-已删除
    private String resStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResKey() {
        return resKey;
    }

    public void setResKey(String resKey) {
        this.resKey = resKey;
    }

    public String getResValue() {
        return resValue;
    }

    public void setResValue(String resValue) {
        this.resValue = resValue;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public String getResStatus() {
        return resStatus;
    }

    public void setResStatus(String resStatus) {
        this.resStatus = resStatus;
    }

    @Override
    public String toString() {
        return "ResourceModel{" +
                "id=" + id +
                ", resName='" + resName + '\'' +
                ", resKey='" + resKey + '\'' +
                ", resValue='" + resValue + '\'' +
                ", resType='" + resType + '\'' +
                ", resStatus='" + resStatus + '\'' +
                '}';
    }
}
