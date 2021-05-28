package com.hss.campus.controller.repair.device;

import com.google.gson.Gson;
import com.hss.campus.controller.repair.schedule.BaseRecordServlet;
import com.hss.campus.entity.Device;
import com.hss.campus.service.DeviceService;
import com.hss.campus.service.impl.DeviceServiceImpl;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/queryAllDevice")
public class QueryAllDeviceServlet extends HttpServlet {
    private DeviceService deviceService=new DeviceServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        List<Device> list = deviceService.queryAll();
        Response<List<Device>> response = new Response<>();
        if (list!=null){
            response.setStatus(ResultCode.SUCCESS.status());
            response.setCode(ResultCode.SUCCESS.code());
            response.setData(list);
        }else {
            response.setStatus(ResultCode.USER_PARAMETER_ERROR.status());
            response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
        }
        resp.getWriter().write(new Gson().toJson(response));
    }
}
