package com.lee.shiro;

import com.lee.shiro.util.ShiroUtils;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class PermissionTest {

    @Test
    public void isPermitted() {
        Subject currentUser = ShiroUtils.login("classpath:basePermission.ini",
                "lee1", "123");
        System.out.println(currentUser.isPermitted("user:select"));
    }
}
