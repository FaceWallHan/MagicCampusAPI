package com.hss.campus.controller.personnel.student;

import com.hss.campus.controller.BaseServlet;
import com.hss.campus.entity.ImageHeader;
import com.hss.campus.service.StudentService;
import com.hss.campus.service.impl.StudentServiceImpl;
import com.hss.campus.util.OtherUtil;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

//上传学生头像到数据库
@WebServlet(urlPatterns = "/uploadStuHeaderDatabase")
public class UpdateStudentTwoServlet extends BaseServlet {
    private StudentService studentService=new StudentServiceImpl();

    @Override
    public Response operatingGet(HttpServletRequest request) {
        ImageHeader imageHeader = getEntity(ImageHeader.class);
        Response response=new Response();
        if (imageHeader.isRealNull()){
            response.setCode(ResultCode.USER_LOGIN_ERROR.code());
            response.setStatus(ResultCode.USER_TEXT_ERROR.status());
        }else {
            String url = OtherUtil.cutImageUrl(imageHeader.getFileName());
            if (!"".equals(url)) {
                imageHeader.setFileName(url);
            }
            studentService.updateAvatar(imageHeader.getId(),imageHeader.getFileName());
            if (studentService.updateAvatar(imageHeader.getId(),imageHeader.getFileName()) != -1){
                response.setCode(ResultCode.SUCCESS.code());
                response.setStatus(ResultCode.SUCCESS.status());
            }else {
                response.setCode(ResultCode.USER_LOGIN_ERROR.code());
                response.setStatus(ResultCode.USER_TEXT_ERROR.status());
            }
        }
        return response;
    }

    @Override
    public boolean isGet() {
        return false;
    }
}
