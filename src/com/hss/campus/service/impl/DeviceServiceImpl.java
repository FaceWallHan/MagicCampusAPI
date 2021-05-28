package com.hss.campus.service.impl;

import com.hss.campus.dao.DeviceDao;
import com.hss.campus.dao.impl.DeviceDaoImpl;
import com.hss.campus.entity.Device;
import com.hss.campus.service.DeviceService;

import java.util.List;

public class DeviceServiceImpl implements DeviceService {
    private DeviceDao dao=new DeviceDaoImpl();
    @Override
    public boolean insert(Device device) {
        return dao.insert(device)!=-1;
    }

    @Override
    public boolean deleteById(Integer id) {
        return dao.deleteById(id)!=-1;
    }

    @Override
    public boolean update(Device device) {
        return dao.update(device)!=-1;
    }

    @Override
    public List<Device> queryAll() {
        return dao.queryAll();
    }
}
