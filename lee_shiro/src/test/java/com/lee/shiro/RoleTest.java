package com.lee.shiro;

import com.lee.shiro.util.ShiroUtils;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class RoleTest {

    @Test
    public void HasRoleTest() {
        Subject currentUser = ShiroUtils.login("classpath:baseRole.ini",
                "lee1", "123");
        System.out.println(currentUser.hasRole("role1"));
    }
}
