package com.github.xianzhan.shirospring.dao;

import com.github.xianzhan.shirospring.entity.Permission;

/**
 * @author Lee
 * @since 2017/3/7
 */
public interface PermissionDao {

    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);
}
