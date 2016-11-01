package com.software.server.dao.model;

import com.software.server.dao.base.BaseDaoModel;

import java.util.Date;

public class InterfaceErrorModel extends BaseDaoModel{

    // 主键ID
    private long id;

    // 接口ID
    private long interfaceId;

    // 错误代码
    private String code;

    // 错误描述
    private String desc;

    // 错误原因
    private String reason;

    // 创建时间
    private Date createTime;

    // 是否是公告错误代码
    private String isCommon;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
        return "InterfaceErrorModel{" +
                "id=" + id +
                ", interfaceId=" + interfaceId +
                ", code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                ", reason='" + reason + '\'' +
                ", createTime=" + createTime +
                ", isCommon='" + isCommon + '\'' +
                '}';
    }
}
