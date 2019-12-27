package com.onlineshop.service;

import com.onlineshop.dao.RoleDao;
import com.onlineshop.domain.user.Role;
import com.onlineshop.utils.IdWorker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author CrystalLight
 * @Date 2019/12/22 13:17
 * @Version 1.0
 * @Description
 **/

@Service
public class RoleService {

    @Autowired
    RoleDao roleDao;
    @Autowired
    IdWorker idWorker;

    /**
     * 删除角色
     *
     * @param id
     */
    public void delete(String id) {
        Role roleTarget = roleDao.findById(id).get();
        if (roleTarget != null) {
            roleDao.delete(roleTarget);
        }
    }

    /**
     * 根据id查找角色
     *
     * @param id
     */
    public Role find(String id) {
       return roleDao.findById(id).get();
    }

    /**
     * 添加角色
     *
     * @param role
     */
    public void save(Role role) {
        role.setRoleId(idWorker.nextId() + "");
        roleDao.save(role);
    }

    /**
     * 更新角色
     *
     * @param role
     */
    public void update(Role role) {
        Role roleTarget = roleDao.findById(role.getRoleId()).get(); // 从数据库获取该角色
        BeanUtils.copyProperties(role,roleTarget);
        roleDao.save(roleTarget);
    }
}
