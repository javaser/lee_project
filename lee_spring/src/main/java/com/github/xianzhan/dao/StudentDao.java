package com.github.xianzhan.dao;

import com.github.xianzhan.bean.Student;

import java.util.List;

/**
 * 学生存取对象接口
 */
public interface StudentDao {
    /**
     * 添加学生
     *
     * @param student
     */
    void save(Student student);

    /**
     * 根据 id 删除记录
     *
     * @param id
     */
    void remove(int id);

    /**
     * 更新学生
     *
     * @param student
     */
    void update(Student student);

    /**
     * 获取一个学生
     *
     * @param id
     * @return
     */
    Student getStudent(int id);

    /**
     * 学生列表
     *
     * @return
     */
    List<Student> listStudent();
}
