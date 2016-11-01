package com.software.server.dao.mapper;

import com.software.server.dao.base.CrudMapper;
import com.software.server.dao.base.MyBatisMapper;
import com.software.server.dao.model.RoleResModel;

import java.util.List;

/**
 * 角色资源
 */
@MyBatisMapper
public interface RoleResMapper extends CrudMapper<RoleResModel> {

    public List<RoleResModel> listAll();

    public List<RoleResModel> listByRoleId(long roleId);

    public List<RoleResModel> listById(long id);

    public int deleteById(long id);

    public int deleteByRoleId(long roleId);

}
