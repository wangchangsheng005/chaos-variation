package com.chaos.variation.member.config;

import org.apache.axis.transport.http.AxisServlet;

/**
 * @ClassName:WebServlet
 * @Description:TODO
 * @Author:SH-WANGCS2
 * @Date:2019/9/23/0023 14:45
 * @Version 1.0
 **/
@javax.servlet.annotation.WebServlet(
        urlPatterns =  "/services/*",
        loadOnStartup = 1,
        name = "AxisServlet"
)
public class WebServlet extends AxisServlet {
}
