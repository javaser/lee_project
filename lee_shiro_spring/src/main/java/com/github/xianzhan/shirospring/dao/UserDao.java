package com.github.xianzhan.shirospring.dao;

import com.github.xianzhan.shirospring.entity.User;

import java.util.Set;

/**
 * @author Lee
 * @since 2017/3/7
 */
public interface UserDao {
    public User createUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long userId);

    public void correlationRoles(Long userId, Long... roleIds);
    public void uncorrelationRoles(Long userId, Long... roleIds);

    User findOne(Long userId);

    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}
