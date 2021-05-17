package com.hss.campus.controller.personnel.student;

import com.hss.campus.controller.BaseServlet;
import com.hss.campus.entity.Student;
import com.hss.campus.service.StudentService;
import com.hss.campus.service.impl.StudentServiceImpl;
import com.hss.campus.util.OtherUtil;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

//学生登录
@WebServlet(urlPatterns = "/postStudentLogin")
public class StudentServlet extends BaseServlet {
    private StudentService studentService=new StudentServiceImpl();

    @Override
    public Response operatingGet(HttpServletRequest request) {
        Response<Student> resp=new Response<>();
        Student student = getEntity(Student.class);
        Integer id=student.getId();
        String password=student.getPassword();
        if (id != null && password !=null){
            Student login = studentService.login(student.getId(), student.getPassword());
            if (login!=null){
                login.setAvatar( OtherUtil.IP_ADDRESS+login.getAvatar());
                resp.setData(login);
                resp.setCode(ResultCode.SUCCESS.code());
                resp.setStatus(ResultCode.SUCCESS.status());
            }else {
                resp.setCode(ResultCode.USER_LOGIN_ERROR.code());
                resp.setStatus(ResultCode.USER_LOGIN_ERROR.status());
            }
        }else {
            resp.setCode(ResultCode.USER_LOGIN_ERROR.code());
            resp.setStatus(ResultCode.USER_LOGIN_ERROR.status());
        }
        return resp;
    }

    @Override
    public boolean isGet() {
        return false;
    }
}
