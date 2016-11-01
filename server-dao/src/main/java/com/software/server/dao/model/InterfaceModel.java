package com.software.server.dao.model;

import com.software.server.dao.base.BaseDaoModel;

import java.util.Date;

/**
 * 接口DAO实体类
 */
public class InterfaceModel extends BaseDaoModel {

    // 主键id
    private long id;

    // 请求方法
    private String method;

    // 接口名称
    private String name;

    // 接口url
    private String url;

    // 模块名
    private long moduleId;

    // 正常的demo json
    private String normalJson;

    // 异常的demo json
    private String abnormalJson;

    // 创建时间
    private Date createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModule(long moduleId) {
        this.moduleId = moduleId;
    }

    public String getNormalJson() {
        return normalJson;
    }

    public void setNormalJson(String normalJson) {
        this.normalJson = normalJson;
    }

    public String getAbnormalJson() {
        return abnormalJson;
    }

    public void setAbnormalJson(String abnormalJson) {
        this.abnormalJson = abnormalJson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "InterfaceModel{" +
                "id=" + id +
                ", method='" + method + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", moduleId='" + moduleId + '\'' +
                ", normalJson='" + normalJson + '\'' +
                ", abnormalJson='" + abnormalJson + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
