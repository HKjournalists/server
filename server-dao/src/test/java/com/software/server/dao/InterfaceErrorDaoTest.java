package com.software.server.dao;

import com.software.server.common.exception.SystemException;
import com.software.server.dao.mapper.InterfaceErrorMapper;
import com.software.server.dao.model.InterfaceErrorModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jk on 16/7/22.
 */
public class InterfaceErrorDaoTest extends BaseTest {

    @Autowired
    private InterfaceErrorMapper mapper;

    @Test
    public void testInsert(){
        InterfaceErrorModel model = new InterfaceErrorModel();
        model.setIsCommon("1");
        model.setInterfaceId(2);
        model.setDesc("网络异常1");
        model.setCode("9977");
        model.setCreateTime(new Date());
        model.setReason("网络异常1");
        int rows = mapper.insert(model);
        System.out.println("rows = " + rows);
    }

    @Test
    public void testFindById(){
       InterfaceErrorModel item = mapper.findById(1);
        System.out.println(" item = " + item);
    }

    @Test
    public void testFindByInterfaceId(){
        List<InterfaceErrorModel> list = mapper.findByInterfaceId(1);
        System.out.println(" list = " + list);
    }

    @Test
    public void testFindAll(){
        List<InterfaceErrorModel> list = mapper.findAll();
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

        InterfaceErrorModel model = new InterfaceErrorModel();
        model.setIsCommon("1");
        model.setInterfaceId(2);
        model.setDesc("网络异常1");
        model.setCode("9977");
        model.setCreateTime(new Date());
        model.setReason("网络异常1");

        InterfaceErrorModel model1 = new InterfaceErrorModel();
        model1.setIsCommon("0");
        model1.setInterfaceId(1);
        model1.setDesc("网络异常2");
        model1.setCode("9987");
        model1.setCreateTime(new Date());
        model1.setReason("网络异常2");

        InterfaceErrorModel model2 = new InterfaceErrorModel();
        model2.setIsCommon("0");
        model2.setInterfaceId(3);
        model2.setDesc("网络异常3");
        model2.setCode("9988");
        model2.setCreateTime(new Date());
        model2.setReason("网络异常3");

        List<InterfaceErrorModel> list = new ArrayList<InterfaceErrorModel>();
        list.add(model);
        list.add(model1);
        list.add(model2);
        int rows = mapper.insertByBatch(list);
        System.out.println(" rows = " + rows);
    }

}
