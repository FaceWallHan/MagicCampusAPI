package com.hss.campus.service;

import com.hss.campus.entity.Repair;
import com.hss.campus.entity.RepairWorker;

import java.util.List;

public interface RepairService {
    //报修上传
    int insert(Repair repair);
    //显示报修
    Repair query(Integer id);
    //报修列表
    List<Repair> queryList();
    //查看报修
    List<Repair> queryByStuId(Integer id);
    List<Repair> queryByStuSchedule(Integer id,String schedule);
    List<Repair> queryByAdminSchedule(String schedule);

    boolean updateStatus(Integer id,String status);

    boolean appraiseRepair(Integer repairId,String appraise ,String description);
    boolean insertWorker(String name,Integer repairId);

    RepairWorker queryWorker(Integer repairId);
    Long queryRepairNum(String day);
    List<Repair> queryRepairListByArea(String area);
    Long queryBeforeWeek(String day);
    List<Repair> getRepairListByToday();

    String getUnitNameByRepairId(Integer repairId);
    boolean insertByCode(Repair repair);


    Long getRepairNum(String area);
    Long getRepairOtherNum(String area);
}
