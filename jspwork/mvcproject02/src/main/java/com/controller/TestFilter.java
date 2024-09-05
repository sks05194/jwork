package com.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/conservlet")
public class TestFilter implements Filter {
	public TestFilter() {
		System.out.println("필터 객체 생성");
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("필터 초기 메소드 실행");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter() 메소드 실행");
		chain.doFilter(request, response);
	}

	public void destroy() {

	}
}