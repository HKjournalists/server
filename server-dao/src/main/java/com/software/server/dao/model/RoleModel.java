package com.software.server.dao.model;

import com.software.server.dao.base.BaseDaoModel;


/**
 * 角色实体类
 */
public class RoleModel extends BaseDaoModel {

    // id
    private long id;

    // 角色名称
    private String roleName;

    // 角色值
    private String roleValue;

    // 角色状态 0-正常 1-已删除
    private String roleStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(String roleValue) {
        this.roleValue = roleValue;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }

    @Override
    public String toString() {
        return "RoleModel{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleValue='" + roleValue + '\'' +
                ", roleStatus='" + roleStatus + '\'' +
                '}';
    }
}
