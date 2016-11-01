package com.software.server.web.model.resp;

import com.software.server.common.model.BaseModel;
import com.software.server.dao.model.InterfaceErrorModel;
import com.software.server.dao.model.InterfaceModel;
import com.software.server.dao.model.InterfaceParamModel;
import com.software.server.dao.model.InterfaceRespModel;

import java.util.List;

/**
 * 根据ID查询接口信息响应类
 */
public class InterfaceQueryByIdRespBean extends BaseModel{

    // 公共参数
    private List<InterfaceParamModel> commonParams;

    // 个性化参数
    private List<InterfaceParamModel> personalParams;

    // 接口信息
    private InterfaceModel interfaceInfo;

    // 响应参数
    private List<InterfaceRespModel> rootRespParams;

    // 错误代码信息
    private List<InterfaceErrorModel> errors;

    public List<InterfaceParamModel> getCommonParams() {
        return commonParams;
    }

    public void setCommonParams(List<InterfaceParamModel> commonParams) {
        this.commonParams = commonParams;
    }

    public List<InterfaceParamModel> getPersonalParams() {
        return personalParams;
    }

    public void setPersonalParams(List<InterfaceParamModel> personalParams) {
        this.personalParams = personalParams;
    }

    public InterfaceModel getInterfaceInfo() {
        return interfaceInfo;
    }

    public void setInterfaceInfo(InterfaceModel interfaceInfo) {
        this.interfaceInfo = interfaceInfo;
    }

    public List<InterfaceRespModel> getRootRespParams() {
        return rootRespParams;
    }

    public void setRootRespParams(List<InterfaceRespModel> rootRespParams) {
        this.rootRespParams = rootRespParams;
    }

    public List<InterfaceErrorModel> getErrors() {
        return errors;
    }

    public void setErrors(List<InterfaceErrorModel> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "InterfaceQueryByIdRespBean{" +
                "commonParams=" + commonParams +
                ", personalParams=" + personalParams +
                ", interfaceInfo=" + interfaceInfo +
                ", rootRespParams=" + rootRespParams +
                ", errors=" + errors +
                '}';
    }
}
