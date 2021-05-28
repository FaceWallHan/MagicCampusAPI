package com.hss.campus.controller.repair.device;

import com.hss.campus.controller.BaseServlet;
import com.hss.campus.controller.repair.schedule.BaseRecordServlet;
import com.hss.campus.entity.Device;
import com.hss.campus.service.DeviceService;
import com.hss.campus.service.impl.DeviceServiceImpl;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/removeDevice")
public class DeleteDeviceServlet extends BaseRecordServlet {


    @Override
    public Response operatePost(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Response<Object> response = new Response<>();
        if (deviceService.deleteById(id)){
            response.setStatus(ResultCode.SUCCESS.status());
            response.setCode(ResultCode.SUCCESS.code());
        }else {
            response.setStatus(ResultCode.USER_PARAMETER_ERROR.status());
            response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
        }
        return response;
    }
}
