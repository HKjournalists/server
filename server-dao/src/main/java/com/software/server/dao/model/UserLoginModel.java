package com.software.server.dao.model;

import com.software.server.dao.base.BaseDaoModel;

/**
 * 用户登录信息
 */
public class UserLoginModel extends BaseDaoModel {

    // 主键
    private long id;

    // 登录类型 00-手机号登录 01-邮箱登录 02-用户名登录
    private String loginType;

    // 登录名
    private String loginName;

    // 用户id
    private long userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserLoginModel{" +
                "id=" + id +
                ", loginType='" + loginType + '\'' +
                ", loginName='" + loginName + '\'' +
                ", userId=" + userId +
                '}';
    }
}