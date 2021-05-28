package com.hss.campus.entity;

public class Device {
    private Integer deviceId;
    private String area;
    private String project;
    private String address;
    private String worker;

    private String codeUrl;
    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public boolean isNull(){
        return "".equals(area)||"".equals(project)||"".equals(address)||"".equals(worker);
    }
    public Device() {
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Device(Integer deviceId, String area, String project, String address, String worker) {
        this.deviceId = deviceId;
        this.area = area;
        this.project = project;
        this.address = address;
        this.worker = worker;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", area='" + area + '\'' +
                ", project='" + project + '\'' +
                ", address='" + address + '\'' +
                ", worker='" + worker + '\'' +
                ", codeUrl='" + codeUrl + '\'' +
                '}';
    }
}
