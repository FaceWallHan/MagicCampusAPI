package com.hss.campus.entity;

public class RepairWorker {
    private Integer id;
    private String name,phone,email,unit,status;
    public boolean isNull(){
        return id==0||"".equals(name)||"".equals(phone)||"".equals(email)||"".equals(unit)||"".equals(status);
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public RepairWorker() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeWork() {
        return unit;
    }

    public void setTypeWork(String typeWork) {
        this.unit = typeWork;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RepairWorker(Integer id, String name, String phone, String email, String typeWork, String status) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.unit = typeWork;
        this.status = status;
    }

    @Override
    public String toString() {
        return "RepairWorker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", typeWork='" + unit + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
