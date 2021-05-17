package com.hss.campus.dao;


import com.hss.campus.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public  abstract class BaseDao {
    private QueryRunner runner=new QueryRunner();
    public int update(String sql,Object ... args){
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            return runner.update(connection,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }
    public <T> T queryForOne(Class<T> clazz,String sql, Object ... args){
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            return runner.query(connection, sql, new BeanHandler<T>(clazz),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }
    public <T> List<T> queryForList(Class<T> clazz, String sql, Object ... args){
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            return runner.query(connection, sql, new BeanListHandler<T>(clazz),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }
    public Object queryForSimpleValue( String sql, Object ... args){
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            return runner.query(connection, sql, new ScalarHandler<>(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

}
