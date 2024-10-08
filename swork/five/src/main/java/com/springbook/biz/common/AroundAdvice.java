package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	// ProceddingJoinPoint pjp: 핵심 로직(포인트컷 메소드)정보를 담고 있는 객체
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[around 시점 - proceed전 실행]: 비즈니스 메소드 수행 전에 처리할 내용.");
		// 이 부분이 핵심 로직이 실행(pjp.proceed())되는 시점
		Object returnObj = pjp.proceed();
		System.out.print("returnObj: ");
		System.out.println(returnObj);
		System.out.println("[around 시점 - proceed후 실행]: 비즈니스 메소드 수행 후에 처리할 내용.");
		return returnObj;
	}
}