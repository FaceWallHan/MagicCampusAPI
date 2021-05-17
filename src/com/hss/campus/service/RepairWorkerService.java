package com.hss.campus.service;

import com.hss.campus.entity.RepairWorker;

import java.util.List;

public interface RepairWorkerService {
    int insert(RepairWorker worker);
    int delete(Integer id);
    int update(RepairWorker worker);
    List<RepairWorker> queryAll();
    RepairWorker queryOne(String name,String phone,String status);
    boolean updateWorkerStatus(String status,String name,String phone);
    List<RepairWorker> queryTypeWorker(String type);
}
