package com.hss.campus.controller.repair.schedule;

import com.hss.campus.util.OtherUtil;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//受理维修
@WebServlet(urlPatterns = "/updateAccept")
public class UpdateAcceptServlet extends BaseRecordServlet {

    @Override
    public Response operatePost(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Integer repairId = Integer.parseInt(req.getParameter("repairId"));
        Response response=new Response();
        if (existAdministrator(id, name)){
            //插入受理记录
            boolean insert  = recordService.insertRecord(name, OtherUtil.REPAIR_SCHEDULE[0], repairId,"");
            //维修订单已受理
            boolean update = repairService.updateStatus(repairId, OtherUtil.REPAIR_STATUS[1]);
            if (insert&&update){
                response.setCode(ResultCode.SUCCESS.code());
                response.setStatus(ResultCode.SUCCESS.status());
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
