package com.software.server.web.model.req;

import com.software.server.common.model.ReqEntity;

/**
 * 根据ID查询接口信息
 */
public class InterfaceQueryByIdReqBean extends ReqEntity {

    // 接口ID
    private long interfaceId;

    public long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(long interfaceId) {
        this.interfaceId = interfaceId;
    }
}
