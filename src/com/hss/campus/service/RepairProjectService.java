package com.hss.campus.service;

import com.hss.campus.entity.RepairProject;

import java.util.List;

//报修项目
public interface RepairProjectService {
    //查找项目
    List<RepairProject> query();
}
