package com.hss.campus.entity;

public class ImageResponse {
    private String fileName;

    public ImageResponse() {
    }

    public ImageResponse(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "ImageResponse{" +
                "fileName='" + fileName + '\'' +
                '}';
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
