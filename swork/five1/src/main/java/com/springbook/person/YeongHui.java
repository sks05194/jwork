package com.springbook.person;

import org.springframework.stereotype.Component;

@Component("yeongHui")
public class YeongHui implements People {
	@Override
	public void getHome() {
		System.out.println("영희가 집에 들어오는 과정");
		System.out.println("지문인식을 한다.");
	}
}