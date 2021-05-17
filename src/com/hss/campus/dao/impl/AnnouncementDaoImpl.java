package com.hss.campus.dao.impl;

import com.hss.campus.dao.AnnouncementDao;
import com.hss.campus.dao.BaseDao;
import com.hss.campus.entity.Announcement;

import java.util.List;

public class AnnouncementDaoImpl extends BaseDao implements AnnouncementDao {

    //插入公告
    @Override
    public int insert(Announcement announcement) {
        String sql="insert into announcement(a_id,author,title,content,image,time) values(?,?,?,?,?,?)";
        return update(sql,announcement.getA_id(),announcement.getAuthor(),announcement.getTitle(),
                announcement.getContent(), announcement.getImage(),announcement.getTime());
    }

    //管理员查看公告
    @Override
    public List<Announcement> queryTime(Integer id) {
        String sql="select * from announcement WHERE a_id=? ";
        return queryForList(Announcement.class,sql,id);
    }

    //学生查看公告
    @Override
    public List<Announcement> queryTime() {
        String sql="select * from announcement ORDER BY time desc LIMIT 0,5";
        return queryForList(Announcement.class,sql);
    }

    //插入图片
    @Override
    public int updateAvatar(Integer id, String image) {
        String sql="update announcement set image=? where id=?";
        return update(sql,image,id);
    }
}
