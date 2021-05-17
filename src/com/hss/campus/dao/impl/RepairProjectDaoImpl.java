package com.hss.campus.dao.impl;

import com.hss.campus.dao.BaseDao;
import com.hss.campus.dao.RepairProjectDao;
import com.hss.campus.entity.RepairProject;

import java.util.List;

//报修项目
public class RepairProjectDaoImpl extends BaseDao implements RepairProjectDao {
    //查找项目
    @Override
    public List<RepairProject> query() {
        String sql="select * from repairproject";
        return queryForList(RepairProject.class,sql);
    }
}
