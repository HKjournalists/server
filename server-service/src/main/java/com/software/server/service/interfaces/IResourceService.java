package com.software.server.service.interfaces;

import com.software.server.dao.model.ResourceModel;

import java.util.List;

/**
 * 权限相关
 */
public interface IResourceService {

    /**
     * 查询所有权限
     * @return
     */
    public List<ResourceModel> listByStatus(String status);

    /**
     * 保存资源
     * @param resource
     * @return
     */
    public boolean saveRes(ResourceModel resource);


    /**
     * 按照邮箱查询
     * @param email
     * @return
     */
    public List<ResourceModel> findByEmail(String email);


    /**
     * 按照用户名查询
     * @param username
     * @return
     */
    public List<ResourceModel> findByUsername(String username);


    /**
     * 按照手机号查询
     * @param mobile
     * @return
     */
    public List<ResourceModel> findByMobile(String mobile);

}
