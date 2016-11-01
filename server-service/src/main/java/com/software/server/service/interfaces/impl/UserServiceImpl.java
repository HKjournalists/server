package com.software.server.service.interfaces.impl;

import com.software.server.common.utils.ObjectUtils;
import com.software.server.common.utils.StringUtils;
import com.software.server.dao.mapper.UserMapper;
import com.software.server.dao.model.UserModel;
import com.software.server.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserMapper userMapper;


    @Transactional(readOnly = true)
    @Override
    public UserModel findByEmail(String email) {
        if (StringUtils.isNotEmpty(email)){
            return userMapper.getByEmail(StringUtils.trimNull(email));
        }else{
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public UserModel findByUsername(String username) {
        if (StringUtils.isNotEmpty(username)){
            return userMapper.getByUsername(StringUtils.trimNull(username));
        }else{
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public UserModel findByMobile(String mobile) {
        if (StringUtils.isNotEmpty(mobile)){
            return userMapper.getByMobile(StringUtils.trimNull(mobile));
        }else{
            return null;
        }
    }


    /**
     * 保存用户信息
     * @param userModel
     * @return
     */
    @Transactional
    @Override
    public boolean saveUser(UserModel userModel){
        if (ObjectUtils.isNotEmpty(userModel)){
           return userMapper.insert(userModel) > 0;
        }else{
            return false;
        }
    }
}
