package com.hss.campus.dao.impl;

import com.hss.campus.dao.BaseDao;
import com.hss.campus.dao.DeviceDao;
import com.hss.campus.entity.Device;

import java.util.List;

public class DeviceDaoImpl  extends BaseDao implements DeviceDao {
    @Override
    public int insert(Device device) {
        String sql="INSERT INTO `smartcampus`.`repair_device` (`area`, `project`, `worker`, `address`,code_url) VALUES (?,?, ?, ?,?)";
        return update(sql, device.getArea(),device.getProject(),device.getWorker(),device.getAddress(),device.getCodeUrl());
    }

    @Override
    public int deleteById(Integer id) {
        String sql="delete from repair_device where id=?";
        return update(sql,id);
    }

    @Override
    public int update(Device device) {
        String sql="UPDATE `smartcampus`.`repair_device` SET `area`=?, `project`=?, `worker`=?, `address`=? ,code_url=? WHERE (`id`=?)";
        return update(sql, device.getArea(),device.getProject(),device.getWorker(),device.getAddress(),device.getCodeUrl(),device.getDeviceId());
    }

    @Override
    public List<Device> queryAll() {
        String sql="select id deviceId,area, project,address,worker,code_url codeUrl from repair_device";
        return queryForList(Device.class, sql );
    }
}
