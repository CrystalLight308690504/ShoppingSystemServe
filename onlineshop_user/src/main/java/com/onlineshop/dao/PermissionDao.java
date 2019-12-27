package com.onlineshop.dao;

import com.onlineshop.domain.user.Permission;
import com.onlineshop.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author CrystalLight
 * @Date 2019/12/22 14:09
 * @Version 1.0
 * @Description
 **/
public interface PermissionDao extends JpaRepository<Permission,String> , JpaSpecificationExecutor<User> {
}
