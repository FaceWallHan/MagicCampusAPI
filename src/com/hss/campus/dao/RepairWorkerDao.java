package com.hss.campus.dao;

import com.hss.campus.entity.RepairWorker;

import java.util.List;

public interface RepairWorkerDao {
    int insert(RepairWorker worker);
    int delete(Integer id);
    int update(RepairWorker worker);
    List<RepairWorker> queryAll();
    List<RepairWorker> queryTypeWorker(String type);
    RepairWorker queryOne(String name,String phone,String status);
    int updateWorkerStatus(String status,String name,String phone);
}
