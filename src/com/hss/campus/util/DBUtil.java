package com.hss.campus.util;

import org.apache.commons.dbutils.DbUtils;

import java.sql.*;

/*
JDBC工具类,简化JDBC编程
 */
public class DBUtil {


    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public  DBUtil() {
    }

    /**
     * 获取数据库连接对象
     * @return  连接对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://39.101.165.25:3306/smartCampus?useUnicode=true&characterEncoding=utf8", "root", "777");
//      return DriverManager.getConnection("jdbc:mysql://localhost:3306/smartCampus?useUnicode=true&characterEncoding=utf8", "root", "123456");
    }

    /**
     * 关闭资源
     * @param conn  连接对象
     * @param stmt  数据库操作对象
     * @param rs    结果集
     */
    public static void close(Connection conn , Statement stmt, ResultSet rs ){
        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(stmt);
        DbUtils.closeQuietly(rs);
    }
}
