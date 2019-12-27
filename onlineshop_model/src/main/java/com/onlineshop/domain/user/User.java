package com.onlineshop.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author CrystalLight
 * @Date 2019/12/19 9:02
 * @Version 1.0
 * @Description 用户实体
 **/
@Entity
@Table(name = "tb_user")
@Getter
@Setter
@DynamicInsert(true)
@DynamicUpdate(true)
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 4297464181093070302L;
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


    /**
     * level
     *      admin：管理员具备所有权限
     *      user：普通用户（
     */
    private String level;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userInfId")
    UserInfo userInfo  = new UserInfo();

    /**
     * 角色
     */
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "tb_user_role",joinColumns={@JoinColumn(name="user_id",referencedColumnName="userId")},
            inverseJoinColumns = {@JoinColumn(name="role_id",referencedColumnName="roleId")})
    Set<Role> roles = new HashSet<>();

}
