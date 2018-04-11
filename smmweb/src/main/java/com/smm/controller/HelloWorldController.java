package com.smm.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    @ApiOperation("hello world")
    public String hello(){
        return "Hello Spring Boot Module";
    }

}
