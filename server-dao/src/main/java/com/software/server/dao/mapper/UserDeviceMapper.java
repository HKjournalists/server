package com.software.server.dao.mapper;

import com.software.server.dao.base.CrudMapper;
import com.software.server.dao.base.MyBatisMapper;
import com.software.server.dao.model.UserDeviceModel;

import java.util.List;

/**
 * 用户设备信息
 */
@MyBatisMapper
public interface UserDeviceMapper extends CrudMapper<UserDeviceModel> {

    public List<UserDeviceModel> getByUserId(long userId);

}
