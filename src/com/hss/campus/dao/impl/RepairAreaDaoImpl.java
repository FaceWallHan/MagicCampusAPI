package com.hss.campus.dao.impl;

import com.hss.campus.dao.BaseDao;
import com.hss.campus.dao.RepairAreaDao;
import com.hss.campus.entity.RepairArea;

import java.util.List;

//报修区域
public class RepairAreaDaoImpl extends BaseDao implements RepairAreaDao {
    //查找区域
    @Override
    public List<RepairArea> query() {
        String sql="select * from repairarea";
        return queryForList(RepairArea.class,sql);
    }
}
