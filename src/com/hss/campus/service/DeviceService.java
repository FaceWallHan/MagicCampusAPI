package com.hss.campus.service;

import com.hss.campus.entity.Device;

import java.util.List;

public interface DeviceService {
    boolean insert(Device device);
    boolean deleteById(Integer id);
    boolean update(Device device);
    List<Device> queryAll();
}
