package com.hss.campus.entity;

public class ImageHeader {
    private Integer id;
    private String fileName;

    public ImageHeader() {
    }

    public ImageHeader(Integer id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "ImageHeader{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                '}';
    }

    public boolean isRealNull(){

        return id==null || fileName.equals("");
    }
}
