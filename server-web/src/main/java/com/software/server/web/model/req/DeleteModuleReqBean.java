package com.software.server.web.model.req;

import com.software.server.common.model.ReqEntity;

/**
 * 删除模块请求实体类
 */
public class DeleteModuleReqBean extends ReqEntity {

    // 模块ID
    private long moduleId;

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public String toString() {
        return "DeleteModuleReqBean{" +
                "moduleId=" + moduleId +
                '}';
    }
}
