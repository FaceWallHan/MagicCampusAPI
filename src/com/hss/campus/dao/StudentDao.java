package com.hss.campus.dao;


import com.hss.campus.entity.Student;

public interface StudentDao {
    //保存新学生
    int save(Student student);
    //查找学生
    Student queryStudentByIdAndPassword(Integer id,String password);
    //更新学生头像
    int updateAvatar(Integer id, String avatar);

    Student queryOne(Integer id,String name);
}
