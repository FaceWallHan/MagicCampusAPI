package com.hss.campus.controller.repair.form;

import com.hss.campus.controller.BaseServlet;
import com.hss.campus.entity.Repair;
import com.hss.campus.service.RepairService;
import com.hss.campus.service.impl.RepairServiceImpl;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

//显示报修
@WebServlet(urlPatterns = "/showRepair")
public class ShowRepairServlet extends BaseServlet {
    private RepairService repairService=new RepairServiceImpl();

    @Override
    public Response operatingGet(HttpServletRequest request) {
        Response<Repair> response=new Response<>();
        Repair repair=getEntity(Repair.class);
        Repair show=repairService.query(repair.getId());
        if (show !=null){
            response.setCode(ResultCode.SUCCESS.code());
            response.setStatus(ResultCode.SUCCESS.status());
            response.setData(show);
        }
        return response;
    }

    @Override
    public boolean isGet() {
        return false;
    }
}
