package com.hss.campus.service.impl;

import com.hss.campus.dao.RepairWorkerDao;
import com.hss.campus.dao.impl.RepairWorkerDaoImpl;
import com.hss.campus.entity.RepairWorker;
import com.hss.campus.service.RepairWorkerService;

import java.util.List;

public class RepairWorkerServiceImpl implements RepairWorkerService {
   private RepairWorkerDao dao=new RepairWorkerDaoImpl();

    @Override
    public int insert(RepairWorker worker) {
        return dao.insert(worker);
    }

    @Override
    public int delete(Integer id) {
        return dao.delete(id);
    }

    @Override
    public int update(RepairWorker worker) {
        return dao.update(worker);
    }

    @Override
    public List<RepairWorker> queryAll() {
        return dao.queryAll();
    }

    @Override
    public RepairWorker queryOne(String name, String phone,String status) {
        return dao.queryOne(name, phone,status);
    }


    @Override
    public boolean updateWorkerStatus(String status, String name, String phone) {
        return dao.updateWorkerStatus(status, name, phone)!=-1;
    }

    @Override
    public List<RepairWorker> queryTypeWorker(String type) {
        return dao.queryTypeWorker(type);
    }

}
