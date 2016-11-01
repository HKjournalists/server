package com.software.server.dao;

import com.software.server.common.exception.SystemException;
import com.software.server.dao.mapper.InterfaceRespMapper;
import com.software.server.dao.model.InterfaceRespModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jk on 16/7/22.
 */
public class InterfaceRespDaoTest extends BaseTest {

    @Autowired
    private InterfaceRespMapper mapper;

    @Test
    public void testSave(){
        InterfaceRespModel model = new InterfaceRespModel();
        model.setCreateTime(new Date());
        model.setDesc("手机号码");
        model.setInterfaceId(1);
        model.setIsCommon("1");
        model.setDemo("ddddd");
        model.setEnName("mobile");
        model.setLevel(1);
        model.setPid(2);
        model.setRequire("1");
        model.setType("10");
        model.setZhName("手机号码");
        int rows = mapper.insert(model);
        System.out.println("rows = " + rows);
    }

    @Test
    public void testFindById(){
        InterfaceRespModel model = mapper.findById(1);
        System.out.println(" model = " + model);
    }

    @Test
    public void testFindByInterfaceId(){
        List<InterfaceRespModel> list = mapper.findByInterfaceId(1);
        System.out.println(" list = " + list);
    }

    @Test
    public void testFindByPIDAndInterfaceId(){
        List<InterfaceRespModel> list = mapper.findByPIDAndInterfaceId(2, 1);
        System.out.println(" list = " + list);
    }

    @Test
    public void testFindCommons(){
        List<InterfaceRespModel> list = mapper.findCommons();
        System.out.println(" list = " + list);
    }

    @Test
    public void testDeleteById(){
        int rows = mapper.deleteById(1);
        System.out.println(" rows = " + rows);
    }

    @Test
    public void testDeleteByInterfaceId(){
        int rows = mapper.deleteByInterfaceId(1);
        System.out.println(" rows = " + rows);
    }

    @Test
    public void testInsertByBatch(){
        InterfaceRespModel model = new InterfaceRespModel();
        model.setCreateTime(new Date());
        model.setDesc("手机号码");
        model.setInterfaceId(1);
        model.setIsCommon("1");
        model.setDemo("ddddd");
        model.setEnName("mobile");
        model.setLevel(1);
        model.setPid(2);
        model.setRequire("1");
        model.setType("10");
        model.setZhName("手机号码");

        InterfaceRespModel model1 = new InterfaceRespModel();
        model1.setCreateTime(new Date());
        model1.setDesc("手机号码");
        model1.setInterfaceId(1);
        model1.setIsCommon("1");
        model1.setDemo("ddddd");
        model1.setEnName("mobile");
        model1.setLevel(1);
        model1.setPid(2);
        model1.setRequire("1");
        model1.setType("10");
        model1.setZhName("手机号码");

        InterfaceRespModel model2 = new InterfaceRespModel();
        model2.setCreateTime(new Date());
        model2.setDesc("手机号码");
        model2.setInterfaceId(1);
        model2.setIsCommon("1");
        model2.setDemo("ddddd");
        model2.setEnName("mobile");
        model2.setLevel(1);
        model2.setPid(2);
        model2.setRequire("1");
        model2.setType("10");
        model2.setZhName("手机号码");

        List<InterfaceRespModel> list = new ArrayList<InterfaceRespModel>();
        list.add(model);
        list.add(model1);
        list.add(model2);
        int rows = mapper.insertByBatch(list);
        System.out.println("rows = " + rows);
    }

}
