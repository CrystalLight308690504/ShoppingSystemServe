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
 * @Date 2019/12/20 14:19
 * @Version 1.0
 * @Description
 **/

@Entity
@Table(name = "tb_role")
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert(true)
@DynamicUpdate(true)
public class Role implements Serializable {
    private static final long serialVersionUID = -6217130064196063948L;

    @Id
    private String roleId;
    /**
     * 角色名
     */
    private String name;

    /**
     * 角色标识符
     */
    String code;
    /**
     * 说明
     */
    @Column(name = "decription")
    private String description;

    /**
     * 角色所有权限
     */
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "tb_role_permission", joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "roleId")},
            inverseJoinColumns = {@JoinColumn(name = "pe_id", referencedColumnName = "peId")})
    private Set<Permission> permissions = new HashSet<>();
}
