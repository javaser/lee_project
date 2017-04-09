package com.github.xianzhan.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("dubbo-provider.xml");
        context.start();
        System.out.println("服务提供开始。");
        System.in.read();
    }
}
