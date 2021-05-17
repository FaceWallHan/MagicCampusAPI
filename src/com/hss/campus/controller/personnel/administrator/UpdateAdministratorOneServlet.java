package com.hss.campus.controller.personnel.administrator;

import com.hss.campus.controller.BaseServlet;
import com.hss.campus.entity.ImageResponse;
import com.hss.campus.util.FileUtil;
import com.hss.campus.util.OtherUtil;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

//管理员上传头像到服务器
@WebServlet(urlPatterns = "/updateAdminHeaderServer")
public class UpdateAdministratorOneServlet extends BaseServlet {

    @Override
    public Response operatingGet(HttpServletRequest request) {
        Response<ImageResponse> response=new Response<>();
        ImageResponse imageResponse = FileUtil.receiveData(request, "administrator\\");
        if (!"".equals(imageResponse.getFileName())){
            response.setCode(ResultCode.SUCCESS.code());
            response.setStatus(ResultCode.SUCCESS.status());
            response.setData(new ImageResponse(OtherUtil.IP_ADDRESS+"image/administrator/"+imageResponse.getFileName()));
        }else {
            response.setCode(ResultCode.USER_LOGIN_ERROR.code());
            response.setStatus(ResultCode.USER_AVATAR_ERROR.status());
        }
        return response;
    }

    @Override
    public boolean isGet() {
        return false;
    }
}
