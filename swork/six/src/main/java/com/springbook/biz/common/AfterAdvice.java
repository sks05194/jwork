package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
//	@After("execution(* com.springbook.biz..*Impl.*(..))")
	public void finallyLog() {
		System.out.println("[after 시점] 비즈니스 로직 수행 후 무조건 동작");
	}
}