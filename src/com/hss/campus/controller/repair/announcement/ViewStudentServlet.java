package com.hss.campus.controller.repair.announcement;

import com.hss.campus.controller.BaseServlet;
import com.hss.campus.entity.Announcement;
import com.hss.campus.service.AnnouncementService;
import com.hss.campus.service.impl.AnnouncementServiceImpl;
import com.hss.campus.util.OtherUtil;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

//学生查看公告
@WebServlet(urlPatterns = "/viewAnnouncementStu")
public class ViewStudentServlet extends BaseServlet {
    @Override
    public Response operatingGet(HttpServletRequest request) {
        Response<List<Announcement>> response = new Response<>();
        AnnouncementService announcementService = new AnnouncementServiceImpl();
        List<Announcement> list = announcementService.queryTime();
        if (list!=null){
            response.setCode(ResultCode.SUCCESS.code());
            response.setStatus(ResultCode.SUCCESS.status());
            response.setData(OtherUtil.updateImageUrl(list));
        }else {
            response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
            response.setStatus(ResultCode.USER_TEXT_ERROR.status());
        }
        return response;
    }

    @Override
    public boolean isGet() {
        return true ;
    }
}
