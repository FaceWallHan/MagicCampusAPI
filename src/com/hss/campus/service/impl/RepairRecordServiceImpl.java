package com.hss.campus.service.impl;

import com.hss.campus.dao.RepairRecordDao;
import com.hss.campus.dao.impl.RepairRecordDaoImpl;
import com.hss.campus.entity.RepairRecord;
import com.hss.campus.service.RepairRecordService;

import java.util.List;

public class RepairRecordServiceImpl implements RepairRecordService {
    private RepairRecordDao dao=new RepairRecordDaoImpl();
    @Override
    public boolean insertRecord(String name, String status, Integer repairId,String phone) {
        return dao.insertRecord(name, status, repairId,phone);
    }

    @Override
    public List<RepairRecord> querySimpleRecord(String repairId) {
        return dao.querySimpleRecord(repairId);
    }
}
