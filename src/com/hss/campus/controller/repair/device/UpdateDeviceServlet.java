package com.hss.campus.controller.repair.device;

import com.hss.campus.controller.BaseServlet;
import com.hss.campus.entity.Device;
import com.hss.campus.service.DeviceService;
import com.hss.campus.service.impl.DeviceServiceImpl;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(urlPatterns = "/updateDevice")
public class UpdateDeviceServlet extends BaseServlet {
    private DeviceService service=new DeviceServiceImpl();
    @Override
    public Response operatingGet(HttpServletRequest request) {
        Device entity = getEntity(Device.class);
        Response<Integer>response=new Response<>();
        if (!entity.isNull()){
            if (service.update(entity)){
                response.setStatus(ResultCode.SUCCESS.status());
                response.setCode(ResultCode.SUCCESS.code());
            }else {
                response.setStatus(ResultCode.USER_PARAMETER_ERROR.status());
                response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
            }
        }else {
           response.setStatus(ResultCode.USER_PARAMETER_ERROR.status());
           response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
        }
        return response;
    }

    @Override
    public boolean isGet() {
        return false;
    }
}
