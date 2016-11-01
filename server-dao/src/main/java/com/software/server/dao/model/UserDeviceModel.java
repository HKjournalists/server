package com.software.server.dao.model;

import com.software.server.dao.base.BaseDaoModel;

/**
 * 用户设备信息
 */
public class UserDeviceModel extends BaseDaoModel {

    // 主键ID
    private long id;

    // 用户编号
    private long userId;

    // 手机信息描述
    private String deviceInfo;

    // 手机系统的版本号
    private String deviceSysVersion;

    // 设备的宽度
    private String screenWidth;

    // 设备的高度
    private String screenHeight;

    // 手机唯一标识
    private String uuid;

    // 网络类型
    private String netType;

    // 屏幕密度
    private String density;

    // 设备系统类型 00- android 01- IOS
    private String deviceSysType;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getDeviceSysVersion() {
        return deviceSysVersion;
    }

    public void setDeviceSysVersion(String deviceSysVersion) {
        this.deviceSysVersion = deviceSysVersion;
    }

    public String getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(String screenWidth) {
        this.screenWidth = screenWidth;
    }

    public String getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(String screenHeight) {
        this.screenHeight = screenHeight;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public String getDeviceSysType() {
        return deviceSysType;
    }

    public void setDeviceSysType(String deviceSysType) {
        this.deviceSysType = deviceSysType;
    }

    @Override
    public String toString() {
        return "UserDeviceModel{" +
                "id=" + id +
                ", userId=" + userId +
                ", deviceInfo='" + deviceInfo + '\'' +
                ", deviceSysVersion='" + deviceSysVersion + '\'' +
                ", screenWidth='" + screenWidth + '\'' +
                ", screenHeight='" + screenHeight + '\'' +
                ", uuid='" + uuid + '\'' +
                ", netType='" + netType + '\'' +
                ", density='" + density + '\'' +
                ", deviceSysType='" + deviceSysType + '\'' +
                '}';
    }
}