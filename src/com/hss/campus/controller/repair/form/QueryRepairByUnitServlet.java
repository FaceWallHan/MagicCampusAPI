package com.hss.campus.controller.repair.form;


import com.hss.campus.controller.repair.schedule.BaseRecordServlet;
import com.hss.campus.entity.Repair;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//根据部门获取订单数量
@WebServlet(urlPatterns = "/getRepairListByUnit")
public class QueryRepairByUnitServlet extends BaseRecordServlet {

    @Override
    public Response operatePost(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String area = req.getParameter("unit");
        Response<List<Repair>>response=new Response<>();
        if (existAdministrator(id, name)){
//            List<Repair> list = repairService.queryRepairListByArea(area);
//            if (list==null){
//                response.setStatus(ResultCode.USER_PARAMETER_ERROR.status());
//                response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
//            }else {
                response.setStatus(ResultCode.SUCCESS.status());
                response.setCode(ResultCode.SUCCESS.code());
//                response.setData(list);
//            }
            response.setStatus(ResultCode.SUCCESS.status());
            response.setCode(ResultCode.SUCCESS.code());
        }else {
            response.setStatus(ResultCode.USER_PARAMETER_ERROR.status());
            response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
        }
        return response;
    }
}
