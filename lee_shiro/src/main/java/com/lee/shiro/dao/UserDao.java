package com.lee.shiro.dao;

import com.lee.shiro.entity.User;

import java.util.Set;

public interface UserDao {
    User getByUsername(String username);

    Set<String> getRolesByUsername(String username);

    Set<String> getPermissionsByUsername(String username);
}
