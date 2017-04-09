package com.github.xianzhan.dubbo;

import com.github.xianzhan.dubbo.service.ClientService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();

        ClientService demoService = (ClientService) context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法

        System.out.println(hello); // 显示调用结果
        System.out.println(demoService.like("Lee")); // 显示调用结果
    }
}
