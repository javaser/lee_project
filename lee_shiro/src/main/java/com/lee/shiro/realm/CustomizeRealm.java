package com.lee.shiro.realm;

import com.lee.shiro.dao.UserDao;
import com.lee.shiro.dao.impl.UserDaoImpl;
import com.lee.shiro.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Set;

public class CustomizeRealm extends AuthorizingRealm {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 为当前用户授权
     * 先执行 doGetAuthenticationInfo(token)
     * 然后执行此方法
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authInfo = new SimpleAuthorizationInfo();
        Set<String> rolesSet = userDao.getRolesByUsername(username);
        Set<String> permissionSet = userDao.getPermissionsByUsername(username);
        authInfo.setRoles(rolesSet);
        authInfo.setStringPermissions(permissionSet);
        return authInfo;
    }

    /**
     * 验证当前登录的用户
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        User user = userDao.getByUsername(username);
        AuthenticationInfo authInfo = null;
        if (user != null) {
            authInfo = new SimpleAuthenticationInfo(
                    user.getUsername(), user.getPassword(), "userRealm");
        }
        return authInfo;
    }
}
