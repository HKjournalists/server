package com.software.server.dao.mapper;

import com.software.server.dao.base.CrudMapper;
import com.software.server.dao.base.MyBatisMapper;
import com.software.server.dao.model.UserLoginModel;

/**
 * 用户登录信息
 */
@MyBatisMapper
public interface UserLoginMapper extends CrudMapper<UserLoginModel> {

    /**
     * 根据用户ID和登录类型更新用户的登录信息
     * @param model
     */
    public void updateByUserIDAndLoginType(UserLoginModel model);


    /**
     * 根据用户ID和登录类型查询用户的登录信息
     * @param userId
     * @param loginType
     * @return
     */
    public UserLoginModel getByUserIDAndLoginType(String userId,String loginType);


    /**
     * 根据登录名查询用户的登录信息
     * @param loginName
     * @return
     */
    public UserLoginModel getByLoginName(String loginName);
}
