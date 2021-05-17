package com.hss.campus.dao.impl;

import com.hss.campus.dao.AdministratorDao;
import com.hss.campus.dao.BaseDao;
import com.hss.campus.entity.Administrator;

public class AdministratorDaoImpl extends BaseDao implements AdministratorDao {

    //管理员登录
    @Override
    public Administrator queryAdministrator(Integer id, String password) {
        String sql="select id,password,position,avatar ,name from administrator where id=? and password=?";
        return queryForOne(Administrator.class,sql,id,password);
    }

    //更新头像
    @Override
    public int updateAvatar(Integer id, String avatar) {
        String sql="update administrator set avatar=? where id=?";
        return update(sql,avatar,id);
    }


    //删除公告
    @Override
    public int deleteItem(Integer id) {
        String sql="delete from announcement where id=?";
        return update(sql,id);
    }

    @Override
    public Administrator existAdministrator(Integer id,String name) {
        String sql="select id,password,position,avatar from administrator where id=? and name=?";
        return queryForOne(Administrator.class, sql, id,name);
    }
}
