package com.hss.campus.controller.repair.announcement;

import com.hss.campus.controller.BaseServlet;
import com.hss.campus.entity.Repair;
import com.hss.campus.service.RepairService;
import com.hss.campus.service.impl.RepairServiceImpl;
import com.hss.campus.util.OtherUtil;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

//报修列表
@WebServlet(urlPatterns = "/repairList")
public class RepairListServlet extends BaseServlet {
    private RepairService repairService=new RepairServiceImpl();
    @Override
    public Response operatingGet(HttpServletRequest request) {
        Response<List<Repair>> response=new Response<>();
        List<Repair> list=repairService.queryList();
        if (list!=null){
            for (int i = 0; i < list.size(); i++) {
                Repair repair = list.get(i);
                repair.setImage(OtherUtil.IP_ADDRESS+repair.getImage());
                list.set(i,repair);
            }
            response.setCode(ResultCode.SUCCESS.code());
            response.setStatus(ResultCode.SUCCESS.status());
            response.setData(list);
        }else {
            response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
            response.setStatus(ResultCode.USER_PARAMETER_ERROR.status());
        }

        return response;
    }

    @Override
    public boolean isGet() {
        return true;
    }
}
