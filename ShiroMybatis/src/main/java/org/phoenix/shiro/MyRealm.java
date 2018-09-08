package org.phoenix.shiro;

import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.phoenix.bean.Permission;
import org.phoenix.bean.Role_Permission;
import org.phoenix.bean.User;
import org.phoenix.bean.User_Role;
import org.phoenix.dao.PermissionDao;
import org.phoenix.dao.RoleDao;
import org.phoenix.dao.UserDao;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


public class MyRealm extends AuthorizingRealm{

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = (String)principalCollection.getPrimaryPrincipal();
        User user = userDao.getByUserName(username);
        for(User_Role user_role : userDao.getRoles(user.getId())){
            for(Role_Permission role_permission: roleDao.getPermissions(user_role.getRoleId())){
                Permission permission = permissionDao.getById(role_permission.getPermissionId());
                authorizationInfo.addStringPermission(permission.getName());
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();

        User user = userDao.getByUserName(userName);

        if(user != null){
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user", user);
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName, user.getPassword(), getName());
            authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(userName));
            return authenticationInfo;
        }else{
            return null;
        }
    }

}
