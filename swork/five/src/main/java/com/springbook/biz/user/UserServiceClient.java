package com.springbook.biz.user;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("userContext/applicationContext.xml");
		UserService userService = (UserService) container.getBean("userService");
		

		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
		UserVO user = userService.login(vo);
		if (user != null) System.out.println(user.getName() + "님 환영합니다.");
		else System.out.println("\u001B[31m로그인 실패\u001B[0m");

		// 회원 목록
		List<UserVO> uList = userService.getuserList();
		for (UserVO uvo : uList) {
			System.out.println("-----> " + uvo);
		}

//		// 로그인
//		vo = new UserVO();
//		vo.setId("admin");
//		vo.setPassword("1111");
//		vo = userService.login(vo);
//		if(vo != null) System.out.println("로그인 정보: " + vo);
//		else System.out.println("로그인 실패");
//
//		// 회원 목록
//		List<UserVO> uList = userService.getuserList();
//		System.out.println();
//		for (UserVO uvo : uList) {
//			System.out.println(uvo);
//		}
//
//		//회원 가입
//		vo.setId("duly");
//		vo.setPassword("1234");
//		vo.setName("둘리");
//		vo.setRole("User");
//		int cnt = userService.userInsert(vo);
//		if (cnt > 0) System.out.println("회원등록완료");
//		else System.out.println("회원등록실패");
//		
//		uList = userService.getuserList();
//		System.out.println();
//		for (UserVO uvo : uList) {
//			System.out.println(uvo);
//		}
//
//		// 회원 탈퇴
////		vo.setId("duly");
////		vo.setPassword("1234");
//		cnt = userService.userDelete(vo);
//		if (cnt > 0) System.out.println("회원탈퇴완료");
//		else System.out.println("회원탈퇴실패");
//
//		uList = userService.getuserList();
//		System.out.println();
//		for (UserVO uvo : uList) {
//			System.out.println(uvo);
//		}
//		
//		// 회원 수정
//		vo.setPassword("1234");
//		vo.setName("고길동");
//		vo.setRole("Admin");
//		vo.setId("user1");
//		cnt = userService.userUpdate(vo);
//		if (cnt > 0) System.out.println("회원수정완료");
//		else System.out.println("회원수정실패");
//
//		uList = userService.getuserList();
//		System.out.println();
//		for (UserVO uvo : uList) {
//			System.out.println(uvo);
//		}

		container.close();
	}
}