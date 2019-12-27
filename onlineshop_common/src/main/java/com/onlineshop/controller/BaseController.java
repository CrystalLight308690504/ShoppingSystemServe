package com.onlineshop.controller;

import com.onlineshop.shrio.SecurityPrincipal.ShiroSecurityPrincipal;
import lombok.Getter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author CrystalLight
 * @Date 2019/12/22 9:16
 * @Version 1.0
 * @Description
 **/

@Getter
public class BaseController {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    private String userId;
    private String username;

    /**
     * 获得请求用户的id和用户名
     *
     * @param request
     * @param response
     */
    @ModelAttribute
    public void setResAnReq(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;

        //获取session中的安全数据
        Subject subject = SecurityUtils.getSubject();
        //1.subject获取所有的安全数据集合
        PrincipalCollection principals = subject.getPrincipals();
        if (principals != null && !principals.isEmpty()) {
            //2.获取安全数据
            ShiroSecurityPrincipal result = (ShiroSecurityPrincipal) principals.getPrimaryPrincipal();
            this.userId = result.getUserId();
            this.username = result.getName();
            System.out.println("用户id" + userId);
        }
    }
}
