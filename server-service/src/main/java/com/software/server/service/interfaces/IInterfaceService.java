package com.software.server.service.interfaces;

import com.software.server.dao.model.*;

import java.util.List;

/**
 * 接口服务
 */
public interface IInterfaceService {

    /**
     * 查询所有的接口
     * @return
     */
    public List<InterfaceModel> findAllInterfaces();

    /**
     * 根据接口查询
     * @param interfaceId
     * @return
     */
    public InterfaceModel findByInterfaceId(long interfaceId);

    /**
     * 根据接口URL查询
     * @param interfaceUrl
     * @return
     */
    public InterfaceModel findByInterfaceUrl(String interfaceUrl);

    /**
     * 根据URL更新接口
     * @param model
     * @return
     */
    public boolean updateInterfaceByUrl(InterfaceModel model);

    /**
     * 根据模块ID查询接口
     * @param moduleId
     * @return
     */
    public List<InterfaceModel> findByModuleId(long moduleId);

    /**
     * 新增接口
     * @param model
     * @return
     */
    public boolean saveInterface(InterfaceModel model);

    /**
     * 根据接口ID更新对应的接口
     * @param model
     * @return
     */
    public boolean updateInterfaceById(InterfaceModel model);

    /**
     * 根据ID保存或更新接口信息
     * @param model
     * @return
     */
    public boolean saveOrUpdateInterfaceById(InterfaceModel model);

    /**
     * 根据URL保存或更新接口
     * @param model
     * @return
     */
    public boolean saveOrUpdateInterfaceByUrl(InterfaceModel model);

    /**
     * 新增模块
     * @param module
     * @return
     */
    public boolean addModule(InterfaceModuleModel module);

    /**
     * 根据模块ID删除模块
     * @param moduleId
     * @return
     */
    public boolean deleteModuleById(long moduleId);

    /**
     * 批量保存接口模块信息
     * @param models
     * @return
     */
    public boolean saveInterfaceModulesByBatch(List<InterfaceModuleModel> models);

    /**
     * 保存接口模块
     * @param model
     * @return
     */
    public boolean saveInterfaceModule(InterfaceModuleModel model);

    /**
     * 根据ID更新模块信息
     * @param model
     * @return
     */
    public boolean updateInterfaceModuleById(InterfaceModuleModel model);

    /**
     * 根据接口模块的英文名来更新接口模块信息
     * @param model
     * @return
     */
    public boolean updateInterfaceModuleByEnName(InterfaceModuleModel model);

    /**
     * 根据接口模块的英文名来保存或更新接口模块
     * @param model
     * @return
     */
    public boolean saveOrUpdateModuleByEnName(InterfaceModuleModel model);

    /**
     * 根据模块ID查询模块信息
     * @param moduleId
     * @return
     */
    public InterfaceModuleModel findInterfaceModuleById(long moduleId);

    /**
     * 查询所有的接口模块列表
     * @return
     */
    public List<InterfaceModuleModel> findAllInterfaceModules();

    /**
     * 根据enName查看接口模块
     * @param enName
     * @return
     */
    public InterfaceModuleModel findInterfaceModuleByEnName(String enName);


    /**
     * 根据接口参数ID查询接口参数
     * @param interfaceParamId
     * @return
     */
    public InterfaceParamModel findInterfaceParamById(long interfaceParamId);

    /**
     * 根据接口ID查询接口参数列表
     * @param interfaceId
     * @return
     */
    public List<InterfaceParamModel> findInterfaceParamsByInterfaceId(long interfaceId);

    /**
     * 批量保存接口参数
     * @param list
     * @return
     */
    public boolean saveInterfaceParamsByBatch(List<InterfaceParamModel> list);

    /**
     * 保存接口参数
     * @param item
     * @return
     */
    public boolean saveInterfaceParam(InterfaceParamModel item);

    /**
     * 根据参数ID删除接口参数
     * @param paramId
     * @return
     */
    public boolean deleteInterfaceParamById(long paramId);

