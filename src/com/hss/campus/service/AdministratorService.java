package com.hss.campus.service;

import com.hss.campus.entity.Administrator;

import java.util.List;

public interface AdministratorService {
    //管理员登录
    Administrator login(Integer id,String password);
    //更新头像
    int updateAvatar(Integer id, String avatar);
    //删除公告
    int deleteItem(Integer id);
    Administrator existAdministrator(Integer id,String name);
}
