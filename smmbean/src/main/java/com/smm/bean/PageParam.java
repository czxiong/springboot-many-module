package com.smm.bean;

import lombok.Data;
@Data
public class PageParam {

    private Integer pageNo;

    private Integer pageSize;

    private String OrderType;

    private String orderValue;

}
