package com.onlineshop.entity.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

/**
 * @Author CrystalLight
 * @Date 2019/12/20 17:48
 * @Version 1.0
 * @Description
 **/

@Getter
@Setter
@NoArgsConstructor
public class RequestUser {

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
     * 密码
     */
    private String password;

    private String email;

    /**
     * level
     *      admin：管理员具备所有权限
     *      user：普通用户（
     */
    private String level;
}
