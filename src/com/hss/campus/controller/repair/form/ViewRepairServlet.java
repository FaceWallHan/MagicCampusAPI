package com.hss.campus.controller.repair.form;

import com.google.gson.Gson;
import com.hss.campus.entity.Repair;
import com.hss.campus.service.RepairService;
import com.hss.campus.service.impl.RepairServiceImpl;
import com.hss.campus.util.OtherUtil;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//学生查看报修
@WebServlet(urlPatterns = "/viewRepairStu")
public class ViewRepairServlet extends HttpServlet {
    private RepairService repairService=new RepairServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        Response<List<Repair>> response=new Response<>();
        String studentId = req.getParameter("s_id").trim();
        List<Repair> list=repairService.queryByStuId(Integer.valueOf(studentId));
        if (list != null){
            for (Repair repair : list) {
                if (!"".equals(repair.getImage())){
                    repair.setImage(OtherUtil.IP_ADDRESS + repair.getImage());
                }
            }
            response.setCode(ResultCode.SUCCESS.code());
            response.setStatus(ResultCode.SUCCESS.status());
            response.setData(list);
        }else {
            response.setCode(ResultCode.USER_LOGIN_ERROR.code());
            response.setStatus(ResultCode.USER_TEXT_ERROR.status());
        }
        resp.getWriter().write(new Gson().toJson(response));
    }
}
