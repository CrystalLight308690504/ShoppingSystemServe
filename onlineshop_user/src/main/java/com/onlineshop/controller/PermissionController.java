package com.onlineshop.controller;

import com.onlineshop.dao.PermissionDao;
import com.onlineshop.domain.user.Permission;
import com.onlineshop.entity.Result;
import com.onlineshop.entity.ResultCode;
import com.onlineshop.service.PermissionService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author CrystalLight
 * @Date 2019/12/22 14:09
 * @Version 1.0
 * @Description
 **/

@CrossOrigin
@RestController
@RequiresAuthentication
@RequestMapping(value = "/permission")
public class PermissionController extends BaseController {
    
    @Autowired
    PermissionService permissionService;

    /**
     * 删除权限
     *
     * @param id 要删除的权限id
     * @return
     */
    @DeleteMapping(value = "/delete")
    @RequiresPermissions("admin")
    public Result delete(String id) {
        permissionService.delete(id);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 添加权限
     *
     * @param Permission
     * @return
     */
    @PostMapping(value = "/save")
    @RequiresPermissions("admin")
    public Result save(@RequestBody Permission Permission) {
        permissionService.save(Permission);
        return new Result(ResultCode.SUCCESS);
    }


    /**
     * 修改用户信息
     *
     * @param Permission
     */
    @RequiresPermissions("admin")
    @PutMapping(value = "/update")
    public Result update(@RequestBody Permission Permission) {
        permissionService.update(Permission);
        return new Result(ResultCode.SUCCESS);
    }
}
