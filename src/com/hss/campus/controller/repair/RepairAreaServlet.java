package com.hss.campus.controller.repair;

import com.hss.campus.controller.BaseServlet;
import com.hss.campus.entity.RepairArea;
import com.hss.campus.service.RepairAreaService;
import com.hss.campus.service.impl.RepairAreaServiceImpl;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

//报修区域
@WebServlet(urlPatterns = "/repairArea")
public class RepairAreaServlet extends BaseServlet {
    private RepairAreaService repairAreaService=new RepairAreaServiceImpl();
    @Override
    public Response operatingGet(HttpServletRequest request) {
        Response<List<RepairArea>> response=new Response<>();
        List<RepairArea> list=repairAreaService.query();
        response.setCode(ResultCode.SUCCESS.code());
        response.setStatus(ResultCode.SUCCESS.status());
        response.setData(list);
        return response;
    }

    @Override
    public boolean isGet() {
        return true;
    }
}
