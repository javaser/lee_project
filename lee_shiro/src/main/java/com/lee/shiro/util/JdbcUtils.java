package com.lee.shiro.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUtils {

    // 为了简便，此处不使用配置文件
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/java";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();

    public static Connection getConnection() {
        Connection connection = THREAD_LOCAL.get();
        if (connection != null) {
            return connection;
        } else {
            synchronized (JdbcUtils.class) {
                if (connection == null) {
                    try {
                        Class.forName(DRIVER);
                        connection = DriverManager.getConnection(JDBC_URL,
                                USERNAME, PASSWORD);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                THREAD_LOCAL.set(connection);
                return connection;
            }
        }
    }

    public static void closeConnection() {
        Connection connection = THREAD_LOCAL.get();
        if (connection != null) {
            try {
                connection.close();
                THREAD_LOCAL.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static PreparedStatement getPreparedStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
}
