package com.lee.shiro.util;

import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {

    @Test
    public void getConnectionTest() {
        Connection connection = JdbcUtils.getConnection();
        System.out.println(connection);
        JdbcUtils.closeConnection();
    }
}
