package com.github.xianzhan.shirospring.service;

import com.github.xianzhan.shirospring.entity.Role;

/**
 * @author Lee
 * @since 2017/3/7
 */
public interface RoleService {
    Role createRole(Role role);
    void deleteRole(Long roleId);

    /**
     * 添加角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    void correlationPermissions(Long roleId, Long... permissionIds);

    /**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    void uncorrelationPermissions(Long roleId, Long... permissionIds);
}
