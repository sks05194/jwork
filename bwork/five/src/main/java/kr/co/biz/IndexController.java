package kr.co.biz;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.biz.vo.DataBaseVo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final TestService testService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	//서버가 잘 구동되었는지 테스트를 위해서 추가한 코드 입니다.
	@RequestMapping(value = {"/","/index"}, method =RequestMethod.GET)
	public String getBoardData() {
		return "index";
	}
	
	//로그인 페이지
	@RequestMapping(value = {"/login","/loginForm"}, method =RequestMethod.GET)
	public String loginView() {
		return "loginForm";
	}
		
	//오류페이지
	@RequestMapping(value = "/deny", method =RequestMethod.GET)
	public String getDeny() {
		return "deny";
	}


	//회원가입 코드 입니다.
	@RequestMapping(value = "/newMember", method = RequestMethod.GET)
	public String newMember() {
		return "newMember";
	}	
	
	//로그인 성공 시 보여지는 페이지
	@RequestMapping(value = "/member")
	public String member() {
		return "member";
	}	
	
	//super 페이지
	@RequestMapping(value = "/super")
	public String superpage() {
		return "super";
	}	
	
	//normal 페이지
	@RequestMapping(value = "/normal")
	public String normal() {
		return "normal";
	}	
	
	//test 페이지
	@RequestMapping(value = "/test")
	public String test() {
		return "test";
	}	
	
	//회원가입 코드 입니다.
//	@RequestMapping(value = "/newMember", method = RequestMethod.POST)
	@PostMapping("/newMember")
	public String newMember(DataBaseVo vo, HashMap<Object, Object> param) {
		System.out.println(vo);
		vo.setPassword(passwordEncoder.encode(vo.getPassword()));
		System.out.println("password: "+vo.getPassword()); //암호화 할 비밀번호
		param.put("result", testService.newMember(vo));
		return "index";
	}	
	
}
