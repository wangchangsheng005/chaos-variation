package com.chaos.variation.member.controller;

import com.chaos.variation.member.service.HystrixCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:HystrixController
 * @Description:TODO
 * @Author:SH-WANGCS2
 * @Date:2019/10/17/0017 18:23
 * @Version 1.0
 **/
@RestController
public class HystrixController {

    @Autowired
    HystrixCommandService hystrixCommandService;



}
