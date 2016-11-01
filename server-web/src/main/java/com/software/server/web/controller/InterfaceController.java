package com.software.server.web.controller;


import com.software.server.common.constant.Constants;
import com.software.server.common.exception.MVCException;
import com.software.server.common.model.RespEntity;
import com.software.server.common.utils.StringUtils;
import com.software.server.dao.model.InterfaceModel;
import com.software.server.dao.model.InterfaceModuleModel;
import com.software.server.dao.model.InterfaceRespModel;
import com.software.server.service.interfaces.IInterfaceService;
import com.software.server.web.model.req.*;
import com.software.server.web.model.resp.InterfaceQueryByIdRespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/interface")
public class InterfaceController {

    @Autowired
    private IInterfaceService interfaceService;

    /**
     * 查询所有的模块信息
     * @return
     */
    @RequestMapping(value = "/module/all")
    @ResponseBody
    public RespEntity<List<InterfaceModuleModel>> findAllModules(){
        RespEntity<List<InterfaceModuleModel>> respEntity = new RespEntity<List<InterfaceModuleModel>>();
        respEntity.setResult(interfaceService.findAllInterfaceModules());
        respEntity.setErrorcode(Constants.SUCCESS_CODE);
        respEntity.setErrormsg("查询模块信息成功");
        return respEntity;
    }

    /**
     * 新增模块
     * @return
     */
    @RequestMapping(value = "/module/add")
    @ResponseBody
    public RespEntity addModule(ModuleAddReqBean params){
        if (StringUtils.isEmpty(params.getModuleEnName()) || StringUtils.isEmpty(params.getModuleZhName())){
            throw new MVCException(Constants.ILLEGAL_PARAM_CODE,"参数非法异常");
        }
        InterfaceModuleModel moduleModel = new InterfaceModuleModel();
        moduleModel.setCreateTime(new Date());
        moduleModel.setZhName(StringUtils.trimNull(params.getModuleZhName()));
        moduleModel.setEnName(StringUtils.trimNull(params.getModuleEnName()));
        boolean success = interfaceService.addModule(moduleModel);
        RespEntity respEntity = new RespEntity();
        respEntity.setErrorcode(success ? Constants.SUCCESS_CODE : Constants.DEFAULT_ERROR_CODE);
        respEntity.setErrormsg(success ? "新增模块成功" : "新增模块失败");
        return respEntity;
    }

    /**
     * 删除模块
     * @param params
     * @return
     */
    @RequestMapping(value = "/module/delete")
    @ResponseBody
    public RespEntity deleteModule(DeleteModuleReqBean params){
        RespEntity respEntity = new RespEntity();
        boolean success = interfaceService.deleteModuleById(params.getModuleId());
        respEntity.setErrorcode(success ? Constants.SUCCESS_CODE : Constants.DEFAULT_ERROR_CODE);
        respEntity.setErrormsg(success ? "删除模块成功" : "删除模块失败");
        return respEntity;
    }

    /**
     * 根据模块查询接口
     * @return
     */
    @RequestMapping(value = "/query/by/moduleId")
    @ResponseBody
    public RespEntity<List<InterfaceModel>> queryInterfacesByModule(InterfaceQueryByModuleReqBean params){
        RespEntity<List<InterfaceModel>> respEntity = new RespEntity<List<InterfaceModel>>();
        respEntity.setErrorcode(Constants.SUCCESS_CODE);
        respEntity.setErrormsg("查询接口信息成功");
        respEntity.setResult(interfaceService.findByModuleId(params.getModuleId()));
        return respEntity;
    }

    /**
     * 根据接口ID查询接口信息
     * @return
     */
    @RequestMapping(value = "/query/by/interfaceId")
    @ResponseBody
    public RespEntity<InterfaceQueryByIdRespBean> queryInterfaceById(InterfaceQueryByIdReqBean params){
        RespEntity<InterfaceQueryByIdRespBean> respEntity = new RespEntity<InterfaceQueryByIdRespBean>();
        respEntity.setErrorcode(Constants.SUCCESS_CODE);
        respEntity.setErrormsg("查询接口信息成功");
        InterfaceQueryByIdRespBean resultBean = new InterfaceQueryByIdRespBean();
        resultBean.setCommonParams(interfaceService.findCommonIterfaceParams());
        resultBean.setErrors(interfaceService.findInterfaceErrorByInterfaceId(params.getInterfaceId()));
        resultBean.setInterfaceInfo(interfaceService.findByInterfaceId(params.getInterfaceId()));
        resultBean.setRootRespParams(interfaceService.findRootInterfaceRespByInterfaceId(params.getInterfaceId()));
        resultBean.setPersonalParams(interfaceService.findInterfaceParamsByInterfaceId(params.getInterfaceId()));
        respEntity.setResult(resultBean);
        return respEntity;
    }


    /**
     * 根据父ID和接口ID查询接口响应参数
     * @param params
     * @return
     */
    @RequestMapping(value = "/query/by/pid/interfaceId")
    @ResponseBody
    public RespEntity<List<InterfaceRespModel>> queryInterfaceRespByPIDAndInterfaceId(InterfaceRespByPIDAndInterfaceIdReqBean params){
        RespEntity<List<InterfaceRespModel>> respEntity = new RespEntity<>();
        respEntity.setErrorcode(Constants.SUCCESS_CODE);
        respEntity.setErrormsg("查询接口响应参数成功");
        respEntity.setResult(interfaceService.findInterfaceRespByPIDAndInterfaceId(params.getPid(),params.getInterfaceId()));
        return respEntity;
    }
}
