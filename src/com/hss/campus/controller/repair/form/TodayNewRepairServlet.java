package com.hss.campus.controller.repair.form;


import com.hss.campus.controller.BaseServlet;
import com.hss.campus.controller.repair.schedule.BaseRecordServlet;
import com.hss.campus.entity.ImageResponse;
import com.hss.campus.service.AdministratorService;
import com.hss.campus.service.impl.AdministratorServiceImpl;
import com.hss.campus.util.FileUtil;
import com.hss.campus.util.OtherUtil;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//今日新增订单
@WebServlet(urlPatterns = "/getTodayNewRepair")
public class TodayNewRepairServlet extends BaseRecordServlet {

    @Override
    public Response operatePost(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String day = req.getParameter("day");
        Response<Long>response=new Response<>();
        if (existAdministrator(id, name)){
            response.setStatus(ResultCode.SUCCESS.status());
            response.setCode(ResultCode.SUCCESS.code());
            response.setData(repairService.queryRepairNum(day));
        }else {
            response.setStatus(ResultCode.USER_PARAMETER_ERROR.status());
            response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
        }
        return response;
    }
}
