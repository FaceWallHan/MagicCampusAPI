package com.hss.campus.dao;

import com.hss.campus.entity.Repair;
import com.hss.campus.entity.RepairWorker;

import java.util.List;

public interface RepairDao {
    //报修上传
    int insert(Repair repair);
    //显示报修
    Repair query(Integer id);
    //报修列表
    List<Repair> queryList();
    //查看报修
    List<Repair> queryByStuId(Integer id);

    int updateStatus(Integer id,String status);
    boolean appraiseRepair(Integer repairId,String appraise ,String description);
    List<Repair> queryByStuSchedule(Integer id,String schedule);
    List<Repair> queryByAdminSchedule(String schedule);

    int insertWorker(String name,Integer repairId);
    RepairWorker queryWorker(Integer repairId);
}
