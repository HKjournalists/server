package com.software.server.dao.mapper;

import com.software.server.dao.base.CrudMapper;
import com.software.server.dao.base.MyBatisMapper;
import com.software.server.dao.model.InterfaceRespModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 接口响应类接口
 */
@MyBatisMapper
public interface InterfaceRespMapper extends CrudMapper<InterfaceRespModel> {


    /**
     * 根据id查询
     * @param id
     * @return
     */
    public InterfaceRespModel findById(@Param("id")long id);

    /**
     * 根据接口ID查询
     * @param interfaceId
     * @return
     */
    public List<InterfaceRespModel> findByInterfaceId(@Param("interfaceId")long interfaceId);

    /**
     * 根据pid和interfaceID查询
     * @param pid
     * @param interfaceId
     * @return
     */
    public List<InterfaceRespModel> findByPIDAndInterfaceId(@Param("pid")long pid,@Param("interfaceId")long interfaceId);

    /**
     * 查询公共参数
     * @return
     */
    public List<InterfaceRespModel> findCommons();

    /**
     * 批量保存
     * @param list
     * @return
     */
    public int insertByBatch(List<InterfaceRespModel> list);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public int deleteById(@Param("id")long id);

    /**
     * 根据interfaceId删除
     * @param interfaceId
     * @return
     */
    public int deleteByInterfaceId(@Param("interfaceId")long interfaceId);

    /**
     * 根据接口ID查询该接口对应的根响应参数
     * @param interfaceId
     * @return
     */
    public List<InterfaceRespModel> findRootInterfaceRespByInterfaceId(@Param("interfaceId")long interfaceId);
}

