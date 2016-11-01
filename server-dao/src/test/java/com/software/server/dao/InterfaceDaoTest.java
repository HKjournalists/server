package com.software.server.dao;

import com.software.server.dao.mapper.InterfaceMapper;
import com.software.server.dao.model.InterfaceModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by jk on 16/7/22.
 */
public class InterfaceDaoTest extends BaseTest {

    @Autowired
    private InterfaceMapper mapper;

    @Test
    public void testInsert(){
        InterfaceModel model = new InterfaceModel();
        model.setCreateTime(new Date());
        model.setModule(7);
        model.setName("用户信息查询");
        model.setAbnormalJson("dddddd");
        model.setNormalJson("drrddd");
        model.setUrl("user/info/query1");
        mapper.insert(model);
    }

    @Test
    public void testFindById(){
        InterfaceModel item = mapper.findById(1);
        System.out.println("item = " + item);
    }

    @Test
    public void testUpdateByUrl(){
        InterfaceModel model = new InterfaceModel();
        model.setUrl("user/login");
        model.setCreateTime(new Date());
        model.setName("用户注册");
        int rows = mapper.updateByUrl(model);
        System.out.println("rows = " + rows);
    }

    @Test
    public void testFindAll(){
        List<InterfaceModel> list = mapper.findAll();
        System.out.println("list = " + list);
    }

    @Test
    public void testFindByModuleId(){
        List<InterfaceModel> list = mapper.findByModule(1);
        System.out.println("list = " + list);
    }


}
