package com.hss.campus.entity;

public class RepairNum {
    private Long pendNum;
    private Long processNum;
    private String repairArea;

    public RepairNum() {
    }

    public Long getPendNum() {
        return pendNum;
    }

    public void setPendNum(Long pendNum) {
        this.pendNum = pendNum;
    }

    public Long getProcessNum() {
        return processNum;
    }

    public void setProcessNum(Long processNum) {
        this.processNum = processNum;
    }

    public String getRepairArea() {
        return repairArea;
    }

    public void setRepairArea(String repairArea) {
        this.repairArea = repairArea;
    }

    public RepairNum(Long pendNum, Long processNum, String repairArea) {
        this.pendNum = pendNum;
        this.processNum = processNum;
        this.repairArea = repairArea;
    }

    @Override
    public String toString() {
        return "RepairNum{" +
                "pendNum=" + pendNum +
                ", processNum=" + processNum +
                ", repairArea='" + repairArea + '\'' +
                '}';
    }
}
