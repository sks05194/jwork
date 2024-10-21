package com.springtest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtest.vo.UsersVO;

@Service
public class LoginSVC {
	@Autowired
	private LoginDAO dao;

	public int usJoin(UsersVO vo) {
		return dao.usJoin(vo);
	}
}
