package com.chaos.variation.member.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName:base
 * @Description:TODO
 * @Author:SH-WANGCS2
 * @Date:2019/9/20/0020 19:02
 * @Version 1.0
 **/
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    public String sayHello(String info) {

        int i = 100;
        while(i > 0){
            try {
                Thread.sleep(1000);
                log.info("》》》》》》》》》》》》》》》》》》》》：{}",i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i --;
        }
        return "sayHello:"+info;
    }
}
