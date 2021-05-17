package com.hss.campus.service.impl;

import com.hss.campus.dao.RepairAreaDao;
import com.hss.campus.dao.impl.RepairAreaDaoImpl;
import com.hss.campus.entity.RepairArea;
import com.hss.campus.service.RepairAreaService;

import java.util.List;

//报修区域
public class RepairAreaServiceImpl implements RepairAreaService {
    //查找区域
    private RepairAreaDao dao=new RepairAreaDaoImpl();
    @Override
    public List<RepairArea> query() {
        return dao.query();
    }
}
