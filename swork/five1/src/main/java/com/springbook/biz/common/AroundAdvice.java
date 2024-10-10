package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		Object[] args = pjp.getArgs();

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		System.out.println("[AroundAdvice]" + method + "() 메소드 실행 전");

		// 실제 포인트컷 메소드가 실행되는 시점
		Object returnObj = pjp.proceed();

//		System.out.print("returnObj: ");
//		System.out.println(returnObj);

		stopWatch.stop();
		System.out.println("[AroundAdvice]" + method + "() 메소드 실행 후 수행에 걸린 시간: " + stopWatch.getTotalTimeMillis() + "(ms)초");
		return returnObj;
	}
}