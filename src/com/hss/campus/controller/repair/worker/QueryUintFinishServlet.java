package com.hss.campus.controller.repair.worker;

import com.hss.campus.controller.repair.schedule.BaseRecordServlet;
import com.hss.campus.entity.Unit;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//删除维修工
@WebServlet(urlPatterns = "/getUnitFinishNum")
public class QueryUintFinishServlet extends BaseRecordServlet {

    @Override
    public Response operatePost(HttpServletRequest req, HttpServletResponse resp) {
        Response<Integer> response=new Response<>();
        String unit = req.getParameter("unit");
        response.setData(unitService.queryUnitFinishNum(unit));
        response.setCode(ResultCode.SUCCESS.code());
        response.setStatus(ResultCode.SUCCESS.status());
        return response;
    }
}
