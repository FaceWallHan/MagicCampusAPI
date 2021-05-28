package com.hss.campus.controller.repair.form;


import com.google.gson.Gson;
import com.hss.campus.controller.repair.schedule.BaseRecordServlet;
import com.hss.campus.entity.Repair;
import com.hss.campus.entity.RepairArea;
import com.hss.campus.entity.RepairNum;
import com.hss.campus.service.RepairAreaService;
import com.hss.campus.service.RepairService;
import com.hss.campus.service.impl.RepairAreaServiceImpl;
import com.hss.campus.service.impl.RepairServiceImpl;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//根据区域获取订单记录
@WebServlet(urlPatterns = "/getRepairNumListByArea")
public class QueryRepairNumByAreaServlet extends HttpServlet {
    private RepairAreaService areaService=new RepairAreaServiceImpl();
    private RepairService repairService=new RepairServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        List<String>area=new ArrayList<>();
        Response<List<RepairNum>> response=new Response<>();
        List<RepairNum> repairNums = new ArrayList<>();
        List<RepairArea> query = areaService.query();
        for (RepairArea repairArea : query) {
            area.add(repairArea.getSmallArea());
        }
        List<String> collectArea = area.stream().distinct().collect(Collectors.toList());
        for (String str : collectArea) {
            repairNums.add(new RepairNum(repairService.getRepairNum(str),repairService.getRepairOtherNum(str),str));
        }
        response.setData(repairNums);
        response.setStatus(ResultCode.SUCCESS.status());
        response.setCode(ResultCode.SUCCESS.code());
        resp.getWriter().write(new Gson().toJson(response));
    }
}
