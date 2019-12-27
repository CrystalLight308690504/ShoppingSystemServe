package com.onlineshop.controller;

import com.onlineshop.domain.user.Role;
import com.onlineshop.entity.Result;
import com.onlineshop.entity.ResultCode;
import com.onlineshop.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author CrystalLight
 * @Date 2019/12/22 12:48
 * @Version 1.0
 * @Description
 **/
@CrossOrigin
@RestController
@RequiresAuthentication
@RequestMapping(value = "/role")
public class RoleController extends BaseController {

    @Autowired
    RoleService roleService;

    /**
     * 删除角色
     *
     * @param id 要删除的角色id
     * @return
     */
    @DeleteMapping(value = "/delete")
    public Result delete(String id) {
        roleService.delete(id);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    @PostMapping(value = "/save")
    public Result save(@RequestBody Role role) {
        roleService.save(role);
        return new Result(ResultCode.SUCCESS);
    }


    /**
     * 修改用户信息
     *
     * @param role
     */
    @PutMapping(value = "/update")
    public Result update(@RequestBody Role role) {
        roleService.update(role);
        return new Result(ResultCode.SUCCESS);
    }

}
