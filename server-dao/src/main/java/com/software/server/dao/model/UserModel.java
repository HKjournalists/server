package com.software.server.dao.model;

import com.software.server.dao.base.BaseDaoModel;

import java.util.Date;

/**
 * 用户信息
 */
public class UserModel extends BaseDaoModel {

    // 用户编号
    private long userId;

    // 性别
    private String sex;

    // 用户名
    private String userName;

    // 真实姓名
    private String realName;

    // 手机号
    private String mobile;

    // 手机验证状态
    private String mobileStatus;

    // 邮箱
    private String email;

    // 邮箱验证状态
    private String emailStatus;

    // 用户状态 00-未认证 01-已认证 02-已锁定 03-已删除
    private String status;

    // 创建时间
    private Date regTime;

    // 用户属性 C:端用户 B:端用户
    private String userProperty;

    // 用户类型 0:个人用户 1:机构用户
    private String userType;

    // 生日
    private Date birthday;

    // qq号码
    private String QQ;

    // 微信号
    private String webchat;

    // 登录IP
    private String loginIP;

    // 登录次数
    private int loginCount;

    // 登录时间
    private Date loginTime;

    // 上一次登录时间
    private Date lastLoginTime;

    // 登录设备ID
    private long loginDeviceId;

    // 密码
    private String password;

    // 盐
    private String salt;

    // 头像
    private String avatar;

    // 等级
    private String grade;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobileStatus() {
        return mobileStatus;
    }

    public void setMobileStatus(String mobileStatus) {
        this.mobileStatus = mobileStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(String emailStatus) {
        this.emailStatus = emailStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getUserProperty() {
        return userProperty;
    }

    public void setUserProperty(String userProperty) {
        this.userProperty = userProperty;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getWebchat() {
        return webchat;
    }

    public void setWebchat(String webchat) {
        this.webchat = webchat;
    }

    public String getLoginIP() {
        return loginIP;
    }

    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    public int getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public long getLoginDeviceId() {
        return loginDeviceId;
    }

    public void setLoginDeviceId(long loginDeviceId) {
        this.loginDeviceId = loginDeviceId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", sex='" + sex + '\'' +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", mobileStatus='" + mobileStatus + '\'' +
                ", email='" + email + '\'' +
                ", emailStatus='" + emailStatus + '\'' +
                ", status='" + status + '\'' +
                ", regTime=" + regTime +
                ", userProperty='" + userProperty + '\'' +
                ", userType='" + userType + '\'' +
                ", birthday=" + birthday +
                ", QQ='" + QQ + '\'' +
                ", webchat='" + webchat + '\'' +
                ", loginIP='" + loginIP + '\'' +
                ", loginCount=" + loginCount +
                ", loginTime=" + loginTime +
                ", lastLoginTime=" + lastLoginTime +
                ", loginDeviceId=" + loginDeviceId +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", avatar='" + avatar + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
