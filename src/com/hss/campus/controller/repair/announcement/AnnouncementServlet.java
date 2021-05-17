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
import java.text.SimpleDateFormat;
import java.util.Date;

//发布公告
@WebServlet(urlPatterns = "/getAnnouncement")
public class AnnouncementServlet extends BaseServlet {
    private AnnouncementService announcementService = new AnnouncementServiceImpl();

    @Override
    public boolean isGet() {
        return false;
    }

    @Override
    public Response operatingGet(HttpServletRequest request) {
        Response<Announcement> response = new Response<>();
        Announcement announcement = getEntity(Announcement.class);
        if (announcement != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strTime = sdf.format(new Date(System.currentTimeMillis()));
            announcement.setTime(strTime);
            String image = announcement.getImage();
            if (!"".equals(image)){
                String url = OtherUtil.cutImageUrl(announcement.getImage());
                if (!"".equals(url)) {
                    announcement.setImage(url);
                }
            }else {
                announcement.setImage("image/announcement/avatar_default.png");
            }

            if (announcementService.insert(announcement) != -1) {
                response.setCode(ResultCode.SUCCESS.code());
                response.setStatus(ResultCode.SUCCESS.status());
            }else {
                response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
                response.setStatus(ResultCode.USER_PARAMETER_ERROR.status());
            }
        } else {
            response.setCode(ResultCode.USER_TEXT_ERROR.code());
            response.setStatus(ResultCode.USER_TEXT_ERROR.status());
        }

        return response;
    }
}
