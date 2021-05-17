package com.hss.campus.service;

import com.hss.campus.entity.RepairRecord;

import java.util.List;

public interface RepairRecordService {
    boolean insertRecord(String name,String status,Integer repairId,String phone);
    List<RepairRecord> querySimpleRecord(String repairId);
}
