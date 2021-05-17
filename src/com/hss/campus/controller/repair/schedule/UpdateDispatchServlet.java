package com.hss.campus.controller.repair.schedule;

import com.hss.campus.util.OtherUtil;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//派遣维修工
@WebServlet(urlPatterns = "/updateDispatch")
public class UpdateDispatchServlet extends BaseRecordServlet {

    @Override
    public Response operatePost(HttpServletRequest req, HttpServletResponse resp) {
        String phone = req.getParameter("phone");
        String name = req.getParameter("name");
        Integer repairId = Integer.parseInt(req.getParameter("repairId"));
        Response response=new Response();
        //判断维修工是否存在且空闲
        if (existWorker(phone,name,OtherUtil.REPAIR_WORKER_STATUS[1])){
            //插入受理记录
            boolean insert  = recordService.insertRecord(name, OtherUtil.REPAIR_SCHEDULE[1], repairId,phone);
            //维修订单已受理
            boolean update = repairService.updateStatus(repairId, OtherUtil.REPAIR_STATUS[2]);
            //维修订单插入维修工
            boolean insertWorker = repairService.insertWorker(name,repairId);
            //更新维修工的状态
            boolean workerStatus = workerService.updateWorkerStatus(OtherUtil.REPAIR_WORKER_STATUS[0], name, phone);
            if (insert&&update&workerStatus&insertWorker){
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
