package com.github.xianzhan.shirospring.dao;

import com.github.xianzhan.shirospring.entity.Role;

/**
 * @author Lee
 * @since 2017/3/7
 */
public interface RoleDao {
    public Role createRole(Role role);
    public void deleteRole(Long roleId);

    public void correlationPermissions(Long roleId, Long... permissionIds);
    public void uncorrelationPermissions(Long roleId, Long... permissionIds);
}
