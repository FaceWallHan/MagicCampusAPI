package com.hss.campus.controller.repair.announcement;

import com.hss.campus.controller.BaseServlet;
import com.hss.campus.entity.Announcement;
import com.hss.campus.service.AdministratorService;
import com.hss.campus.service.impl.AdministratorServiceImpl;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

//删除公告
@WebServlet(urlPatterns = "/deleteAnnouncement")
public class DeleteServlet extends BaseServlet {
    @Override
    public Response operatingGet(HttpServletRequest request) {
        Response<Integer> response=new Response<>();
        AdministratorService administratorService=new AdministratorServiceImpl();
        Announcement announcement=getEntity(Announcement.class);
        if (announcement.getId() != null){
            response.setCode(ResultCode.DELETE.code());
            response.setStatus(ResultCode.DELETE.status());
            response.setData(administratorService.deleteItem(announcement.getId()));
        }else {
            response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
            response.setStatus(ResultCode.USER_TEXT_ERROR.status());
        }
        return response;
    }

    @Override
    public boolean isGet() {
        return false;
    }
}
