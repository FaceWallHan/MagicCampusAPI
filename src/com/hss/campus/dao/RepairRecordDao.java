package com.hss.campus.dao;

import com.hss.campus.entity.RepairRecord;

import java.util.List;

public interface RepairRecordDao {
    boolean insertRecord(String name,String status,Integer repairId,String phone);
    List<RepairRecord> querySimpleRecord(String repairId);
}
