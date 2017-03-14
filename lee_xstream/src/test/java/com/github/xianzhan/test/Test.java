package com.github.xianzhan.test;

import com.github.xianzhan.entity.Student;
import com.github.xianzhan.entity.Teacher;
import com.github.xianzhan.util.XmlUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lee
 * @since 2017/3/14
 */
public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("Aaron", 24, "广州");
        Student student2 = new Student("Abel", 23, "北京");
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        Teacher teacher = new Teacher("Dave", "020-123456", 46, students);
        String xml = XmlUtils.toXml(teacher);
        System.out.println(xml);
    }
}
