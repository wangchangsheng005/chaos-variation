package com.chaos.variation.server.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Description:TODO   开启认证
 * @Author:Mr.wang
 * @Date:2019/9/5/0005 14:02
 * @Version 1.0
 **/
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //为了可以使用 http://${user}:${password}@${host}:${port}/eureka/ 这种方式登录,所以必须是httpBasic
        http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
}
