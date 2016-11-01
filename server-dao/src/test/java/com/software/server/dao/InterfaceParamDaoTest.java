package com.software.server.dao;

import com.software.server.common.exception.SystemException;
import com.software.server.dao.mapper.InterfaceParamMapper;
import com.software.server.dao.model.InterfaceParamModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jk on 16/7/22.
 */
public class InterfaceParamDaoTest extends BaseTest {

    @Autowired
    private InterfaceParamMapper mapper;


    //@Test
    public void testInsert(){
        InterfaceParamModel item = new InterfaceParamModel();
        item.setEnName("mobile");
        item.setZhName("手机号码");
        item.setCreateTime(new Date());
        item.setDemo("dddd");
        item.setDesc("手机号码");
        item.setInterfaceId(1);
        item.setIsCommon("0");
        item.setRequire("1");
        item.setType("1");
        int rows =  mapper.insert(item);
        System.out.println("rows = " + rows);
    }

    //@Test
    public void testInsertByBatch(){

        InterfaceParamModel item = new InterfaceParamModel();
        item.setEnName("mobileCode");
        item.setZhName("手机验证码");
        item.setCreateTime(new Date());
        item.setDemo("123456");
        item.setDesc("手机验证码");
        item.setInterfaceId(1);
        item.setIsCommon("0");
        item.setRequire("0");
        item.setType("0");

        InterfaceParamModel item1 = new InterfaceParamModel();
        item1.setEnName("userId");
        item1.setZhName("用户ID");
        item1.setCreateTime(new Date());
        item1.setDemo("dedddddd");
        item1.setDesc("用户ID");
        item1.setInterfaceId(1);
        item1.setIsCommon("0");
        item1.setRequire("0");
        item1.setType("0");

        List<InterfaceParamModel> list = new ArrayList<InterfaceParamModel>();
        list.add(item);
        list.add(item1);

        int rows =  mapper.insertByBatch(list);

        System.out.println("rows = " + rows);

    }

    //@Test
    public void testQueryByInterfaceId(){
        List<InterfaceParamModel> list = mapper.findByInterfaceId(1);
        System.out.println("list = " + list);

    }

    //@Test
    public void testFindById(){
        InterfaceParamModel item =  mapper.findById(4);
        System.out.println("item = " + item);
    }

    //@Test
    public void testDeleteById(){
        int rows =  mapper.deleteById(4);
        System.out.println("rows = " + rows);
    }

    @Test
    public void testUpdateById(){
        InterfaceParamModel item = new InterfaceParamModel();
        item.setId(1);
        item.setEnName("phoneCode");
        int rows = mapper.update(item);
        System.out.println("rows = " + rows);
    }

    //@Test
    public void testDeleteByInterfaceId(){
        int rows = mapper.deleteByInterfaceId(1);
        System.out.println("rows = " + rows);
    }

}
