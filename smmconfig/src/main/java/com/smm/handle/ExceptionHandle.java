package com.smm.handle;

import com.smm.bean.R;
import com.smm.enums.ResultEnum;
import com.smm.util.CustomException;
import com.smm.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常捕获工具类
 */
@ControllerAdvice //该注解表示该类是异常处理类
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class) //指定捕获的具体是哪个异常类
    @ResponseBody //以json格式返回
    public R handle(Exception e){
        if(e instanceof CustomException){
            //判断是否为自定义异常类
            CustomException customException = (CustomException)e;
            return ResultUtil.error(customException.getCode(),customException.getMessage());
        }else{
            //系统默认的异常
            return ResultUtil.error(ResultEnum.UNKOUW_ERROR.getCode(),e.getMessage());
        }
    }

}
