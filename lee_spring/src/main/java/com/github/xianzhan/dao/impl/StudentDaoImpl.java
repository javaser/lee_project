package com.github.xianzhan.dao.impl;

import com.github.xianzhan.bean.Student;
import com.github.xianzhan.dao.StudentDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public void save(Student student) {
        String sql = "INSERT INTO student(name, score) VALUES(?, ?)";
        jdbcTemplate.update(sql, new Object[]{student.getName(), student.getScore()});
    }

    public void remove(int id) {
        String sql = "DELETE FROM student WHERE id=?";
        jdbcTemplate.update(sql, new Object[]{id});
    }

    public void update(Student student) {
        String sql = "UPDATE student SET name=?, score=? WHERE id=?";
        jdbcTemplate.update(sql, new Object[]{student.getName(),
                student.getScore(), student.getId()});
    }

    public Student getStudent(int id) {
        String sql = "SELECT name, score FROM student WHERE id=" + id;
        final Student student = new Student();
        student.setId(id);
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                student.setName(resultSet.getString("name"));
                student.setScore(resultSet.getInt("score"));
            }
        });
        return student;
    }

    public List<Student> listStudent() {
        String sql = "SELECT id, name, score FROM student";
        final List<Student> list = new ArrayList<Student>();
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setScore(rs.getInt("score"));
                list.add(student);
            }
        });
        return list;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
