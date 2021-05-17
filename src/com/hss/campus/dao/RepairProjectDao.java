package com.hss.campus.dao;

import com.hss.campus.entity.RepairProject;

import java.util.List;

//报修项目
public interface RepairProjectDao {
    //查找项目
    List<RepairProject> query();
}
