package com.hss.campus.dao;

import com.hss.campus.entity.RepairArea;

import java.util.List;

//报修区域
public interface RepairAreaDao {
    //查找区域
    List<RepairArea> query();
}
