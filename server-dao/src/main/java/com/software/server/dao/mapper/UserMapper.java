package com.software.server.dao.mapper;

import com.software.server.dao.base.CrudMapper;
import com.software.server.dao.base.MyBatisMapper;
import com.software.server.dao.model.UserModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 用户mapper
 */
@MyBatisMapper
public interface UserMapper extends CrudMapper<UserModel> {

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    public UserModel getByEmail(String email);


    /**
     * 根据手机号码查询查询用户信息
     * @param mobile
     * @return
     */
    public UserModel getByMobile(String mobile);


    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    public UserModel getByUsername(String userName);


}
