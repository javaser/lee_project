package com.github.xianzhan.shirospring.service.impl;

import com.github.xianzhan.shirospring.dao.RoleDao;
import com.github.xianzhan.shirospring.entity.Role;
import com.github.xianzhan.shirospring.service.RoleService;

/**
 * @author Lee
 * @since 2017/3/7
 */
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    @Override
    public Role createRole(Role role) {
        return roleDao.createRole(role);
    }

    @Override
    public void deleteRole(Long roleId) {
        roleDao.deleteRole(roleId);
    }

    /**
     * 添加角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    @Override
    public void correlationPermissions(Long roleId, Long... permissionIds) {
        roleDao.correlationPermissions(roleId, permissionIds);
    }

    /**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    @Override
    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
        roleDao.uncorrelationPermissions(roleId, permissionIds);
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
