package com.smm.controller;

import com.smm.enums.ResultEnum;
import com.smm.util.CustomException;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWorldController {

    @GetMapping("/hello")
    @ApiOperation("hello world")
    public String hello(){
        log.debug("记录debugger日志");
        log.info("访问了hello方法");
        log.error("记录error错误日志");
        return "Hello Spring Boot Module";
    }

}
