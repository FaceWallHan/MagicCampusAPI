package com.hss.campus.service.impl;

import com.hss.campus.dao.RepairDao;
import com.hss.campus.dao.impl.RepairDaoImpl;
import com.hss.campus.entity.Repair;
import com.hss.campus.entity.RepairWorker;
import com.hss.campus.service.RepairService;

import java.util.List;

public class RepairServiceImpl implements RepairService {
    private RepairDao dao=new RepairDaoImpl();

    //报修上传
    @Override
    public int insert(Repair repair) {
        return dao.insert(repair);
    }

    //显示报修
    @Override
    public Repair query(Integer id) {
        return dao.query(id);
    }

    //保修列表
    @Override
    public List<Repair> queryList() {
        return dao.queryList();
    }

    @Override
    public List<Repair> queryByStuId(Integer id) {
        return dao.queryByStuId(id);
    }

    @Override
    public List<Repair> queryByStuSchedule(Integer id, String schedule) {
        return dao.queryByStuSchedule(id, schedule);
    }

    @Override
    public List<Repair> queryByAdminSchedule(String schedule) {
        return dao.queryByAdminSchedule(schedule);
    }

    @Override
    public boolean updateStatus(Integer id, String status) {
        return dao.updateStatus(id, status)!=-1;
    }


    @Override
    public boolean appraiseRepair(Integer repairId, String appraise,String description) {
        return dao.appraiseRepair(repairId, appraise,description);
    }

    @Override
    public boolean insertWorker(String name,Integer repairId) {
        return dao.insertWorker(name,repairId)!=-1;
    }

    @Override
    public RepairWorker queryWorker(Integer repairId) {
        return dao.queryWorker(repairId);
    }

    @Override
    public  Long queryRepairNum(String day) {
        return dao.queryRepairNum(day);
    }

    @Override
    public List<Repair> queryRepairListByArea(String area) {
        return dao.queryRepairListByArea(area);
    }

    @Override
    public Long queryBeforeWeek(String day) {
        return dao.queryBeforeWeek(day);
    }

    @Override
    public List<Repair> getRepairListByToday() {
        return dao.getRepairListByToday();
    }

    @Override
    public String getUnitNameByRepairId(Integer repairId) {
        return dao.getUnitNameByRepairId(repairId);
    }

}
