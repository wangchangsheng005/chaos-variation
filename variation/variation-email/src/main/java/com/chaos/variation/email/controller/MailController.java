package com.chaos.variation.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:MailController
 * @Description:TODO
 * @Author:SH-WANGCS2
 * @Date:2019/9/5/0005 15:41
 * @Version 1.0
 **/
@RestController
public class MailController {
    @Autowired
    private JavaMailSender sender;
    @GetMapping("/send")
    public String send(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("2669737139@qq.com");
        message.setTo("1577873508@qq.com");
        message.setSubject("这是一份测试邮件");
        message.setText("请点击注册");
        sender.send(message);
        return "1";
    }
}
