package com.hss.campus.controller.repair;

import com.hss.campus.controller.BaseServlet;
import com.hss.campus.entity.RepairProject;
import com.hss.campus.service.RepairProjectService;
import com.hss.campus.service.impl.RepairProjectServiceImpl;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

//报修项目
@WebServlet(urlPatterns = "/repairProject")
public class RepairProjectServlet extends BaseServlet {
    private RepairProjectService repairProjectService=new RepairProjectServiceImpl();

    @Override
    public Response operatingGet(HttpServletRequest request) {
        Response<List<RepairProject>> response=new Response<>();
        List<RepairProject> list=repairProjectService.query();
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
