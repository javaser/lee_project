package com.lee.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class HelloShiro {
    public static void main(String[] args) {
        // 读取配置文件，初始化 SecurityManager 工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // 获取 SecurityManager 实例
        SecurityManager securityManager = factory.getInstance();
        // 把 SecurityManager 实例绑定到 SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        // 得到当前执行的用户
        Subject currentUser = SecurityUtils.getSubject();

        // 创建 token 令牌，用户名/密码
        UsernamePasswordToken token = new UsernamePasswordToken("lee",
                "123456");

        try {
            // 登录
            currentUser.login(token);
            System.out.println("身份认证成功");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("身份认证失败");
        }
        // 退出
        currentUser.logout();
    }
}
