package com.software.server.service;

import com.software.server.common.constant.*;
import com.software.server.common.utils.CommonUtils;
import com.software.server.common.utils.RandomNumberUtil;
import com.software.server.dao.model.UserModel;
import com.software.server.service.interfaces.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by jk on 16/6/14.
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private IUserService userService;

    //@Test
    public void testSaveUser(){
        UserModel userModel = new UserModel();
        userModel.setEmail("liys1@goldcard-china.com");
        userModel.setBirthday(new Date());
        userModel.setUserName("lihuiyao19861");
        userModel.setRealName("李焱生1");
        userModel.setMobile("13606603643");
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
        userModel.setPassword(CommonUtils.EncryptPassword(RandomNumberUtil.getPassword(), RandomNumberUtil.getSalt()));
        userModel.setAvatar("http://c.hiphotos.baidu.com/imgad/pic/item/b21c8701a18b87d65dae0a7a000828381e30fde3.jpg");
        userModel.setRegTime(new Date());
        boolean result = userService.saveUser(userModel);
        System.out.println("save result is " + result);
    }


    @Test
    public void testGetUser(){
       UserModel userModel = userService.findByUsername("lihuiyao1986");
        System.out.println("testGetUser result is " + userModel);
    }

}
