package com.software.server.web.model.req;

import com.software.server.common.model.ReqEntity;

/**
 * 根据模块查询接口的请求参数实体类
 */
public class InterfaceQueryByModuleReqBean extends ReqEntity {

    private long moduleId;

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public String toString() {
        return "InterfaceQueryByModuleReqBean{" +
                "moduleId=" + moduleId +
                '}';
    }
}
