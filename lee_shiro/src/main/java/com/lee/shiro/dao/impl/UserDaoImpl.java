package com.lee.shiro.dao.impl;

import com.lee.shiro.dao.UserDao;
import com.lee.shiro.entity.User;
import com.lee.shiro.util.JdbcUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * 此 DAO 类只作测试
 */
public class UserDaoImpl implements UserDao {

    @Override
    public User getByUsername(String username) {
        String sql = "SELECT uid, username, password FROM t_user WHERE " +
                "username = ?";
        PreparedStatement ps = JdbcUtils.getPreparedStatement(sql);
        User user = new User();
        try {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            // 只取一个，用户名也应该只有一个
            if (rs.next()) {
                user.setUid(rs.getInt("uid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Set<String> getRolesByUsername(String username) {
        String sql = "SELECT rolename FROM t_user u, t_role r " +
                "WHERE u.rid = r.rid AND u.username = ?";
        String column = "rolename";
        return getSet(username, sql, column);
    }

    @Override
    public Set<String> getPermissionsByUsername(String username) {
        String sql = "SELECT permissionname FROM t_user u, t_role r, t_permission p " +
                "WHERE u.rid = r.rid AND p.rid = r.rid AND u.username = ?";
        String column = "permissionname";
        return getSet(username, sql, column);
    }

    private Set<String> getSet(String username, String sql, String column) {
        Set<String> set = new HashSet<>();
        PreparedStatement ps = JdbcUtils.getPreparedStatement(sql);
        try {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                set.add(rs.getString(column));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }
}
