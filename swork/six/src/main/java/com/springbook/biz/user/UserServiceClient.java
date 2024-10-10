package com.springbook.biz.user;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) container.getBean("userService");

		UserVO vo = new UserVO();
		vo.setId("admin");
		vo.setPassword("1111");

		UserVO user = userService.login(vo);
		if (user != null) System.out.println(user.getName() + "님 환영합니다.");
		else System.out.println("\u001B[31m로그인 실패\u001B[0m");

		// 회원 목록
		List<UserVO> uList = userService.getuserList();
		for (UserVO uvo : uList) {
			System.out.println("-----> " + uvo);
		}

		container.close();
	}
}