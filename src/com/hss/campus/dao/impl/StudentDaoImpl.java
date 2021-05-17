package com.hss.campus.dao.impl;


import com.hss.campus.dao.BaseDao;
import com.hss.campus.dao.StudentDao;
import com.hss.campus.entity.Student;

public class StudentDaoImpl extends BaseDao implements StudentDao {
    //保存新学生
    @Override
    public int save(Student student) {
        String sql= "INSERT INTO `smartcampus`.`student` (`id`, `name`, `password`, `sex`, `idcard`, `address`, `phone`, `departments`) " +
                "VALUES (?, ?, ?, ?, ?, ?，？，？)";
        return update(sql,student.getId(),student.getName(),student.getPassword(),student.getSex(), student.getIdCard(),student.getAddress(),
                student.getPhone(),student.getDepartments());
    }

    //查找学生
    @Override
    public Student queryStudentByIdAndPassword(Integer id, String password) {
        String sql="select id,name,sex,idcard as idCard,address,avatar,phone,departments from student where id=? and password=?";
        return queryForOne(Student.class,sql,id,password);
    }

    //更新学生头像
    @Override
    public int updateAvatar(Integer id, String avatar) {
        String sql="update student set avatar=? where id=?";
        return update(sql,avatar,id);
    }

    @Override
    public Student queryOne(Integer id, String name) {
        String sql="select id,name,password,sex,idcard,address,avatar,phone,departments from student where id=? and name=?";
        return queryForOne(Student.class, sql, id,name);
    }

}
