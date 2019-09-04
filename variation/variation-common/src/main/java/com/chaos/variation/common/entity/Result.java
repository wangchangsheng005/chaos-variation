package com.chaos.variation.common.entity;

import lombok.Data;

/**
 * 〈响应实体〉
 *
 * @Description:TODO
 * @Author:Mr.Wang
 * @Date:2019/9/04/0027 15:34
 * @Version 1.0
 **/
@Data
public class Result {

    private int code;
    private String message;
    private Object data;

}
