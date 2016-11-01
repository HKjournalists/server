package com.software.server.service.interfaces;

import com.software.server.dao.model.UserModel;

/**
 * 用户信息
 */
public interface IUserService {

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    public UserModel findByEmail(String email);


    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public UserModel findByUsername(String username);


    /**
     * 根据手机号查询用户信息
     * @param mobile
     * @return
     */
    public UserModel findByMobile(String mobile);


    /**
     * 保存用户信息
     * @param userModel
     * @return
     */
    public boolean saveUser(UserModel userModel);

}
