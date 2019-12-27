package com.onlineshop.shrio.realm;

import com.onlineshop.shrio.SecurityPrincipal.ShiroSecurityPrincipal;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Author CrystalLight
 * @Date 2019/12/20 17:02
 * @Version 1.0
 * @Description
 **/
public class BaseRealm extends AuthorizingRealm {
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("============授权认证器================");
        ShiroSecurityPrincipal shiroSecurityPrincipal = (ShiroSecurityPrincipal)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(shiroSecurityPrincipal.getPermission());
        info.setRoles(shiroSecurityPrincipal.getRoles());
        return info;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
