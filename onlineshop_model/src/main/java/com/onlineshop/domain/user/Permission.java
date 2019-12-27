package com.onlineshop.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author CrystalLight
 * @Date 2019/12/20 14:12
 * @Version 1.0
 * @Description 
 **/
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert(true)
@DynamicUpdate(true)
@Entity
@Table(name = "tb_permission")
public class Permission implements Serializable {
    private static final long serialVersionUID = -3309825879254589742L;
    /**
     * 主键
     */
    @Id
    String peId;

    /**
     * 权限标识
     */
    String code;

    /**
     * 描述
     */
    @Column(name = "decription")
    String description;

    /**
     * 请求的api
     */

    String api;

}
