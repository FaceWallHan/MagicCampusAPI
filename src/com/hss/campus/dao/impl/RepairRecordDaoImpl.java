package com.hss.campus.dao.impl;

import com.hss.campus.dao.BaseDao;
import com.hss.campus.dao.RepairRecordDao;
import com.hss.campus.entity.RepairRecord;
import com.hss.campus.util.OtherUtil;

import java.util.List;

public class RepairRecordDaoImpl extends BaseDao implements RepairRecordDao {
    @Override
    public boolean insertRecord(String name, String status, Integer repairId,String phone) {
        String time= OtherUtil.getNowTime("yyyy-MM-dd HH:mm:ss");
        String sql="INSERT INTO `smartcampus`.`repairrecord` ( `name`, `time`, `status`, `repair_id`,`phone`) VALUES ( ?, ?, ?, ?,?)";
        return update(sql, name,time,status,repairId,phone)!=-1;
    }

    @Override
    public List<RepairRecord> querySimpleRecord(String repairId) {
        String sql="select `name`, `time`, `status`, `repair_id` as repairId,`phone` from repairrecord where repair_id=?";
        return queryForList(RepairRecord.class, sql, repairId);
    }
}
