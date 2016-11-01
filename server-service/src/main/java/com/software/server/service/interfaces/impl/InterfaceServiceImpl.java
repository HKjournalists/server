package com.software.server.service.interfaces.impl;

import com.software.server.common.constant.Constants;
import com.software.server.common.exception.ServiceException;
import com.software.server.common.service.BaseService;
import com.software.server.common.utils.ObjectUtils;
import com.software.server.common.utils.StringUtils;
import com.software.server.dao.mapper.*;
import com.software.server.dao.model.*;
import com.software.server.service.interfaces.IInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 接口服务实现
 */
@Service
public class InterfaceServiceImpl extends BaseService implements IInterfaceService{

    @Autowired
    private InterfaceMapper interfaceMapper;

    @Autowired
    private InterfaceModuleMapper interfaceModuleMapper;

    @Autowired
    private InterfaceParamMapper interfaceParamMapper;

    @Autowired
    private InterfaceErrorMapper interfaceErrorMapper;

    @Autowired
    private InterfaceRespMapper interfaceRespMapper;

    @Override
    public List<InterfaceModel> findAllInterfaces() {
        return interfaceMapper.findAll();
    }

    @Override
    public InterfaceModel findByInterfaceId(long interfaceId) {
        return interfaceMapper.findById(interfaceId);
    }

    @Override
    public InterfaceModel findByInterfaceUrl(String interfaceUrl) {
        return interfaceMapper.findByUrl(interfaceUrl);
    }

    @Override
    @Transactional
    public boolean updateInterfaceByUrl(InterfaceModel model) {
        if (ObjectUtils.isEmpty(model) || StringUtils.isEmpty(model.getUrl())){
            return false;
        }
        return interfaceMapper.updateByUrl(model) > 0;
    }

    @Override
    public List<InterfaceModel> findByModuleId(long moduleId) {
        return interfaceMapper.findByModule(moduleId);
    }

    @Override
    @Transactional
    public boolean saveInterface(InterfaceModel model) {
        if (ObjectUtils.isEmpty(model)){
            return false;
        }
        return interfaceMapper.insert(model) > 0;
    }

    @Override
    @Transactional
    public boolean updateInterfaceById(InterfaceModel model) {
        if (ObjectUtils.isEmpty(model) || model.getId() == 0){
            return false;
        }
        return interfaceMapper.update(model) > 0;
    }

    @Override
    @Transactional
    public boolean saveOrUpdateInterfaceById(InterfaceModel model) {
        if (ObjectUtils.isEmpty(model)){
            return false;
        }
        long interfaceId = model.getId();
        if (interfaceId > 0){
            InterfaceModel tempModel = this.findByInterfaceId(interfaceId);
            if (ObjectUtils.isEmpty(tempModel)){
                return this.saveInterface(model);
            }else{
                return this.updateInterfaceByUrl(model);
            }
        }else{
            return this.saveInterface(model);
        }
    }

    @Override
    @Transactional
    public boolean saveOrUpdateInterfaceByUrl(InterfaceModel model) {
        if (ObjectUtils.isEmpty(model)){
            return false;
        }
        String interfaceUrl = StringUtils.trimNull(model.getUrl());
        if (!StringUtils.isEmpty(interfaceUrl)){
            InterfaceModel tempModel = this.findByInterfaceUrl(interfaceUrl);
            if (ObjectUtils.isEmpty(tempModel)){
                return this.saveInterface(model);
            }else{
                return this.updateInterfaceByUrl(model);
            }
        }else{
            return this.saveInterface(model);
        }
    }

    @Override
    @Transactional
    public boolean addModule(InterfaceModuleModel module) {
        if(ObjectUtils.isEmpty(module) || StringUtils.isEmpty(module.getEnName()) || StringUtils.isEmpty(module.getZhName())){
            throw new ServiceException(Constants.ILLEGAL_PARAM_CODE,"参数非法");
        }
        if (isModuleExist(module.getEnName())){
            throw new ServiceException(Constants.DEFAULT_ERROR_CODE,"该模块已存在!");
        }
        return saveInterfaceModule(module);
    }

    @Override
    @Transactional
    public boolean deleteModuleById(long moduleId) {
        if (ObjectUtils.isEmpty(findInterfaceModuleById(moduleId))){
            throw new ServiceException(Constants.DEFAULT_ERROR_CODE,"对应的模块不存在");
        }
        return interfaceModuleMapper.deleteById(moduleId) > 0;
    }

