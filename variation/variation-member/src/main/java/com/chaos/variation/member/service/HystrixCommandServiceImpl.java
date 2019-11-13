package com.chaos.variation.member.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:HystrixCommandServiceImpl
 * @Description:TODO
 * @Author:SH-WANGCS2
 * @Date:2019/10/27/0027 12:12
 * @Version 1.0
 **/
@Slf4j
@Service
public class HystrixCommandServiceImpl implements HystrixCommandService{

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "defaulFallback")
    @Override
    public Principal HystrixService(Principal member) {
        List a = new ArrayList();
        //String result = restTemplate.getForObject("http://variation-auth/api/member",member);

        return null;
    }

    public Principal defaulFallback(Principal member){
        log.info("断路由开启：{}",member);
        return member;
    }
}
