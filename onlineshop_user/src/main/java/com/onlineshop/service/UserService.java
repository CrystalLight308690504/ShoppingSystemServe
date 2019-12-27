package com.onlineshop.service;

import com.onlineshop.dao.UserDao;
import com.onlineshop.domain.user.User;
import com.onlineshop.domain.user.UserInfo;
import com.onlineshop.entity.Result;
import com.onlineshop.entity.ResultCode;
import com.onlineshop.exception.CommonException;
import com.onlineshop.utils.IdWorker;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author CrystalLight
 * @Date 2019/12/19 10:26
 * @Version 1.0
 * @Description
 **/
@Service
public class UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    IdWorker idWorker;

    public User findUserByName(String name){
       return  userDao.findUserByName(name);
    }


   public User findUserById(String userId){
       User userTarget = userDao.findUserByUserId(userId);
       userTarget.setPassword("");
       return userTarget;
    }




    /**
     * 保存用户
     * @param user
     * @return
     */
    public void saveUser(User user) throws CommonException {
        User userTarget = userDao.findUserByName(user.getName());
        if (userTarget == null ){// 用户不存在
            String password = user.getPassword();
            password = new Md5Hash(password, user.getName(), 3).toString();
            user.setPassword(password);
            // 用户、用户信息设置id
            user.setUserId(String.valueOf(idWorker.nextId()));
            user.getUserInfo().setUserInfId(user.getUserId());
            userDao.save(user);
        }else {
          throw  new CommonException(ResultCode.UEREXISTED);
        }
    }

    /**
     * 验证用户名是否可用
     * @param userName
     * @return
     */
    public void verifyUserName(String userName) throws CommonException{
        User userTarget = userDao.findUserByName(userName);
        if (userTarget != null)
            throw new CommonException(ResultCode.UNAUTHORISE);
    }

    /**
     * 修改用户信息
     * @param user
     */
    public void update(User user) {
        // 根据id查数据库的用户信息
        User target = userDao.findById(user.getUserId()).get();
        // 用户更新
        if (!StringUtils.isEmpty(user.getPassword())){ // 要修改密码
            target.setPassword(new Md5Hash(user.getPassword(), user.getName(), 3).toString());
        }
        target.setLevel(user.getLevel());
        UserInfo userInfo = target.getUserInfo();
        userInfo.setEmail(user.getUserInfo().getEmail());
        userInfo.setPhone(user.getUserInfo().getPhone());
        userDao.save(target);
    }
}
