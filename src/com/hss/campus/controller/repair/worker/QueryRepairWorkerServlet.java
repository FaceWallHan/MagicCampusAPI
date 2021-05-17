package com.hss.campus.controller.repair.worker;

import com.hss.campus.controller.BaseServlet;
import com.hss.campus.entity.RepairWorker;
import com.hss.campus.service.RepairWorkerService;
import com.hss.campus.service.impl.RepairWorkerServiceImpl;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

//查询全部维修工
@WebServlet(urlPatterns = "/queryAllRepairWorker")
public class QueryRepairWorkerServlet extends BaseServlet {
    private RepairWorkerService announcementService=new RepairWorkerServiceImpl();
    @Override
    public Response operatingGet(HttpServletRequest request) {
        Response<List<RepairWorker>> response=new Response<>();
        List<RepairWorker> list = announcementService.queryAll();
        if (list!=null){
            response.setCode(ResultCode.SUCCESS.code());
            response.setStatus(ResultCode.SUCCESS.status());
            response.setData(list);
        }else {
            response.setCode(ResultCode.USER_LOGIN_ERROR.code());
            response.setStatus(ResultCode.USER_AVATAR_ERROR.status());
        }
        return response;
    }

    @Override
    public boolean isGet() {
        return true;
    }
}
