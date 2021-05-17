package com.hss.campus.service.impl;


import com.hss.campus.dao.StudentDao;
import com.hss.campus.dao.impl.StudentDaoImpl;
import com.hss.campus.entity.Student;
import com.hss.campus.service.StudentService;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao=new StudentDaoImpl();

    //学生登录
    @Override
    public Student login(Integer id, String password) {
        return studentDao.queryStudentByIdAndPassword(id,password);
    }
    //添加学生
    @Override
    public int addStudent(Student student) {
        return studentDao.save(student);
    }
    //更新学生头像
    @Override
    public int updateAvatar(Integer id, String avatar) {
        return studentDao.updateAvatar(id,avatar);
    }

    @Override
    public Student queryOne(Integer id, String name) {
        return studentDao.queryOne(id, name);
    }

}
