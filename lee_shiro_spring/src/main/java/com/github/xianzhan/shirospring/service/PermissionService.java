package com.github.xianzhan.shirospring.service;

import com.github.xianzhan.shirospring.entity.Permission;

public interface PermissionService {
    Permission createPermission(Permission permission);
    void deletePermission(Long permissionId);
}
