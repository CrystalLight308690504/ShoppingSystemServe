package com.onlineshop.shiro.realm;

import com.onlineshop.domain.user.User;
import com.onlineshop.shrio.SecurityPrincipal.ShiroSecurityPrincipal;
import com.onlineshop.service.UserService;
import com.onlineshop.shrio.realm.BaseRealm;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author CrystalLight
 * @Date 2019/12/19 11:00
 * @Version 1.0
 * @Description
 **/
public class UserRealm extends BaseRealm {

    @Autowired
    UserService userService;

    public void setName(String name){
        super.setName(name);
    }


    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("=====================运行认证器=====================");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        String password = String.valueOf(usernamePasswordToken.getPassword());
        User user = userService.findUserByName(username);

        if (user != null && user.getPassword().equals(password)) { // 验证用户密码是否正确
            ShiroSecurityPrincipal securityPrincipal = new ShiroSecurityPrincipal(user);
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(securityPrincipal,user.getPassword(), this.getName());
            return info;
        }else { // 用户密码不正确
            return null;
        }
    }
}
