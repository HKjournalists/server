package com.software.server.web.model;

import com.software.server.common.model.BaseModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jk on 16/5/31.
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "user")
public class User extends BaseModel{

    private String userName;
    private String age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
