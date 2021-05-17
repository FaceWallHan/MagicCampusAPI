package com.hss.campus.controller.repair.worker;

import com.google.gson.Gson;
import com.hss.campus.controller.BaseServlet;
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

//删除维修工
@WebServlet(urlPatterns = "/deleteWorker")
public class DeleteWorkerServlet extends HttpServlet {
    private RepairWorkerService service = new RepairWorkerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        Response<Integer> response = new Response<>();
        Integer id = Integer.parseInt(req.getParameter("id"));
        if (service.delete(id) != -1) {
            response.setCode(ResultCode.SUCCESS.code());
            response.setStatus(ResultCode.SUCCESS.status());
        } else {
            response.setCode(ResultCode.USER_PARAMETER_ERROR.code());
            response.setStatus(ResultCode.USER_PARAMETER_ERROR.status());
        }
        resp.getWriter().write(new Gson().toJson(response));
    }

}
