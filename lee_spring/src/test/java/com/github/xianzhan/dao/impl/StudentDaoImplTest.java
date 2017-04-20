package com.github.xianzhan.dao.impl;

import com.github.xianzhan.bean.Student;
import com.github.xianzhan.dao.StudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-jdbc.xml"})
public class StudentDaoImplTest {

    @Resource
    private StudentDao studentDao;

    @Test
    public void testSave() {
        Student lee = new Student("李", 100);
        studentDao.save(lee);
    }

    @Test
    public void testRemove() {
        int id = 1;
        studentDao.remove(id);
    }

    @Test
    public void testUpdate() {
        Student student = new Student("li", 99);
        student.setId(4);
        studentDao.update(student);
    }

    @Test
    public void testGetStudent() {
        Student student = studentDao.getStudent(4);
        System.out.println(student);
    }

    @Test
    public void testListStudent() {
        List<Student> list = studentDao.listStudent();
        System.out.println(list);
    }
}
