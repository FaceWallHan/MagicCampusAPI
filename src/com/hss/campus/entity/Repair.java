package com.hss.campus.entity;

public class Repair {
    private Integer id;
    private Integer s_id;
    private String repairArea;
    private String repairProject;
    private String phone;
    private String date;
    private String time;
    private String content;
    private String image;
    private String schedule;
    private String address;
    private String appraise;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    private String worker;

    public String getAppraise() {
        return appraise;
    }

    public void setAppraise(String appraise) {
        this.appraise = appraise;
    }



    public Repair() {
    }

    public Repair(Integer id, Integer s_id, String repairArea, String repairProject, String phone, String date, String time, String content, String image, String schedule, String address, String appraise) {
        this.id = id;
        this.s_id = s_id;
        this.repairArea = repairArea;
        this.repairProject = repairProject;
        this.phone = phone;
        this.date = date;
        this.time = time;
        this.content = content;
        this.image = image;
        this.schedule = schedule;
        this.address = address;
        this.appraise = appraise;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getRepairArea() {
        return repairArea;
    }

    public void setRepairArea(String repairArea) {
        this.repairArea = repairArea;
    }

    public String getRepairProject() {
        return repairProject;
    }

    public void setRepairProject(String repairProject) {
        this.repairProject = repairProject;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", s_id=" + s_id +
                ", repairArea='" + repairArea + '\'' +
                ", repairProject='" + repairProject + '\'' +
                ", phone='" + phone + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", schedule='" + schedule + '\'' +
                '}';
    }
}
