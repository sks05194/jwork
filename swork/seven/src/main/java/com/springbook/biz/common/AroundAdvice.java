package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	@Around("execution(* com.springbook.biz..*Impl.*(..))")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();

		StopWatch stopWatch = new StopWatch();
		System.out.println("스톱워치 시작");
		stopWatch.start();

		Object returnObj = pjp.proceed();

		stopWatch.stop();
		System.out.println("스톱워치 종료");
		System.out.println("[AroundAdvice]" + method + "() 메소드 실행 후 수행에 걸린 시간: " + stopWatch.getTotalTimeMillis() + "(ms)초");
		return returnObj;
	}
}