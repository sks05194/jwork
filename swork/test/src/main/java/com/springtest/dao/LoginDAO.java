package com.springtest.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springtest.vo.UsersVO;

@Repository
public class LoginDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public int usJoin(UsersVO vo) {
		return mybatis.insert("LoginDAO.usJoin", vo);
	}
}
