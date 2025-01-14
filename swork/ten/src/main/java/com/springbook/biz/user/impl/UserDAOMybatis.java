package com.springbook.biz.user.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository
public class UserDAOMybatis {
	// 마이바티스 객체 선언 및 자동주입처리 예정
	@Autowired
	private SqlSessionTemplate mybatis;

	public UserVO getUser(UserVO vo) {
		return mybatis.selectOne("UserDAO.getUser", vo);
	}

	public int joinUser(UserVO vo) {
		return mybatis.insert("UserDAO.joinUser", vo);
	}

	public int delUser(UserVO vo) {
		return mybatis.delete("UserDAO.delUser", vo);
	}

	public int updateUser(UserVO vo) {
		return mybatis.update("UserDAO.updateUser", vo);
	}

	public UserVO selUser(UserVO vo) {
		return mybatis.selectOne("UserDAO.selUser", vo);
	}

	public List<UserVO> userList(String keyword) {
		return mybatis.selectList("UserDAO.userList", keyword);
	}
}