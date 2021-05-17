package com.hss.campus.controller.repair.schedule;

import com.hss.campus.entity.Repair;
import com.hss.campus.entity.RepairWorker;
import com.hss.campus.util.OtherUtil;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//维修工签到
@WebServlet(urlPatterns = "/workSign")
public class UpdateSignServlet extends BaseRecordServlet {

    @Override
    public Response operatePost(HttpServletRequest req, HttpServletResponse resp) {
        Integer repairId = Integer.parseInt(req.getParameter("repairId"));
        Response response = new Response();
        //判断维修工是否存在且在维修中
        RepairWorker repairWorker = repairService.queryWorker(repairId);
        if (!repairWorker.isNull()) {
            //插入维修工签到记录
            boolean updateStatus = repairService.updateStatus(repairId, OtherUtil.REPAIR_STATUS[5]);
            boolean insert = recordService.insertRecord(repairWorker.getName(), OtherUtil.REPAIR_SCHEDULE[2], repairId, repairWorker.getPhone());
            if (insert&updateStatus) {
                response.setCode(ResultCode.SUCCESS.code());
                response.setStatus(ResultCode.SUCCESS.status());
            } else {
                response.setCode(ResultCode.USER_LOGIN_ERROR.code());
                response.setStatus(ResultCode.USER_LOGIN_ERROR.status());
            }
        } else {
            response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
            response.setStatus(ResultCode.USER_PARAMETER_ERROR.status());
        }
        return response;
    }
}
