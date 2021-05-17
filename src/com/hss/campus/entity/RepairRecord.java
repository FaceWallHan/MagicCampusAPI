package com.hss.campus.entity;

public class RepairRecord {
    public RepairRecord() {
    }

    private String  name,time,status,repairId,phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRepairId() {
        return repairId;
    }

    public void setRepairId(String repairId) {
        this.repairId = repairId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public RepairRecord(String name, String time, String status, String repairId, String phone) {
        this.name = name;
        this.time = time;
        this.status = status;
        this.repairId = repairId;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "RepairRecord{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", repairId='" + repairId + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
