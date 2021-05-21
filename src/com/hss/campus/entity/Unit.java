package com.hss.campus.entity;

public class Unit {
    private Integer id;
    private Integer finishedNum;
    private String name;

    public Unit() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFinishedNum() {
        return finishedNum;
    }

    public void setFinishedNum(Integer finishedNum) {
        this.finishedNum = finishedNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit(Integer id, Integer finishedNum, String name) {
        this.id = id;
        this.finishedNum = finishedNum;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", finishedNum=" + finishedNum +
                ", name='" + name + '\'' +
                '}';
    }
}
