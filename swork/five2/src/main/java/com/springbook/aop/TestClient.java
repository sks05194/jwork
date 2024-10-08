package com.springbook.aop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestClient {
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("testContext.xml");
		TestImpl ts = (TestImpl) container.getBean("testService");

		System.out.println("getNum() 실행 전");
		int i = ts.getNum();
		System.out.println("i값은: " + i);
		System.out.println("getNum() 실행 후\n====================\n");

		System.out.println("setNum(\"한글창제\", 1446) 실행 전");
		ts.setNum("한글창제", 1446);
		System.out.println("setNum(\"한글창제\", 1446) 실행 후\n====================\n");

		System.out.println("intNum(7) 실행 전");
		ts.intNum(7);
		System.out.println("intNum(7) 실행 후\n====================\n");

		container.close();
	}
}