    /**
     * 判断对应的模块是否存在
     * @param enName
     * @return
     */
    private boolean isModuleExist(String enName){
       return !ObjectUtils.isEmpty(interfaceModuleMapper.findByEnName(enName));
    }

    @Override
    @Transactional
    public boolean saveInterfaceModule(InterfaceModuleModel model) {
        if (ObjectUtils.isEmpty(model)){
           return false;
        }
        return interfaceModuleMapper.insert(model) > 0;
    }

    @Override
    @Transactional
    public boolean updateInterfaceModuleById(InterfaceModuleModel model) {
        if (ObjectUtils.isEmpty(model) || model.getId() == 0){
            return false;
        }
        return interfaceModuleMapper.update(model) > 0;
    }

    @Override
    @Transactional
    public boolean updateInterfaceModuleByEnName(InterfaceModuleModel model) {
        if (ObjectUtils.isEmpty(model) || StringUtils.isEmpty(model.getEnName())){
            return false;
        }
        return interfaceModuleMapper.updateByEnName(model) > 0;
    }

    @Override
    @Transactional
    public boolean saveOrUpdateModuleByEnName(InterfaceModuleModel model) {
        if (ObjectUtils.isEmpty(model)){
            return false;
        }
        String enName = StringUtils.trimNull(model.getEnName());
        if (!StringUtils.isEmpty(enName)){
            InterfaceModuleModel tempModel = this.findInterfaceModuleByEnName(enName);
            if (ObjectUtils.isEmpty(tempModel)){
                return this.saveInterfaceModule(model);
            }else{
                return this.updateInterfaceModuleByEnName(model);
            }
        }else{
            return this.saveInterfaceModule(model);
        }
    }

    @Override
    public InterfaceModuleModel findInterfaceModuleById(long moduleId) {
        return interfaceModuleMapper.findById(moduleId);
    }

    @Override
    public List<InterfaceModuleModel> findAllInterfaceModules() {
        return interfaceModuleMapper.findAll();
    }

    @Override
    public InterfaceModuleModel findInterfaceModuleByEnName(String enName) {
        return interfaceModuleMapper.findByEnName(enName);
    }

    @Override
    @Transactional
    public boolean saveInterfaceModulesByBatch(List<InterfaceModuleModel> models) {
        if (CollectionUtils.isEmpty(models)){
            return false;
        }
        return interfaceModuleMapper.insertByBatch(models) > 0;
    }

    @Override
    public InterfaceParamModel findInterfaceParamById(long interfaceParamId) {
        return interfaceParamMapper.findById(interfaceParamId);
    }

    @Override
    public List<InterfaceParamModel> findInterfaceParamsByInterfaceId(long interfaceId) {
        return interfaceParamMapper.findByInterfaceId(interfaceId);
    }

    @Override
    @Transactional
    public boolean saveInterfaceParamsByBatch(List<InterfaceParamModel> list) {
        if (CollectionUtils.isEmpty(list)){
            return false;
        }
        return interfaceParamMapper.insertByBatch(list) > 0;
    }

    @Override
    public boolean saveInterfaceParam(InterfaceParamModel item) {
        if (ObjectUtils.isEmpty(item)){
            return false;
        }
        return interfaceParamMapper.insert(item) > 0;
    }

    @Override
    @Transactional
    public boolean deleteInterfaceParamById(long paramId) {
        return interfaceParamMapper.deleteById(paramId) > 0;
    }

    @Override
    @Transactional
    public boolean deleteInterfaceParamsByInterfaceId(long interfaceId) {
        return interfaceParamMapper.deleteByInterfaceId(interfaceId) > 0;
    }

    @Override
    public List<InterfaceParamModel> findCommonIterfaceParams() {
        return interfaceParamMapper.findCommons();
    }

    @Override
    @Transactional
    public boolean saveOrUpdateInterfaceParam(InterfaceParamModel item) {
        if(ObjectUtils.isEmpty(item)){
            return false;
        }
        long id = item.getId();
        if (id > 0){
            return updateInterfaceParamById(item);
        }else{
            return saveInterfaceParam(item);
        }
    }

    @Override
    @Transactional
    public boolean updateInterfaceParamById(InterfaceParamModel item) {
        if (ObjectUtils.isEmpty(item)){
            return false;
        }
        return interfaceParamMapper.update(item) > 0;
    }

