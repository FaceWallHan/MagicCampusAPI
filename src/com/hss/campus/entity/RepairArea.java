package com.hss.campus.entity;

//报修区域
public class RepairArea {
    private Integer id;
    private String smallArea;
    private String bigArea;

    public RepairArea() {
    }

    public RepairArea(Integer id, String smallArea, String bigArea) {
        this.id = id;
        this.smallArea = smallArea;
        this.bigArea = bigArea;
    }

    @Override
    public String toString() {
        return "RepairArea{" +
                "id=" + id +
                ", smallArea='" + smallArea + '\'' +
                ", bigArea='" + bigArea + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSmallArea() {
        return smallArea;
    }

    public void setSmallArea(String smallArea) {
        this.smallArea = smallArea;
    }

    public String getBigArea() {
        return bigArea;
    }

    public void setBigArea(String bigArea) {
        this.bigArea = bigArea;
    }
}
