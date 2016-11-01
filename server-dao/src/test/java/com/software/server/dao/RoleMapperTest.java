package com.software.server.dao;

import com.software.server.common.constant.RoleStatusEnum;
import com.software.server.common.constant.UserLoginTypeEnum;
import com.software.server.dao.mapper.RoleMapper;
import com.software.server.dao.model.RoleModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Created by jk on 16/6/13.
 */
public class RoleMapperTest extends BaseTest {

    @Autowired
    private RoleMapper mapper;


    //@Test
    public void testListByStatus(){
       List<RoleModel> list = mapper.listByStatus(RoleStatusEnum.DELETED.getKey());
        System.out.println(list);
    }

    //@Test
    public void testInsertRole(){
        RoleModel roleModel = new RoleModel();
        roleModel.setRoleName("管理员");
        roleModel.setRoleStatus(RoleStatusEnum.NORMAL.getKey());
        roleModel.setRoleValue("super:manager");
        mapper.insert(roleModel);
    }

    //@Test
    public void testDeleteRole(){
        mapper.delete(1);
    }

    @Test
    public void testGetByUserInfo(){
      List<RoleModel> list = mapper.findByUserInfo("13606603642", UserLoginTypeEnum.MOBILE.getKey());
        System.out.println(list);
    }

}
