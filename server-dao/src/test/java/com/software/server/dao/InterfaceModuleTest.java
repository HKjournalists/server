package com.software.server.dao;

import com.software.server.dao.mapper.InterfaceModuleMapper;
import com.software.server.dao.model.InterfaceModuleModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jk on 16/7/24.
 */
public class InterfaceModuleTest extends BaseTest {

    @Autowired
    private InterfaceModuleMapper mapper;

    @Test
    public void testSave(){
        InterfaceModuleModel model = new InterfaceModuleModel();
        model.setCreateTime(new Date());
        model.setZhName("登录模块");
        model.setEnName("login12");
        int rows = mapper.insert(model);
        System.out.println("save success ? " + (rows > 0));
    }

    @Test
    public void testFindById(){
        InterfaceModuleModel item = mapper.findById(1);
        System.out.println("findById item = " + item);
    }

    @Test
    public void testFindAll(){
        List<InterfaceModuleModel> list = mapper.findAll();
        System.out.println("find all list = " + list);
    }

    @Test
    public void testInsertByBatch(){
        InterfaceModuleModel model = new InterfaceModuleModel();
        model.setCreateTime(new Date());
        model.setZhName("登录模块1");
        model.setEnName("login1");
        InterfaceModuleModel model1 = new InterfaceModuleModel();
        model1.setCreateTime(new Date());
        model1.setZhName("登录模块2");
        model1.setEnName("login2");
        InterfaceModuleModel model2 = new InterfaceModuleModel();
        model2.setCreateTime(new Date());
        model2.setZhName("登录模块3");
        model2.setEnName("login");
        InterfaceModuleModel model3 = new InterfaceModuleModel();
        model3.setCreateTime(new Date());
        model3.setZhName("登录模块4");
        model3.setEnName("login4");
        List<InterfaceModuleModel> list = new ArrayList<InterfaceModuleModel>();
        list.add(model);
        list.add(model1);
        list.add(model2);
        list.add(model3);
        int rows = mapper.insertByBatch(list);
        System.out.println("insert rows = " + rows);
    }

    @Test
    public void testDeleteById(){
        int rows = mapper.delete(1);
        System.out.println("delete rows = " + rows);
    }

    @Test
    public void testUpdate(){
        InterfaceModuleModel model = new InterfaceModuleModel();
        model.setId(2);
        model.setCreateTime(new Date());
        model.setZhName("注册模块");
        model.setEnName("register");
        int rows = mapper.update(model);
        System.out.println("update rows = " + rows);
    }

    @Test
    public void testFindByEnName(){
        InterfaceModuleModel item = mapper.findByEnName("login");
        System.out.println("findByEnName item = " + item);
    }

    @Test
    public void testUpdateByEnName(){
        InterfaceModuleModel model = new InterfaceModuleModel();
        model.setEnName("login");
        model.setCreateTime(new Date());
        model.setZhName("注册模块");
        int rows = mapper.updateByEnName(model);
        System.out.println("update rows = " + rows);
    }
}
