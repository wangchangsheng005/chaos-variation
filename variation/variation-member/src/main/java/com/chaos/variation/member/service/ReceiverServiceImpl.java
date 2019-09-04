package com.chaos.variation.member.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ClassName:ReceiverServiceImpl
 * @Description:TODO
 * @Author:SH-WANGCS2
 * @Date:2019/9/1/0001 21:33
 * @Version 1.0
 **/
@Slf4j
@Service
@Component
@RabbitListener(queues = "testQueue")
public class ReceiverServiceImpl {

    @RabbitHandler
    public void receiverMassage(Object object){
        log.info("消费者消费================：{}",object);
    }

}
