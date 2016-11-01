package com.software.server.service.interfaces.impl;

import com.software.server.common.constant.UserLoginTypeEnum;
import com.software.server.common.service.BaseService;
import com.software.server.common.utils.ObjectUtils;
import com.software.server.dao.mapper.ResourceMapper;
import com.software.server.dao.model.ResourceModel;
import com.software.server.service.interfaces.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 权限相关
 */
@Service
public class ResourceServiceImpl extends BaseService implements IResourceService{

    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * 根据状态查询资源信息
     * @param status
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<ResourceModel> listByStatus(String status) {
        return resourceMapper.listByStatus(status);
    }


    /**
     * 保存资源
     * @param resource
     * @return
     */
    @Transactional
    public boolean saveRes(ResourceModel resource){
       if (ObjectUtils.isNotEmpty(resource)){
           return resourceMapper.insert(resource) > 0;
       }else{
           return false;
       }
    }

    @Transactional(readOnly = true)
    @Override
    public List<ResourceModel> findByEmail(String email) {
        return resourceMapper.findByUser(email, UserLoginTypeEnum.EMAIL.getKey());
    }

    @Transactional(readOnly = true)
    @Override
    public List<ResourceModel> findByUsername(String username) {
        return resourceMapper.findByUser(username, UserLoginTypeEnum.USERNAME.getKey());
    }

    @Transactional(readOnly = true)
    @Override
    public List<ResourceModel> findByMobile(String mobile) {
        return resourceMapper.findByUser(mobile, UserLoginTypeEnum.MOBILE.getKey());
    }
}
