package com.software.server.web.model.req;

import com.software.server.common.model.ReqEntity;

/**
 * 根据pid和接口ID查询响应接口参数
 */
public class InterfaceRespByPIDAndInterfaceIdReqBean extends ReqEntity {

    // 父ID
    private long pid;

    // 接口ID
    private long interfaceId;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(long interfaceId) {
        this.interfaceId = interfaceId;
    }
}
