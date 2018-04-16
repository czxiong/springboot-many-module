package com.smm.enums;

public enum ResultEnum {

    UNKOUW_ERROR(-1,"未知错误"),
    SUCCESS(0,"操作成功"),
    NOT_FOUND_DATA(1,"暂无数据");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
