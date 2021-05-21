package com.hss.campus.dao;

import com.hss.campus.entity.Unit;

import java.util.List;

public interface UnitDao {
    int insert(Unit unit);
    List<Unit> getAllUnit();
    Integer queryUnitFinishNum(String unit);
    int UpdateFinished(String unit);
}
