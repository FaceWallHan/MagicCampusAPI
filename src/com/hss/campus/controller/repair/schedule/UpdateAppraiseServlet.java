package com.hss.campus.controller.repair.schedule;

import com.hss.campus.util.OtherUtil;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//学生评价维修结果
@WebServlet(urlPatterns = "/updateAppraise")
public class UpdateAppraiseServlet extends BaseRecordServlet {

    @Override
    public Response operatePost(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Integer repairId = Integer.parseInt(req.getParameter("repairId"));
        String appraise =req.getParameter("appraise");
        String description =req.getParameter("description");
        Response response=new Response();
        //判断学生是否存在
        if (existStudent(name,id)){
            //插入受理记录
            boolean insert  = recordService.insertRecord(name, OtherUtil.REPAIR_SCHEDULE[4], repairId,appraise);
            //维修订单已评价
            boolean update = repairService.appraiseRepair(repairId, appraise,description);
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
