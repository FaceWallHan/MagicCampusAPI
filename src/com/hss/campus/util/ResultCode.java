package com.hss.campus.util;

public enum ResultCode {
    SUCCESS(200,"SUCCESS"),
    DELETE(200,"删除成功"),
    USER_LOGIN_ERROR(202,"账号不存在或密码错误"),
    USER_AVATAR_ERROR(400,"上传头像失败"),
    USER_TEXT_ERROR(404,"上传文件失败"),
    USER_PARAMETER_ERROR(404,"参数错误");
    private final Integer code;
    private final String status;
    ResultCode(Integer code, String status) {
        this.code = code;
        this.status = status;
    }
    public Integer code(){
        return this.code;
    }
    public String status(){
        return this.status;
    }
}
