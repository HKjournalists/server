package com.software.server.web.model.req;

import com.software.server.common.model.ReqEntity;

/**
 * 添加模块的请求参数bean
 */
public class ModuleAddReqBean extends ReqEntity {

    // 英文名
    private String moduleEnName;

    // 中文名
    private String moduleZhName;

    public String getModuleEnName() {
        return moduleEnName;
    }

    public void setModuleEnName(String moduleEnName) {
        this.moduleEnName = moduleEnName;
    }

    public String getModuleZhName() {
        return moduleZhName;
    }

    public void setModuleZhName(String moduleZhName) {
        this.moduleZhName = moduleZhName;
    }

    @Override
    public String toString() {
        return "ModuleAddReqBean{" +
                "moduleEnName='" + moduleEnName + '\'' +
                ", moduleZhName='" + moduleZhName + '\'' +
                '}';
    }
}
