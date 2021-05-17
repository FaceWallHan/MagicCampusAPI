package com.hss.campus.controller.repair.announcement;

import com.hss.campus.controller.BaseServlet;
import com.hss.campus.entity.ImageResponse;
import com.hss.campus.service.AnnouncementService;
import com.hss.campus.service.impl.AnnouncementServiceImpl;
import com.hss.campus.util.FileUtil;
import com.hss.campus.util.OtherUtil;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

//上传公告图片到服务器
@WebServlet(urlPatterns = "/addAnnImageServer")
public class UpdateImageServlet extends BaseServlet {
    private AnnouncementService announcementService=new AnnouncementServiceImpl();
    @Override
    public Response operatingGet(HttpServletRequest request) {
        Response<ImageResponse> response=new Response<>();
        ImageResponse imageResponse = FileUtil.receiveData(request, "announcement\\");
        if (!"".equals(imageResponse.getFileName())){
            response.setCode(ResultCode.SUCCESS.code());
            response.setStatus(ResultCode.SUCCESS.status());
            response.setData(new ImageResponse(OtherUtil.IP_ADDRESS+"image/announcement/"+imageResponse.getFileName()));
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
