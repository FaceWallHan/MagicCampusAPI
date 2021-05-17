package com.hss.campus.controller.repair.worker;

import com.google.gson.Gson;
import com.hss.campus.controller.BaseServlet;
import com.hss.campus.entity.RepairWorker;
import com.hss.campus.service.RepairWorkerService;
import com.hss.campus.service.impl.RepairWorkerServiceImpl;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//查询全部维修工
@WebServlet(urlPatterns = "/queryTypeWorker")
public class QueryTypeWorkerServlet extends HttpServlet {
    private RepairWorkerService workerService=new RepairWorkerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        Response<List<RepairWorker>> response = new Response<>();
        String type = req.getParameter("type");
        List<RepairWorker> workerList = workerService.queryTypeWorker(type);
        if (workerList !=null) {
            response.setCode(ResultCode.SUCCESS.code());
            response.setStatus(ResultCode.SUCCESS.status());
            response.setData(workerList);
        } else {
            response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
            response.setStatus(ResultCode.USER_PARAMETER_ERROR.status());
        }
        resp.getWriter().write(new Gson().toJson(response));
    }
}
