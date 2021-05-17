package com.hss.campus.dao.impl;

import com.hss.campus.dao.BaseDao;
import com.hss.campus.dao.RepairWorkerDao;
import com.hss.campus.entity.RepairWorker;
import com.hss.campus.util.OtherUtil;

import java.util.List;

public class RepairWorkerDaoImpl extends BaseDao implements RepairWorkerDao {
    @Override
    public int insert(RepairWorker worker) {
        String sql="INSERT INTO repairworker (`name`, `phone`, `email`, `unit`, `status`) VALUES (?, ?, ?, ?, ?)";
        return update(sql, worker.getName(),worker.getPhone(),worker.getEmail(),worker.getTypeWork(), OtherUtil.REPAIR_WORKER_STATUS[1].trim());
    }

    @Override
    public int delete(Integer id) {
        String sql="delete from repairworker where id=?";
        return update(sql, id);
    }

    @Override
    public int update(RepairWorker worker) {
//        UPDATE `smartcampus`.`repairworker` SET `id`='6', `name`='魏博文', `phone`='13963560200', `email`='142814000@qq.com', `unit`='木工', `status`=' 等待中' WHERE (`id`='6');

        String sql="UPDATE `smartcampus`.`repairworker` SET `name`=?, `phone`=?, `email`=?, `unit`=?, `status`=?  WHERE `id`=?";
        return update(sql,  worker.getName(),worker.getPhone(),worker.getEmail(),worker.getTypeWork(), worker.getStatus(),worker.getId());
    }

    @Override
    public List<RepairWorker> queryAll() {
        String sql="SELECT id,name,phone,email,unit typeWork,status FROM repairworker";
        return queryForList(RepairWorker.class, sql);
    }

    @Override
    public List<RepairWorker> queryTypeWorker(String type) {
        String sql="SELECT id,name,phone,email,unit typeWork,status FROM repairworker where unit=?";
        return queryForList(RepairWorker.class, sql, type);
    }

    @Override
    public RepairWorker queryOne(String name, String phone,String status) {
        String sql="SELECT id,name,phone,email,unit typeWork,status FROM repairworker where name=? and phone=? and status=?";
        return queryForOne(RepairWorker.class, sql, name,phone,status);
    }


    @Override
    public int updateWorkerStatus(String status,String name,String phone) {
        String sql="UPDATE `smartcampus`.`repairworker` SET `status`=?  WHERE name=? and phone=?";
        return update(sql, status,name,phone);
    }
}
