package com.onlineshop.service;

import com.onlineshop.dao.PermissionDao;
import com.onlineshop.domain.user.Permission;
import com.onlineshop.utils.IdWorker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author CrystalLight
 * @Date 2019/12/22 14:11
 * @Version 1.0
 * @Description
 **/

@Service
public class PermissionService {

    @Autowired
    PermissionDao permissionDao;
    @Autowired
    IdWorker idWorker;

    /**
     * 删除权限
     *
     * @param id
     */
    public void delete(String id) {
        Permission PermissionTarget = permissionDao.findById(id).get();
        if (PermissionTarget != null) {
            permissionDao.delete(PermissionTarget);
        }
    }

    /**
     * 根据id查找权限
     *
     * @param id
     */
    public Permission find(String id) {
        return permissionDao.findById(id).get();
    }

    /**
     * 添加权限
     *
     * @param permission
     */
    public void save(Permission permission) {
        permission.setPeId(idWorker.nextId() + "");
        permissionDao.save(permission);
    }

    /**
     * 更新权限
     *
     * @param Permission
     */
    public void update(Permission Permission) {
        Permission PermissionTarget = permissionDao.findById(Permission.getPeId()).get(); // 从数据库获取该权限
        BeanUtils.copyProperties(Permission,PermissionTarget);
        permissionDao.save(PermissionTarget);
    }
}
