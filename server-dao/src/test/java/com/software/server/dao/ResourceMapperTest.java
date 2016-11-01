package com.software.server.dao;

import com.software.server.common.constant.ResourceStatusEnum;
import com.software.server.common.constant.UserLoginTypeEnum;
import com.software.server.dao.base.DaoConfig;
import com.software.server.dao.mapper.ResourceMapper;
import com.software.server.dao.model.ResourceModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by jk on 16/6/8.
 */
public class ResourceMapperTest  extends BaseTest{

    @Autowired
    private ResourceMapper mapper;


    @Test
    public void testListByStatus(){
       List<ResourceModel> list = mapper.listByStatus(ResourceStatusEnum.NORMAL.getKey());
        System.out.println(list);
    }

    //@Test
    public void testInsertRes(){
        ResourceModel resourceModel = new ResourceModel();
        resourceModel.setResKey("/list/all");
        resourceModel.setResValue("sys:manager");
        resourceModel.setResStatus(ResourceStatusEnum.NORMAL.getKey());
        resourceModel.setResName("超级管理员");
        resourceModel.setResType("1");
        mapper.insert(resourceModel);
    }

    @Test
    public void testGetUserResource(){
       List<ResourceModel> resourceModels = mapper.findByUser("13606603642", UserLoginTypeEnum.MOBILE.getKey());
    }

}
