package com.hss.campus.controller.repair.schedule;

import com.hss.campus.entity.Repair;
import com.hss.campus.util.OtherUtil;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//受理维修
@WebServlet(urlPatterns = "/queryStudentScheduleList")
public class QueryStudentScheduleServlet extends BaseRecordServlet {

    @Override
    public Response operatePost(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String schedule = req.getParameter("schedule");
        Response<List<Repair>> response=new Response();
        List<Repair> repairList = repairService.queryByStuSchedule(id, schedule);
        if (existStudent( name,id)){
            if (repairList!=null){
                for (int i = 0; i < repairList.size(); i++) {
                    Repair repair = repairList.get(i);
                    repair.setImage(OtherUtil.IP_ADDRESS+repair.getImage());
                    repairList.set(i,repair);
                }
                response.setCode(ResultCode.SUCCESS.code());
                response.setStatus(ResultCode.SUCCESS.status());
                response.setData(repairList);
            }else {
                response.setCode(ResultCode.USER_LOGIN_ERROR.code());
                response.setStatus(ResultCode.USER_LOGIN_ERROR.status());
            }
        }else {
            response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
            response.setStatus(ResultCode.USER_PARAMETER_ERROR.status());
        }
        return response;
    }
}
