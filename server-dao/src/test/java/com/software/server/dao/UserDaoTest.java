package com.software.server.dao;

import com.software.server.common.constant.*;
import com.software.server.common.utils.CommonUtils;
import com.software.server.common.utils.RandomNumberUtil;
import com.software.server.dao.mapper.UserMapper;
import com.software.server.dao.model.UserModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Date;
import java.util.List;


public class UserDaoTest extends BaseTest{

    @Autowired
    private UserMapper userMapper;


    //@Test
    public void testSaveUser(){
        UserModel userModel = new UserModel();
        userModel.setEmail("liys@goldcard-china.com");
        userModel.setBirthday(new Date());
        userModel.setUserName("lihuiyao1986");
        userModel.setRealName("李焱生");
        userModel.setMobile("13606603642");
        userModel.setQQ("251368552");
        userModel.setSex(SexEnum.MAN.getKey());
        userModel.setStatus(UserStatusEnum.UNVERIFIED.getKey());
        userModel.setMobileStatus(UserMobileStatusEnum.UNVERIFIED.getKey());
        userModel.setEmailStatus(UserEmailStatusEnum.UNVERIFIED.getKey());
        userModel.setUserProperty(UserPropertyEnum.B.getKey());
        userModel.setUserType(UserTypeEnum.P.getKey());
        userModel.setLoginTime(new Date());
        userModel.setLoginCount(1);
        userModel.setLastLoginTime(new Date());
        userModel.setLoginDeviceId(1);
        userModel.setLoginIP("127.0.0.1");
        userModel.setGrade(UserGradeEnum.CROWN.getKey());
        userModel.setSalt(RandomNumberUtil.getSalt());
        userModel.setPassword(CommonUtils.EncryptPassword(RandomNumberUtil.getPassword(),RandomNumberUtil.getSalt()));
        userModel.setAvatar("http://c.hiphotos.baidu.com/imgad/pic/item/b21c8701a18b87d65dae0a7a000828381e30fde3.jpg");
        userModel.setRegTime(new Date());
        userMapper.insert(userModel);
    }


    //@Test
    public void testUpdateUser(){
        UserModel userModel = new UserModel();
        userModel.setUserId(1);
        userModel.setUserName("网民123");
        userMapper.update(userModel);
    }

    //@Test
    public void testGetUserByEmail(){
        UserModel list = userMapper.getByEmail("liys@goldcard-china.com");
        System.out.println(list);
    }


    @Test
    public void testGetUserByMobile(){
        UserModel list = userMapper.getByMobile("13606603642");
        System.out.println(list);
    }

    //@Test
    public void testGetUserById(){
        UserModel userModel = userMapper.get(1);
        System.out.println(userModel);
    }
}
