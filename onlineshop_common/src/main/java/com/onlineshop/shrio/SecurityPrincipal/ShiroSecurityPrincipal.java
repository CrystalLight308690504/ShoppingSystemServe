package com.onlineshop.shrio.SecurityPrincipal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onlineshop.domain.user.Permission;
import com.onlineshop.domain.user.Role;
import com.onlineshop.domain.user.User;
import lombok.Getter;
import lombok.Setter;
import org.crazycake.shiro.AuthCachePrincipal;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.*;

/**
 * @Author CrystalLight
 * @Date 2019/12/21 19:51
 * @Version 1.0
 * @Description 传入用户安全认证的安全数据
 **/

@Getter
@Setter
public class ShiroSecurityPrincipal  implements Serializable,  AuthCachePrincipal {

    private static final long serialVersionUID = 190956494407911387L;
    /**
     * ID
     */
    @Id
    private String userId;

    /**
     * 用户名称
     */
    private String name;

    /**
     * level
     *      admin：管理员具备所有权限
     *      user：普通用户（
     */
    private String level;

    /**
     * 用户所有api权限
     */
    Set<String> permission = new HashSet<>();
    Set<String> roles = new HashSet<>();

    public ShiroSecurityPrincipal(User user){

        this.userId = user.getUserId();
        this.name = user.getName();
        this.level = user.getLevel();
         Set<Role> roles = user.getRoles();
        Iterator<Role> iteratorUser = roles.iterator();

        // 获取用户所有权限
        while (iteratorUser.hasNext()){
            // 获取用户所有角色
            Role role = iteratorUser.next();
            this.roles.add(role.getCode());

            Set<Permission> permissions = role.getPermissions();
            Iterator<Permission> iteratorPermission = permissions.iterator();
            while (iteratorPermission.hasNext()){
                Permission permission = iteratorPermission.next();
                this.permission.add(permission.getCode()); // 将用户所有权限添加
            }
        }
    }

    @Override
    @JsonIgnore
    public String getAuthCacheKey() {
        return null;
    }
}
