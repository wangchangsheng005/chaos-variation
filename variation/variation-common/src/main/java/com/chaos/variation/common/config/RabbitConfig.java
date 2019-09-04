package com.chaos.variation.common.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:RabbitConfig
 * @Description:TODO
 * @Author:Mr.Wang
 * @Date:2019/7/29/0029 16:53
 * @Version 1.0
 **/
@Configuration
public class RabbitConfig {

    @Bean
    public Queue testQueue(){
        return new Queue("testQueue",true);
    };

}
