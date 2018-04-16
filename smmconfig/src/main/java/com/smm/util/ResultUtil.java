package com.smm.util;

import com.smm.bean.R;
import com.smm.enums.ResultEnum;

/**
 * 封装返回信息的工具类
 */
public class ResultUtil {

    /**
     * 成功，data 有值得情况
     * @param o
     * @return
     */
    public static R ok(Object o){
        return new R(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),o);
    }

    /**
     * 成功 data 没有值得情况
     * @return
     */
    public static R ok(){
        return ok(null);
    }

    /**
     * 失败
     * @param code
     * @param msg
     * @return
     */
    public static R error(Integer code,String msg){
        return new R(code,msg);
    }

}