    /**
     * 根据接口ID删除接口参数
     * @param interfaceId
     * @return
     */
    public boolean deleteInterfaceParamsByInterfaceId(long interfaceId);


    /**
     * 查询所有公共的接口参数
     * @return
     */
    public List<InterfaceParamModel> findCommonIterfaceParams();

    /**
     * 根据ID更新接口参数信息
     * @param item
     * @return
     */
    public boolean updateInterfaceParamById(InterfaceParamModel item);

    /**
     * 保存或更新接口参数
     * @param item
     * @return
     */
    public boolean saveOrUpdateInterfaceParam(InterfaceParamModel item);


    /**
     * 根据ID查询接口响应参数
     * @param interfaceRespId
     * @return
     */
    public InterfaceRespModel findInterfaceRespById(long interfaceRespId);

    /**
     * 根据接口ID查询响应参数
     * @param interfaceId
     * @return
     */
    public List<InterfaceRespModel> findInterfaceRespByInterfaceId(long interfaceId);

    /**
     * 根据接口ID查询该接口对应根响应参数
     * @param interfaceId
     * @return
     */
    public List<InterfaceRespModel> findRootInterfaceRespByInterfaceId(long interfaceId);

    /**
     * 根据pid和interfaceID查询响应参数
     * @param pid
     * @param interfaceId
     * @return
     */
    public List<InterfaceRespModel> findInterfaceRespByPIDAndInterfaceId(long pid,long interfaceId);

    /**
     * 查询所有公共的响应参数
     * @return
     */
    public List<InterfaceRespModel> findCommonIterfaceResps();

    /**
     * 批量保存响应参数
     * @param list
     * @return
     */
    public boolean saveInterfaceRespsByBatch(List<InterfaceRespModel> list);


    /**
     * 根据ID删除响应参数
     * @param interfaceRespId
     * @return
     */
    public boolean deleteInterfaceRespById(long interfaceRespId);

    /**
     * 根据接口ID删除响应参数
     * @param interfaceId
     * @return
     */
    public boolean deleteInterfaceRespByInterfaceId(long interfaceId);

    /**
     * 更新响应接口参数
     * @param model
     * @return
     */
    public boolean updateInterfaceRespById(InterfaceRespModel model);

    /**
     * 保存响应参数
     * @param model
     * @return
     */
    public boolean saveInterfaceResp(InterfaceRespModel model);

    /**
     * 保存或更新
     * @param model
     * @return
     */
    public boolean saveOrUpdateInterfaceResp(InterfaceRespModel model);


    /**
     * 保存接口错误代码信息
     * @param model
     * @return
     */
    public boolean saveInterfaceError(InterfaceErrorModel model);

    /**
     * 批量保存接口错误代码信息
     * @param models
     * @return
     */
    public boolean saveInterfaceErrorByBatch(List<InterfaceErrorModel> models);


    /**
     * 根据ID更新接口错误代码信息
     * @param model
     * @return
     */
    public boolean updateInterfaceErrorById(InterfaceErrorModel model);

    /**
     * 保存或更新接口错误代码信息
     * @param model
     * @return
     */
    public boolean saveOrUpdateInterfaceError(InterfaceErrorModel model);

    /**
     * 根据ID删除接口错误代码信息
     * @param id
     * @return
     */
    public boolean deleteInterfaceErrorById(long id);

    /**
     * 根据接口ID删除接口错误代码信息
     * @param interfaceId
     * @return
     */
    public boolean deleteInterfaceErrorByInterfaceId(long interfaceId);


    /**
     * 根据ID查询错误代码信息
     * @param id
     * @return
     */
    public InterfaceErrorModel findInterfaceErrorById(long id);

    /**
     * 查询所有错误代码信息
     * @return
     */
    public List<InterfaceErrorModel> findAllInterfaceError();

    /**
     * 根据接口ID查询错误代码信息
     * @param interfaceId
     * @return
     */
    public List<InterfaceErrorModel> findInterfaceErrorByInterfaceId(long interfaceId);

}