    @Override
    public InterfaceRespModel findInterfaceRespById(long interfaceRespId) {
        return interfaceRespMapper.findById(interfaceRespId);
    }

    @Override
    public List<InterfaceRespModel> findInterfaceRespByInterfaceId(long interfaceId) {
        return interfaceRespMapper.findByInterfaceId(interfaceId);
    }

    @Override
    public List<InterfaceRespModel> findRootInterfaceRespByInterfaceId(long interfaceId) {
        return interfaceRespMapper.findRootInterfaceRespByInterfaceId(interfaceId);
    }

    @Override
    public List<InterfaceRespModel> findInterfaceRespByPIDAndInterfaceId(long pid, long interfaceId) {
        return interfaceRespMapper.findByPIDAndInterfaceId(pid,interfaceId);
    }

    @Override
    public List<InterfaceRespModel> findCommonIterfaceResps() {
        return interfaceRespMapper.findCommons();
    }

    @Override
    @Transactional
    public boolean saveInterfaceRespsByBatch(List<InterfaceRespModel> list) {
        if (CollectionUtils.isEmpty(list)){
            return false;
        }
        return interfaceRespMapper.insertByBatch(list) > 0;
    }

    @Override
    @Transactional
    public boolean deleteInterfaceRespById(long interfaceRespId) {
        return interfaceRespMapper.deleteById(interfaceRespId) > 0;
    }

    @Override
    @Transactional
    public boolean deleteInterfaceRespByInterfaceId(long interfaceId) {
        return interfaceRespMapper.deleteByInterfaceId(interfaceId) > 0;
    }

    @Override
    @Transactional
    public boolean updateInterfaceRespById(InterfaceRespModel model) {
        if (ObjectUtils.isEmpty(model)){
            return false;
        }
        return interfaceRespMapper.update(model) > 0;
    }

    @Override
    @Transactional
    public boolean saveInterfaceResp(InterfaceRespModel model) {
        if (ObjectUtils.isEmpty(model)){
            return false;
        }
        return interfaceRespMapper.insert(model) > 0;
    }

    @Override
    @Transactional
    public boolean saveOrUpdateInterfaceResp(InterfaceRespModel model) {
        if (ObjectUtils.isEmpty(model)){
            return false;
        }
        long id = model.getId();
        if (id > 0){
            return updateInterfaceRespById(model);
        }else{
            return saveInterfaceResp(model);
        }
    }

    @Override
    @Transactional
    public boolean saveInterfaceError(InterfaceErrorModel model) {
        if (ObjectUtils.isEmpty(model)){
            return false;
        }
        return interfaceErrorMapper.insert(model) > 0;
    }

    @Override
    @Transactional
    public boolean saveInterfaceErrorByBatch(List<InterfaceErrorModel> models) {
        if (CollectionUtils.isEmpty(models)){
            return false;
        }
        return interfaceErrorMapper.insertByBatch(models) > 0;
    }

    @Override
    @Transactional
    public boolean updateInterfaceErrorById(InterfaceErrorModel model) {
        if (ObjectUtils.isEmpty(model)){
            return false;
        }
        return interfaceErrorMapper.update(model) > 0;
    }

    @Override
    @Transactional
    public boolean saveOrUpdateInterfaceError(InterfaceErrorModel model) {
        if (ObjectUtils.isEmpty(model)){
            return false;
        }
        long id = model.getId();
        if (id > 0){
            return updateInterfaceErrorById(model);
        }else{
            return saveInterfaceError(model);
        }
    }

    @Override
    @Transactional
    public boolean deleteInterfaceErrorById(long id) {
        return interfaceErrorMapper.deleteById(id) > 0;
    }

    @Override
    @Transactional
    public boolean deleteInterfaceErrorByInterfaceId(long interfaceId) {
        return interfaceErrorMapper.deleteByInterfaceId(interfaceId) > 0;
    }

    @Override
    public InterfaceErrorModel findInterfaceErrorById(long id) {
        return interfaceErrorMapper.findById(id);
    }

    @Override
    public List<InterfaceErrorModel> findAllInterfaceError() {
        return interfaceErrorMapper.findAll();
    }

    @Override
    public List<InterfaceErrorModel> findInterfaceErrorByInterfaceId(long interfaceId) {
        return interfaceErrorMapper.findByInterfaceId(interfaceId);
    }
}
