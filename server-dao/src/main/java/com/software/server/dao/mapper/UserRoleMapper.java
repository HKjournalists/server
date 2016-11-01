package com.software.server.dao.mapper;

import com.software.server.dao.base.CrudMapper;
import com.software.server.dao.base.MyBatisMapper;
import com.software.server.dao.model.UserRoleModel;

import java.util.List;

/**
 * 用户角色
 */
@MyBatisMapper
public interface UserRoleMapper extends CrudMapper<UserRoleModel> {

    public List<UserRoleModel> listAll();

    public List<UserRoleModel> listByUserId(long userId);

    public List<UserRoleModel> listById(long id);

    public int deleteById(long id);

    public int deleteByUserId(long userId);

}
