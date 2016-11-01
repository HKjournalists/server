package com.software.server.dao.mapper;

import com.software.server.dao.base.CrudMapper;
import com.software.server.dao.base.MyBatisMapper;
import com.software.server.dao.model.ResourceModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jk on 16/6/8.
 */
@MyBatisMapper
public interface ResourceMapper extends CrudMapper<ResourceModel>{

    /**
     * 检索所有权限
     * @return
     */
    public List<ResourceModel> listByStatus(@Param("resStatus") String resStatus);

    /**
     * 根据用户信息查询用户的权限
     * @param userInfo
     * @param type
     * @return
     */
    public List<ResourceModel> findByUser(@Param("userInfo")String userInfo,@Param("type")String type);

}
