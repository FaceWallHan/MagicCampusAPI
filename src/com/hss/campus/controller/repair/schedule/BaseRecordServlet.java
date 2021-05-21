package com.hss.campus.controller.repair.schedule;

import com.google.gson.Gson;
import com.hss.campus.service.*;
import com.hss.campus.service.impl.*;
import com.hss.campus.util.Response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public  abstract class BaseRecordServlet extends HttpServlet {
    public UnitService unitService=new UnitServiceImpl();
    public RepairService repairService = new RepairServiceImpl();
    public RepairRecordService recordService=new RepairRecordServiceImpl();
    public RepairWorkerService workerService=new RepairWorkerServiceImpl();
    private final AdministratorService administratorService=new AdministratorServiceImpl();
    private final StudentService studentService=new StudentServiceImpl();
    public boolean existAdministrator(Integer id,String name){
        return administratorService.existAdministrator(id, name)!=null;
    }
    public boolean existWorker(String phone,String name,String status){
        return workerService.queryOne(name, phone,status)!=null;
    }
    public boolean existStudent(String name,Integer id){
        return studentService.queryOne(id, name)!=null;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(new Gson().toJson(operatePost(req, resp)));
    }

    public abstract Response operatePost(HttpServletRequest req, HttpServletResponse resp);
}
