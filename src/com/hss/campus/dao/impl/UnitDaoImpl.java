package com.hss.campus.dao.impl;

import com.hss.campus.dao.BaseDao;
import com.hss.campus.dao.UnitDao;
import com.hss.campus.entity.Unit;

import java.util.List;

public class UnitDaoImpl extends BaseDao implements UnitDao {
    @Override
    public int insert(Unit unit) {
        return 0;
    }

    @Override
    public List<Unit> getAllUnit() {
        String sql="select unit_id id,name, finished_num finishedNum from repair_uint";
        return queryForList(Unit.class, sql);
    }

    @Override
    public Integer queryUnitFinishNum(String unit) {
        String sql="select finished_num from repair_uint where name=?";
        return (Integer) queryForSimpleValue(sql, unit);
    }

    @Override
    public int UpdateFinished(String unit) {
        String sql="UPDATE `smartcampus`.`repair_uint` SET finished_num=finished_num+1 WHERE (`name`=?)";
        return update(sql, unit);
    }

    @Override
    public Integer queryIdByName(String name) {
        String sql="select unit_id from repair_uint where name=?";
        return (Integer) queryForSimpleValue(sql, name);
    }
}
