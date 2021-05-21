package com.hss.campus.entity;

public class DayRepairNum {
    private String day;
    private Long num;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public DayRepairNum(String day, Long num) {
        this.day = day;
        this.num = num;
    }

    @Override
    public String toString() {
        return "DayRepairNum{" +
                "day='" + day + '\'' +
                ", num=" + num +
                '}';
    }
}
