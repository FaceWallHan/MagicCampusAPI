package com.hss.campus.util;

public class Response<T> {
    private Integer code;
    private String status;
    private T data;

    public Response() {
    }

    public Response(Integer code, String status, T data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
