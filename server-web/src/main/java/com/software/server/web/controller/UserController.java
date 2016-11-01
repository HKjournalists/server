package com.software.server.web.controller;

import com.software.server.common.constant.Constants;
import com.software.server.common.model.RespEntity;
import com.software.server.dao.model.RoleModel;
import com.software.server.dao.model.UserModel;
import com.software.server.service.interfaces.IRoleService;
import com.software.server.service.interfaces.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jk on 16/5/30.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity<UserModel> getUser(){
        UserModel userModel = userService.findByMobile("13606603642");
        RespEntity<UserModel> result = new RespEntity<UserModel>();
        result.setErrorcode(Constants.SUCCESS_CODE);
        result.setResult(userModel);
        if(logger.isDebugEnabled()){
            logger.debug("userModel" + userModel);
        }
        return result;
    }

    @RequestMapping(value = "/role/get",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity<List<RoleModel>> getUserRole(){
       List<RoleModel> roles = roleService.findByMobile("13606603642");
        RespEntity<List<RoleModel>> result = new RespEntity<List<RoleModel>>();
        result.setResult(roles);
        return result;
    }

    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
