package com.software.server.dao;

import com.software.server.common.constant.UserLoginTypeEnum;
import com.software.server.dao.mapper.UserLoginMapper;
import com.software.server.dao.model.UserLoginModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 测试用户登录信息
 */
public class UserLoginDaoTest extends BaseTest {

    @Autowired
    private UserLoginMapper mapper;

    @Test
    public void testGetUserLoginInfoByLoginName(){
        UserLoginModel userLoginModel = mapper.getByLoginName("lihuiyao1986");
        System.out.println(userLoginModel);
    }

    //@Test
    public void testSaveLoginInfo(){
        UserLoginModel userLoginModel = new UserLoginModel();
        userLoginModel.setUserId(1);
        userLoginModel.setLoginName("lihuiyao1986");
        userLoginModel.setLoginType(UserLoginTypeEnum.USERNAME.getKey());
        int count = mapper.insert(userLoginModel);
        System.out.println(count);
    }

}
