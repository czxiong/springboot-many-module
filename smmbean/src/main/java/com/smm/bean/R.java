package com.smm.bean;

import lombok.Data;

/**
 * 封装返回的统一对象
 * @param <T>
 */
@Data
public class R<T> {

    private Integer code;//错误码

    private String msg;//提示信息

    private T data;//返回的具体内容

    public R(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public R(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

