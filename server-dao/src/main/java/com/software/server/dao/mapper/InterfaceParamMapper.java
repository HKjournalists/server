package com.software.server.dao.mapper;

import com.software.server.dao.base.CrudMapper;
import com.software.server.dao.base.MyBatisMapper;
import com.software.server.dao.model.InterfaceParamModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 接口参数mapper
 */
@MyBatisMapper
public interface InterfaceParamMapper extends CrudMapper<InterfaceParamModel> {

    /**
     * 根据ID查询参数
     * @param id
     * @return
     */
    public InterfaceParamModel findById(@Param("id") long id);

    /**
     * 根据接口ID查询接口参数
     * @param interfaceId
     * @return
     */
    public List<InterfaceParamModel> findByInterfaceId(@Param("interfaceId") long interfaceId);

    /**
     * 批量插入
     * @param list
     */
    public int insertByBatch(@Param("list")List<InterfaceParamModel> list);

    /**
     * 根据接口ID删除参数
     * @param interfaceId
     */
    public int deleteByInterfaceId(@Param("interfaceId")long interfaceId);

    /**
     * 根据ID删除参数
     * @param id
     * @return
     */
    public int deleteById(@Param("id") long id);

    /**
     * 查询所有的公告参数
     * @return
     */
    public List<InterfaceParamModel> findCommons();
}
