package com.software.server.dao.model;

import com.software.server.dao.base.BaseDaoModel;

/**
 * 角色资源表
 */
public class RoleResModel extends BaseDaoModel {

    // 主键
    private long id;

    // 角色ID
    private long roleId;

    // 权限ID
    private long resId;

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

    public long getResId() {
        return resId;
    }

    public void setResId(long resId) {
        this.resId = resId;
    }
}
