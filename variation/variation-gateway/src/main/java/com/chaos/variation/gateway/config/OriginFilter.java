package com.chaos.variation.gateway.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理跨域问题
 *
 * @author Mr.wang
 * @date 2019/09/08
 *
 */
@Component
public class OriginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	// 处理跨域问题
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		// response.reset();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACES");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Origin,X-Requested-With,Content-Type,Accept,Authorization,token");
		response.setCharacterEncoding("utf-8");
		// 指定浏览器以什么码表解码服务器发送的数据
		response.setHeader("Content-Type", "text/json; charset=UTF-8");
//		HttpServletRequest request = (HttpServletRequest) req;
//		System.out.println(request.getRequestURL());
		chain.doFilter(req, res);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}