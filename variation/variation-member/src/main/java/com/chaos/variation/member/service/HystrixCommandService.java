package com.chaos.variation.member.service;

import java.security.Principal;

/**
 * @ClassName:HystrixCommandService
 * @Description:TODO
 * @Author:SH-WANGCS2
 * @Date:2019/10/27/0027 12:12
 * @Version 1.0
 **/
public interface HystrixCommandService {

    Principal HystrixService(Principal member);
}
