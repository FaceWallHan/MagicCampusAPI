package com.hss.campus.service;

import com.hss.campus.entity.Unit;

import java.util.List;

public interface UnitService {
    int insert(Unit unit);
    List<Unit> getAllUnit();
    Integer queryUnitFinishNum(String unit);
    boolean UpdateFinished(String unit);
}
