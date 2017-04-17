package com.github.xianzhan;

import com.github.xianzhan.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCAndDI {
    public static void main(String[] args) {
        String path = "applicationContext.xml";
        ApplicationContext ac =
                new ClassPathXmlApplicationContext(path);
        Student xiaoming = (Student) ac.getBean("xiaoming");
        System.out.println(xiaoming);
    }
}
