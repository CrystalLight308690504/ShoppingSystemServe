package com.onlineshop.controller;

import com.onlineshop.entity.request.RequestUser;
import com.onlineshop.domain.user.User;
import com.onlineshop.shrio.SecurityPrincipal.ShiroSecurityPrincipal;
import com.onlineshop.entity.Result;
import com.onlineshop.entity.ResultCode;
import com.onlineshop.exception.CommonException;
import com.onlineshop.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * @Author CrystalLight
 * @Date 2019/12/19 9:02
 * @Version 1.0
 * @Description
 **/
@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    /**
     * 登陆
     *
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestParam(name = "userName") String userName, @RequestParam(name = "password") String password) {
        password = new Md5Hash(password, userName, 3).toString();
        System.out.println("密码：" + password);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            String sessionId = (String) subject.getSession().getId();
            sessionId = new String("Bearer " + sessionId);
            return new Result(ResultCode.SUCCESS, sessionId);
        } catch (UnknownAccountException e) { // 用户密码不正确抛出异常
            return new Result(ResultCode.MOBILEORPASSWORDERROR);
        }
    }

    /**
     * 获取用户权限信息
     *
     * @return
     */
    @RequiresAuthentication
    @GetMapping(value = "/profile")
    public Result find() {
        //获取session中的安全数据
        Subject subject = SecurityUtils.getSubject();
        //1.subject获取所有的安全数据集合
        PrincipalCollection principals = subject.getPrincipals();
        //2.获取安全数据
        ShiroSecurityPrincipal result = (ShiroSecurityPrincipal) principals.getPrimaryPrincipal();
        return new Result(ResultCode.SUCCESS, result);
    }
  /**
     * 查用户信息
     *
     * @return
     */
    @RequiresAuthentication
    @GetMapping(value = "/find/{userId}")
    public Result findById(@PathVariable  String userId) {
        //获取session中的安全数据
        User user = userService.findUserById(userId);
        return new Result(ResultCode.SUCCESS, user);
    }


    /**
     * 修改用户信息
     *
     * @param requestUser 传入的用户数据
     */
    @RequiresAuthentication
    @CrossOrigin
    @PutMapping(value = "/update")
    public Result update(@RequestBody RequestUser requestUser) {
        User user = new User();
        // 将模板数据复制到用户中
        BeanUtils.copyProperties(requestUser, user);
        BeanUtils.copyProperties(requestUser, user.getUserInfo());

        // 传入用户id
        user.setUserId(this.getUserId());
        user.setName(this.getUsername());
        user.getUserInfo().setUserInfId(this.getUserId());
        userService.update(user);
        return new Result(ResultCode.SUCCESS);
    }


    /**
     * 注册用户
     *
     * @param rq
     * @return
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public Result save(@ModelAttribute RequestUser rq) throws CommonException {
        User user = new User();
        // 将模板数据复制到用户中
        BeanUtils.copyProperties(rq, user);
        BeanUtils.copyProperties(rq, user.getUserInfo());
        userService.saveUser(user);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 验证用户名是否可用
     *
     * @param
     * @return
     */
    @GetMapping(value = "/verifyName")
    @ResponseBody
    public Result verifyName(@RequestParam String username) throws CommonException {
        userService.verifyUserName(username);
        return new Result(ResultCode.UERNOEXISTED);
    }

    @DeleteMapping(value = "/logout")
    @RequiresAuthentication
    @ResponseBody
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
    }

}


