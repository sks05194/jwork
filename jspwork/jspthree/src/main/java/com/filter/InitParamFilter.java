package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter(
//		filterName = "Filter02", 
//		urlPatterns = { 
//				"/Filter02", 
//				"/18_01_filter02_process.jsp"
//		}, 
//		initParams = { 
//				@WebInitParam(name = "param1", value = "admin"), 
//				@WebInitParam(name = "param2", value = "1234")
//		})
public class InitParamFilter implements Filter {
	private FilterConfig filterConfig = null;
	
	/* FilterConfig fConfig:
	web.xml의 init-param 태그로 설정한 초기 파라미터를 받는 매개변수 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter02 초기화...");
		filterConfig = fConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Filter02 수행...");
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		String param1 = filterConfig.getInitParameter("param1");
		String param2 = filterConfig.getInitParameter("param2");
		
		String message;
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		if (id.equals(param1) && passwd.equals(param2)) message = "로그인 성공했습니다.";
		else message = "로그인 실패했습니다.";
		
		writer.println(message);
		chain.doFilter(request, response);
		
		System.out.println("Filter02 doFilter() 후처리 실행");
	}

	public void destroy() {
		System.out.println("Filter02 해제..");
		this.filterConfig = null;
	}
}