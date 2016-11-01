package com.software.server.dao.mapper;

import com.software.server.dao.base.CrudMapper;
import com.software.server.dao.base.MyBatisMapper;
import com.software.server.dao.model.RoleModel;
import com.software.server.dao.model.UserModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色
 */
@MyBatisMapper
public interface RoleMapper extends CrudMapper<RoleModel>{

    /**
     * 获取所有的权限列表
     * @return
     */
    public List<RoleModel> listByStatus(@Param("roleStatus") String roleStatus);


    /**
     * 根据用户信息查询用户的角色
     * @param userInfo
     * @param type 参照UserLoginTypeEnum
     * @return
     */
    public List<RoleModel> findByUserInfo(@Param("userInfo")String userInfo,@Param("type")String type);
}
