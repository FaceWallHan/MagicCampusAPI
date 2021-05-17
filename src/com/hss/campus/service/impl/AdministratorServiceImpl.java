package com.hss.campus.service.impl;

import com.hss.campus.dao.AdministratorDao;
import com.hss.campus.dao.impl.AdministratorDaoImpl;
import com.hss.campus.entity.Administrator;
import com.hss.campus.service.AdministratorService;

import java.util.List;

public class AdministratorServiceImpl implements AdministratorService {
    private AdministratorDao administratorDao=new AdministratorDaoImpl();

    //管理员登录
    @Override
    public Administrator login(Integer id, String passwrod) {
        return administratorDao.queryAdministrator(id,passwrod);
    }

    //更新头像
    @Override
    public int updateAvatar(Integer id, String avatar) {
        return administratorDao.updateAvatar(id,avatar);
    }

    //删除公告
    @Override
    public int deleteItem(Integer id) {
        return administratorDao.deleteItem(id);
    }

    @Override
    public Administrator existAdministrator(Integer id,String name) {
        return administratorDao.existAdministrator(id,name);
    }
}
