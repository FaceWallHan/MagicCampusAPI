package com.hss.campus.service.impl;

import com.hss.campus.dao.RepairProjectDao;
import com.hss.campus.dao.impl.RepairProjectDaoImpl;
import com.hss.campus.entity.RepairProject;
import com.hss.campus.service.RepairProjectService;

import java.util.List;

public class RepairProjectServiceImpl implements RepairProjectService {
    private RepairProjectDao dao=new RepairProjectDaoImpl();
    @Override
    public List<RepairProject> query() {
        return dao.query();
    }
}
