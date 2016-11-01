package com.software.server.service.interfaces.impl;

import com.software.server.common.constant.UserLoginTypeEnum;
import com.software.server.common.service.BaseService;
import com.software.server.dao.mapper.RoleMapper;
import com.software.server.dao.model.RoleModel;
import com.software.server.service.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 角色
 */
@Service
public class RoleServiceImpl extends BaseService implements IRoleService{

    @Autowired
    private RoleMapper dao;

    @Transactional(readOnly = true)
    @Override
    public List<RoleModel> findByUserName(String username) {
        return dao.findByUserInfo(username, UserLoginTypeEnum.USERNAME.getKey());
    }

    @Transactional(readOnly = true)
    @Override
    public List<RoleModel> findByMobile(String mobile) {
        return dao.findByUserInfo(mobile, UserLoginTypeEnum.MOBILE.getKey());
    }

    @Transactional(readOnly = true)
    @Override
    public List<RoleModel> findByEmail(String email) {
        return dao.findByUserInfo(email, UserLoginTypeEnum.EMAIL.getKey());
    }
}
