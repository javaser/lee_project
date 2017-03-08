package com.github.xianzhan.shirospring.service.impl;

import com.github.xianzhan.shirospring.dao.UserDao;
import com.github.xianzhan.shirospring.entity.User;
import com.github.xianzhan.shirospring.helper.PasswordHelper;
import com.github.xianzhan.shirospring.service.UserService;

import java.util.Set;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private PasswordHelper passwordHelper;

    @Override
    public User createUser(User user) {
        //加密密码
        passwordHelper.encryptPassword(user);
        return userDao.createUser(user);
    }

    @Override
    public void changePassword(Long userId, String newPassword) {
        User user = userDao.findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);
    }

    /**
     * 添加用户-角色关系
     *
     * @param userId
     * @param roleIds
     */
    @Override
    public void correlationRoles(Long userId, Long... roleIds) {
        userDao.correlationRoles(userId, roleIds);
    }

    /**
     * 移除用户-角色关系
     *
     * @param userId
     * @param roleIds
     */
    @Override
    public void uncorrelationRoles(Long userId, Long... roleIds) {
        userDao.uncorrelationRoles(userId, roleIds);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public Set<String> findRoles(String username) {
        return userDao.findRoles(username);
    }

    @Override
    public Set<String> findPermissions(String username) {
        return userDao.findPermissions(username);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setPasswordHelper(PasswordHelper passwordHelper) {
        this.passwordHelper = passwordHelper;
    }
}
