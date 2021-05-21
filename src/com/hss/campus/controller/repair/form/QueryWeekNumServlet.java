package com.hss.campus.controller.repair.form;


import com.hss.campus.controller.repair.schedule.BaseRecordServlet;
import com.hss.campus.entity.DayRepairNum;
import com.hss.campus.entity.Repair;
import com.hss.campus.util.OtherUtil;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

//获取当周的订单数量
@WebServlet(urlPatterns = "/getWeekNum")
public class QueryWeekNumServlet extends BaseRecordServlet {

    @Override
    public Response operatePost(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Response<List<DayRepairNum>>response=new Response<>();
        if (existAdministrator(id, name)){
            List<DayRepairNum> list=new ArrayList<>();
            for (int i = 6; i >-1 ; i--) {
                String day = OtherUtil.getOneDayByDistance(i);
                list.add(new DayRepairNum(day,repairService.queryBeforeWeek(day)));
            }
            response.setStatus(ResultCode.SUCCESS.status());
            response.setCode(ResultCode.SUCCESS.code());
            response.setData(list);
        }else {
            response.setStatus(ResultCode.USER_PARAMETER_ERROR.status());
            response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
        }
        return response;
    }
}
