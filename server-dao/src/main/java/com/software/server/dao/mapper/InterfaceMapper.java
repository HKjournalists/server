package com.software.server.dao.mapper;

import com.software.server.dao.base.CrudMapper;
import com.software.server.dao.base.MyBatisMapper;
import com.software.server.dao.model.InterfaceModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 接口mapper
 */
@MyBatisMapper
public interface InterfaceMapper extends CrudMapper<InterfaceModel> {

    /**
     * 根据ID查询接口
     * @param id
     * @return
     */
    public InterfaceModel findById(@Param("id") long id);

    /**
     * 根据url查询接口
     * @param url
     * @return
     */
    public InterfaceModel findByUrl(@Param("url")String url);

    /**
     * 查询所有的接口
     * @return
     */
    public List<InterfaceModel> findAll();

    /**
     * 根据url更新
     * @param model
     * @return
     */
    public int updateByUrl(InterfaceModel model);

    /**
     * 根据模块查询接口
     * @param moduleId
     * @return
     */
    public List<InterfaceModel> findByModule(@Param("moduleId")long moduleId);
}
