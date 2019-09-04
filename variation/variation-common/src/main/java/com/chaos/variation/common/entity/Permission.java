package com.chaos.variation.common.entity;

import lombok.Data;

import java.util.Date;

/**
 * 〈权限实体〉
 *
 * @Description:TODO
 * @Author:Mr.Wang
 * @Date:2019/9/04/0027 15:34
 * @Version 1.0
 **/
@Data
public class Permission {

    private int id;
    private String zuulPrefix;
    private String servicePrefix;
    private String method;
    private String uri;
    private Date createTime;
    private Date updateTime;
}
