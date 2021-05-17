package com.hss.campus.service.impl;


import com.hss.campus.dao.AnnouncementDao;
import com.hss.campus.dao.impl.AnnouncementDaoImpl;
import com.hss.campus.entity.Announcement;
import com.hss.campus.service.AnnouncementService;

import java.util.List;

public class AnnouncementServiceImpl implements AnnouncementService {
    private AnnouncementDao dao=new AnnouncementDaoImpl();

    //插入公告
    @Override
    public int insert(Announcement announcement) {
        return dao.insert(announcement);
    }
    //查看公告
    @Override
    public List<Announcement> queryTime(Integer id) {
        return dao.queryTime(id);
    }

    @Override
    public List<Announcement> queryTime() {
        return dao.queryTime();
    }

    //插入图片
    @Override
    public int updateAvatar(Integer id, String image) {
        return dao.updateAvatar(id,image);
    }
}
