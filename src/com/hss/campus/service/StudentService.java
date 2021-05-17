package com.hss.campus.service;


import com.hss.campus.entity.Student;

public interface StudentService {
    //学生登录
    Student login(Integer id,String password);
    //添加学生
    int addStudent(Student student);
    //更新学生头像
    int updateAvatar(Integer id, String avatar);

    Student queryOne(Integer id,String name);

}
