package com.hss.campus.service.impl;

import com.hss.campus.dao.BaseDao;
import com.hss.campus.dao.UnitDao;
import com.hss.campus.dao.impl.UnitDaoImpl;
import com.hss.campus.entity.Unit;
import com.hss.campus.service.UnitService;

import java.util.List;

public class UnitServiceImpl implements UnitService {
    private UnitDao dao=new UnitDaoImpl();
    @Override
    public int insert(Unit unit) {
        return 0;
    }

    @Override
    public List<Unit> getAllUnit() {
        return dao.getAllUnit();
    }

    @Override
    public Integer queryUnitFinishNum(String unit) {
        return dao.queryUnitFinishNum(unit);
    }

    @Override
    public boolean UpdateFinished(String unit) {
        return dao.queryUnitFinishNum(unit)!=-1;
    }
}
