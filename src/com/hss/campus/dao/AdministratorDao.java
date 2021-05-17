package com.hss.campus.dao;

import com.hss.campus.entity.Administrator;

public interface AdministratorDao {
    //管理员登录
    Administrator queryAdministrator(Integer id, String password);
    //更新头像
    int updateAvatar(Integer id, String avatar);
    //删除公告
    int deleteItem(Integer id);
     Administrator existAdministrator(Integer id,String name);
}
