package com.lee.shiro.dao;

import com.lee.shiro.dao.impl.UserDaoImpl;
import com.lee.shiro.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class UserDaoTest {

    private UserDao userDao;

    @Before
    public void before() {
        userDao = new UserDaoImpl();
    }

    @Test
    public void getByUsername() {
        User user = userDao.getByUsername("lee1");
        System.out.println(user);
    }

    @Test
    public void getRolesByUsername() {
        Set<String> set = userDao.getRolesByUsername("lee1");
        System.out.println(set);
    }

    @Test
    public void getPermissionsByUsername() {
        Set<String> set = userDao.getPermissionsByUsername("lee2");
        System.out.println(set);
    }
}
