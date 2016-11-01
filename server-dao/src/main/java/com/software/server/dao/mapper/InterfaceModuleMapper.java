package com.software.server.dao.mapper;

import com.software.server.dao.base.CrudMapper;
import com.software.server.dao.base.MyBatisMapper;
import com.software.server.dao.model.InterfaceModuleModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 接口模块
 */
@MyBatisMapper
public interface InterfaceModuleMapper extends CrudMapper<InterfaceModuleModel>{

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public InterfaceModuleModel findById(@Param("id")long id);

    /**
     * 查询所有
     * @return
     */
    public List<InterfaceModuleModel> findAll();

    /**
     * 批量插入
     * @param list
     * @return
     */
    public int insertByBatch(List<InterfaceModuleModel> list);

    /**
     * 根据英文名查询接口模块信息
     * @param enName
     * @return
     */
    public InterfaceModuleModel findByEnName(@Param("enName")String enName);

    /**
     * 根据英文名更新
     * @param model
     * @return
     */
    public int updateByEnName(InterfaceModuleModel model);

    /**
     * 根据ID删除模块
     * @param id
     * @return
     */
    public int deleteById(@Param("id")long id);
}
