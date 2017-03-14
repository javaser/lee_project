package com.github.xianzhan.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.List;

@XStreamAlias(value = "teacher")
public class Teacher {
    @XStreamAsAttribute
    private String name;
    @XStreamAsAttribute
    private String phone;
    @XStreamAsAttribute
    private int age;
    @XStreamImplicit(itemFieldName = "student")
    private List<Student> students;

    public Teacher() {
    }

    public Teacher(String name, String phone, int age, List<Student> students) {
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}