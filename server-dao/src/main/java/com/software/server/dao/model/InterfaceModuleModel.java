package com.software.server.dao.model;

import com.software.server.dao.base.BaseDaoModel;

import java.util.Date;

/**
 * 接口模块
 */
public class InterfaceModuleModel extends BaseDaoModel {

    // 主键ID
    private long id;

    // 英文名
    private String enName;

    // 中文名
    private String zhName;

    // 创建时间
    private Date createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "InterfaceModuleModel{" +
                "id=" + id +
                ", enName='" + enName + '\'' +
                ", zhName='" + zhName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
