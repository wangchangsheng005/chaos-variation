package com.chaos.variation.member.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName:ProductionController
 * @Description:TODO
 * @Author:SH-WANGCS2
 * @Date:2019/7/29/0029 11:16
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/production")
public class ProductionController{

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/send")
    public void sender(){
        String sendMassage = "生产者生产一条消息："+ new Date();
        log.info("==========================:{}",sendMassage);
        this.amqpTemplate.convertAndSend("testQueue",sendMassage);
    }


}
