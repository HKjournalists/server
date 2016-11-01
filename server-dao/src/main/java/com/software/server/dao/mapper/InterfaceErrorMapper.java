package com.software.server.dao.mapper;


import com.software.server.dao.base.CrudMapper;
import com.software.server.dao.base.MyBatisMapper;
import com.software.server.dao.model.InterfaceErrorModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisMapper
public interface InterfaceErrorMapper extends CrudMapper<InterfaceErrorModel> {

    /**
     * 查询所有的错误代码
     * @return
     */
    public List<InterfaceErrorModel> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public InterfaceErrorModel findById(@Param("id") long id);


    /**
     * 根据接口查询
     * @param interfaceId
     * @return
     */
    public List<InterfaceErrorModel> findByInterfaceId(@Param("interfaceId") long interfaceId);

    /**
     * 批量插入
     * @param list
     * @return
     */
    public int insertByBatch(List<InterfaceErrorModel> list);


    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public int deleteById(@Param("id") long id);

    /**
     * 根据接口删除
     * @param interfaceId
     * @return
     */
    public int deleteByInterfaceId(@Param("interfaceId") long interfaceId);
}
