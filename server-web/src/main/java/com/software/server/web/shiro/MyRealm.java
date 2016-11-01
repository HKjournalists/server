package com.software.server.web.shiro;

import com.software.server.common.constant.Constants;
import com.software.server.common.exception.BusinessException;
import com.software.server.common.utils.CommonUtils;
import com.software.server.common.utils.ObjectUtils;
import com.software.server.common.utils.RandomNumberUtil;
import com.software.server.dao.model.ResourceModel;
import com.software.server.dao.model.RoleModel;
import com.software.server.dao.model.UserModel;
import com.software.server.service.interfaces.IResourceService;
import com.software.server.service.interfaces.IRoleService;
import com.software.server.service.interfaces.IUserService;
import com.software.server.web.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jk on 16/6/2.
 */
public class MyRealm extends AuthorizingRealm {


    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IResourceService resourceService;

    /**
     * 权限验证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        if (!SecurityUtils.getSubject().isAuthenticated()) {
            doClearCache(principalCollection);
            SecurityUtils.getSubject().logout();
            return null;
        }
        UserModel userModel = (UserModel)principalCollection.getPrimaryPrincipal();
        List<RoleModel> roleModels = roleService.findByUserName(userModel.getUserName());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = new LinkedHashSet<String>();
        for(RoleModel roleModel : roleModels){
            roles.add(roleModel.getRoleValue());
        }
        authorizationInfo.setRoles(roles);
        List<ResourceModel> resourceModels = resourceService.findByUsername(userModel.getUserName());
        Set<String> resources = new LinkedHashSet<String>();
        for(ResourceModel resource : resourceModels){
            resources.add(resource.getResValue());
        }
        authorizationInfo.setStringPermissions(resources);
        return authorizationInfo;
    }

    /**
     * 登录验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken =  (UsernamePasswordToken)authenticationToken;
        String userName =  usernamePasswordToken.getUsername();
        String password =  new String(usernamePasswordToken.getPassword());
        UserModel userModel = userService.findByUsername(userName);
        if (ObjectUtils.isEmpty(userModel)){
            throw new BusinessException(Constants.DEFAULT_ERROR_CODE,"账号不存在");
        }
        String pwd = CommonUtils.EncryptPassword(password, userModel.getSalt());
        if(pwd.equals(userModel.getPassword())){
            SimpleAuthenticationInfo authcInfo =  new SimpleAuthenticationInfo(userModel, password, getName());
            clearCache(authcInfo.getPrincipals());
            return authcInfo;
        }else{
            throw new BusinessException(Constants.DEFAULT_ERROR_CODE,"密码错误");
        }
    }
}
