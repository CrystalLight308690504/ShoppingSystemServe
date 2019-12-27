package com.onlineshop.domain.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author CrystalLight
 * @Date 2019/12/20 15:51
 * @Version 1.0
 * @Description
 **/

@Entity
@Setter
@Getter
@Table(name = "tb_user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -1716425437557536355L;

    @Id
    String userInfId;

    /**
     * 邮箱
     */
    String email;

    /**
     * 电话号码
     */
    String phone;
}
