package com.hss.campus.dao;

import com.hss.campus.entity.Device;

import java.util.List;

public interface DeviceDao {
    int insert(Device device);
    int deleteById(Integer id);
    int update(Device device);
    List<Device> queryAll();
}
