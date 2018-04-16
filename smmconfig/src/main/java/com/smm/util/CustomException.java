package com.smm.util;

import com.smm.enums.ResultEnum;

/**
 * 自定义异常工具类
 * 这里继承RuntimeException，因为它的父类是Exception，spring框架只会对RuntimeException抛出的异常进行事务回滚
 */
public class CustomException extends RuntimeException {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public CustomException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
