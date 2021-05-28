package com.hss.campus.dao.impl;

import com.hss.campus.dao.BaseDao;
import com.hss.campus.dao.RepairDao;
import com.hss.campus.entity.DayRepairNum;
import com.hss.campus.entity.Repair;
import com.hss.campus.entity.RepairWorker;
import com.hss.campus.util.OtherUtil;

import java.util.List;

public class RepairDaoImpl extends BaseDao implements RepairDao {

    //报修上传
    @Override
    public int insert(Repair repair) {
        if ("".equals(repair.getDate())){
            repair.setDate(OtherUtil.getOneDayByDistance(0));
        }
        String sql="INSERT INTO `smartcampus` .`repair` " +
                "(`s_id`,`repairArea`, `repairProject`, `phone`, `date`, `time`, `content`,image,schedule,address) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";
        return update(sql,repair.getS_id(),repair.getRepairArea(),repair.getRepairProject(),repair.getPhone(),
                repair.getDate(),repair.getTime(),repair.getContent(),repair.getImage(),repair.getSchedule(),repair.getAddress());
    }

    //显示报修
    @Override
    public Repair query(Integer id) {
        String sql="SELECT * from repair WHERE id=?";
        return queryForOne(Repair.class,sql,id);
    }

    //报修列表
    @Override
    public List<Repair> queryList() {
        String sql="select * from repair";
        return queryForList(Repair.class,sql);
    }

    //查看报修
    @Override
    public List<Repair> queryByStuId(Integer id) {
        String sql="SELECT * from `repair` where s_id=?";
        return queryForList(Repair.class,sql,id);
    }

    @Override
    public int updateStatus(Integer id, String status) {
        String sql="UPDATE `smartcampus`.`repair` SET `schedule`=? WHERE (`id`=?)";
        return update(sql, status,id);
    }

    @Override
    public boolean appraiseRepair(Integer repairId, String appraise,String description) {
        String sql="UPDATE `smartcampus`.`repair` SET `schedule`=?,`appraise`=?,`description`=? WHERE (`id`=?)";
        return update(sql, OtherUtil.REPAIR_STATUS[4],appraise,description,repairId)!=-1;
    }

    @Override
    public List<Repair> queryByStuSchedule(Integer id, String schedule) {
        String sql="SELECT * from `repair` where s_id=? and schedule=?";
        return queryForList(Repair.class,sql,id,schedule);
    }

    @Override
    public List<Repair> queryByAdminSchedule(String schedule) {
        String sql="SELECT * from `repair` where schedule=?";
        return queryForList(Repair.class,sql,schedule);
    }

    @Override
    public int insertWorker(String name,Integer repairId) {
        //UPDATE `smartcampus`.`repair` SET `worker`='韩龙根'WHERE (`id`='9');
        String sql="UPDATE `smartcampus`.`repair` SET `worker`=? WHERE (`id`=?);" ;
        return update(sql,name,repairId);
    }

    @Override
    public RepairWorker queryWorker(Integer repairId) {
        String sql="select * from repairworker WHERE `name`=(select worker from `repair` WHERE id=?)";
        return queryForOne(RepairWorker.class, sql, repairId);
    }

    @Override
    public Long queryRepairNum(String day){
        Long num;
        String sql;
        if ("".equals(day)){
            String time=OtherUtil.getNowTime("yyyy-MM-dd");
            sql="select count(*) from repair where date=?";
            num=(Long) queryForSimpleValue(sql, time);
        }else {
            sql="select count(*) from repair";
            num=(Long) queryForSimpleValue(sql);
        }
        return num;
    }

    @Override
    public List<Repair> queryRepairListByArea(String area) {
        String sql ="select * from repair where repairarea =? order by date desc";
        return queryForList(Repair.class, sql, area);
    }

    @Override
    public Long queryBeforeWeek(String day) {
        String sql="select count(*) from repair where date=?";
        return (Long) queryForSimpleValue(sql, day);
    }

    @Override
    public List<Repair> getRepairListByToday() {
        String day = OtherUtil.getOneDayByDistance(0);
        String sql="select * from repair where date= ?";
        return queryForList(Repair.class, sql, day);
    }

    @Override
    public String getUnitNameByRepairId(Integer repairId) {
        String sql="select name from repair_uint where unit_id=" +
                "(select unit from repairworker where name=" +
                "(select worker FROM `repair` WHERE id=?))";
        return (String) queryForSimpleValue(sql, repairId);
    }

    @Override
    public Long getRepairNum(String area) {
        String sql="select count(*) from repair where repairarea=? and `schedule` in (?)";
        return (Long) queryForSimpleValue(sql,area, OtherUtil.REPAIR_STATUS[0]);
    }

    @Override
    public Long getRepairOtherNum(String area) {
        String sql="select count(*) from repair where repairarea=? and `schedule` in (?,?,?)";
        return (Long) queryForSimpleValue(sql, area, OtherUtil.REPAIR_STATUS[1], OtherUtil.REPAIR_STATUS[2], OtherUtil.REPAIR_STATUS[5]);
    }

    @Override
    public int insertByCode(Repair repair) {
        if ("".equals(repair.getDate())) {
            repair.setDate(OtherUtil.getOneDayByDistance(0));
        }
            String sql = "INSERT INTO `smartcampus` .`repair` " +
                    "(`s_id`,`repairArea`, `repairProject`, `phone`, `date`, `time`, `content`,image,schedule,address,worker,device_id) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            return update(sql, repair.getS_id(), repair.getRepairArea(), repair.getRepairProject(), repair.getPhone(),
                    repair.getDate(), repair.getTime(), repair.getContent(), repair.getImage(), repair.getSchedule(), repair.getAddress()
                    , repair.getWorker(), repair.getDeviceId());

    }

}
