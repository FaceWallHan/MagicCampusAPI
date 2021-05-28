package com.hss.campus.controller.repair.form;

import com.hss.campus.controller.BaseServlet;
import com.hss.campus.entity.Repair;
import com.hss.campus.service.RepairService;
import com.hss.campus.service.impl.RepairServiceImpl;
import com.hss.campus.util.OtherUtil;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

//扫码报修上传到数据库
@WebServlet(urlPatterns = "/repairUploadDatabaseByCode")
public class RepairUploadByCodeServlet extends BaseServlet {
    private RepairService repairService = new RepairServiceImpl();

    @Override
    public Response operatingGet(HttpServletRequest request) {
        Response<String> response = new Response<>();
        Repair repair = getEntity(Repair.class);
        String url = OtherUtil.cutImageUrl(repair.getImage());
        if (!"".equals(url)) {
            repair.setImage(url);
        }
        repair.setSchedule(OtherUtil.REPAIR_STATUS[0]);
        if (repairService.insertByCode(repair)) {
            response.setCode(ResultCode.SUCCESS.code());
            response.setStatus(ResultCode.SUCCESS.status());
        } else {
            response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
            response.setStatus(ResultCode.USER_AVATAR_ERROR.status());
        }
        return response;
    }

    @Override
    public boolean isGet() {
        return false;
    }

}
