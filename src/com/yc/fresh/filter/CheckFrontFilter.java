package com.yc.fresh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 拦截所有请求
@WebFilter(filterName = "CheckFrontFilter", value = "/front/*")
public class CheckFrontFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		// 获取用户请求的路径
		String path = request.getRequestURI(); // /DayFresh/front/cart.html

		// 获取请求的项目名
		String base = request.getContextPath(); // /DayFresh
		
		path = path.replace(base, "");
		
		request.getRequestDispatcher("../WEB-INF" + path).forward(request, response);
		return;
	}
}
