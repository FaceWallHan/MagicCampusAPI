package com.hss.campus.controller.repair.worker;

import com.hss.campus.controller.BaseServlet;
import com.hss.campus.controller.repair.schedule.BaseRecordServlet;
import com.hss.campus.entity.RepairWorker;
import com.hss.campus.entity.Unit;
import com.hss.campus.service.RepairWorkerService;
import com.hss.campus.service.impl.RepairWorkerServiceImpl;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//删除维修工
@WebServlet(urlPatterns = "/getAllUnit")
public class QueryUintServlet extends BaseRecordServlet {

    @Override
    public Response operatePost(HttpServletRequest req, HttpServletResponse resp) {
        List<Unit> allUnit = unitService.getAllUnit();
        Response<List<Unit>> response=new Response<>();
        if (allUnit!=null){
            response.setData(allUnit);
            response.setCode(ResultCode.SUCCESS.code());
            response.setStatus(ResultCode.SUCCESS.status());
        }else {
            response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
            response.setStatus(ResultCode.USER_PARAMETER_ERROR.status());
        }
        return response;
    }
}
