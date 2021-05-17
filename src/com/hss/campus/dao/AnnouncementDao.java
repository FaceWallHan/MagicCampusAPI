package com.hss.campus.dao;

import com.hss.campus.entity.Announcement;

import java.util.List;

public interface AnnouncementDao {
    //插入公告
    int insert(Announcement announcement);
    //管理员查看公告
    List<Announcement> queryTime(Integer id);
    //学生查看公告
    List<Announcement> queryTime();
    //插入图片
    int updateAvatar(Integer id, String image);
}
