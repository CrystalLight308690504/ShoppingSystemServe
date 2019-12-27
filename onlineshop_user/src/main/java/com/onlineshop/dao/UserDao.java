package com.onlineshop.dao;
import com.onlineshop.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author CrystalLight
 * @Date 2019/12/19 9:02
 * @Version 1.0
 * @Description 用户实体
 **/
public interface UserDao extends JpaRepository<User,String>,JpaSpecificationExecutor<User> {
     User findUserByName(String name);

     User findUserByUserId(String userId);
}
