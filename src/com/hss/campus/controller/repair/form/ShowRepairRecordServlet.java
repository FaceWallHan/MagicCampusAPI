package com.hss.campus.controller.repair.form;

import com.hss.campus.controller.BaseServlet;
import com.hss.campus.entity.RepairRecord;
import com.hss.campus.service.RepairRecordService;
import com.hss.campus.service.impl.RepairRecordServiceImpl;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

//显示维修记录
@WebServlet(urlPatterns = "/getRecordByRepairId")
public class ShowRepairRecordServlet extends BaseServlet {
    private RepairRecordService repairService=new RepairRecordServiceImpl();

    @Override
    public Response operatingGet(HttpServletRequest request) {
        Response<List<RepairRecord>> response=new Response<>();
        String repairId = request.getParameter("repairId");
        List<RepairRecord> list = repairService.querySimpleRecord(repairId);
        if (list !=null){
            response.setCode(ResultCode.SUCCESS.code());
            response.setStatus(ResultCode.SUCCESS.status());
            response.setData(list);
        }else {
            response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
            response.setStatus(ResultCode.USER_PARAMETER_ERROR.status());
        }
        System.out.println(repairId);
        return response;
    }

    @Override
    public boolean isGet() {
        return true;
    }
}
