package com.software.server.service.interfaces;

import com.software.server.dao.model.RoleModel;

import java.util.List;

/**
 * 角色
 */
public interface IRoleService {

    /**
     * 根据用户名信息查询角色信息
     * @return
     */
    public List<RoleModel> findByUserName(String username);

    /**
     * 根据手机号查询用户角色
     * @param mobile
     * @return
     */
    public List<RoleModel> findByMobile(String mobile);


    /**
     * 根据邮箱查询用户角色
     * @param email
     * @return
     */
    public List<RoleModel> findByEmail(String email);

}
