package com.github.xianzhan.shirospring.service.impl;

import com.github.xianzhan.shirospring.dao.PermissionDao;
import com.github.xianzhan.shirospring.entity.Permission;
import com.github.xianzhan.shirospring.service.PermissionService;

public class PermissionServiceImpl implements PermissionService {

    private PermissionDao permissionDao;

    @Override
    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    @Override
    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }

    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }
}
