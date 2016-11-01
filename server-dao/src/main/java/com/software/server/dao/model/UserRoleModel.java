package com.software.server.dao.model;

import com.software.server.dao.base.BaseDaoModel;

/**
 * 用户角色
 */
public class UserRoleModel extends BaseDaoModel {

    private long id;

    // 角色ID
    private long roleId;

    // 用户ID
    private long userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
