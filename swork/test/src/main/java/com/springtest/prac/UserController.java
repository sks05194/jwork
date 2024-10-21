package com.springtest.prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springtest.dao.LoginSVC;
import com.springtest.vo.UsersVO;

@Controller
public class UserController {
	@Autowired
	private LoginSVC svc;
	
	@RequestMapping(value = "/us_join", method = RequestMethod.GET)
	public String usJoinForm() {
		return "/WEB-INF/user/us_join.jsp";
	}

	@RequestMapping(value = "/us_join", method = RequestMethod.POST)
	public String usJoin(UsersVO vo) {
		
		if (svc.usJoin(vo) > 0) {
			return "redirect:index.jsp";
		} else {
			return null;
		}
	}
}