package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

import com.springbook.biz.user.UserVO;

public class AfterReturningAdvice {
	public void afterLog(JoinPoint j, Object robj) {
		String method = j.getSignature().getName();

		if (robj == null) {
			System.out.println("등록되지 않은 사용자입니다.");
		} else if (robj instanceof UserVO) {
			UserVO user = (UserVO) robj;
			if (user.getRole().equals("Admin")) {
				System.out.println(user.getName() + "로그인(Admin)");
			}
		}

		System.out.println("[사후처리] " + method + "()메소드 리턴값: " + robj);
	}
}