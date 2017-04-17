package com.github.xianzhan;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Task {
    public static void main(String[] args) {
        String path = "spring-task.xml";
        ClassPathXmlApplicationContext cpac =
                new ClassPathXmlApplicationContext(path);
        cpac.start();
    }
}
