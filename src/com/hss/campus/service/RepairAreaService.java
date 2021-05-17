package com.hss.campus.service;

import com.hss.campus.entity.RepairArea;

import java.util.List;

//报修区域
public interface RepairAreaService {
    //查找区域
    List<RepairArea> query();
}
