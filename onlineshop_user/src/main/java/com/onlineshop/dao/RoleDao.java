package com.onlineshop.dao;

import com.onlineshop.domain.user.Role;
import com.onlineshop.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.Entity;

/**
 * @Author CrystalLight
 * @Date 2019/12/22 13:18
 * @Version 1.0
 * @Description
 **/
public interface RoleDao extends JpaRepository<Role,String>, JpaSpecificationExecutor<User> {
}
