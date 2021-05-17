package com.hss.campus.controller.repair.worker;

import com.hss.campus.controller.BaseServlet;
import com.hss.campus.entity.RepairWorker;
import com.hss.campus.service.RepairWorkerService;
import com.hss.campus.service.impl.RepairWorkerServiceImpl;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

//删除维修工
@WebServlet(urlPatterns = "/insertWorker")
public class InsertWorkerServlet extends BaseServlet {
    private RepairWorkerService service=new RepairWorkerServiceImpl();
    @Override
    public Response operatingGet(HttpServletRequest request) {
        Response<Integer> response=new Response<>();
        RepairWorker entity = getEntity(RepairWorker.class);
        if (entity!=null){
            if (service.insert(entity)!=-1){
                response.setCode(ResultCode.SUCCESS.code());
                response.setStatus(ResultCode.SUCCESS.status());
            }else {
                response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
                response.setStatus(ResultCode.USER_PARAMETER_ERROR.status());
            }
        }else {
            response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
            response.setStatus(ResultCode.USER_PARAMETER_ERROR.status());
        }
        return response;
    }

    @Override
    public boolean isGet() {
        return false;
    }
}
