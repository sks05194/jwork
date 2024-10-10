package com.springbook.biz.user.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository
public class UserDAOSpring extends JdbcDaoSupport {
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	private final String USER_LOGIN = "SELECT * FROM users WHERE id = ? AND password = ?";
	private final String USER_LIST = "SELECT * FROM users";
	private final String USER_UPDATE = "UPDATE users SET password = ?, name = ?, role = ? WHERE id = ?";
	private final String USER_INSERT = "INSERT INTO users VALUES (?, ?, ?, ?)";
	private final String USER_DELETE = "DELETE FROM users WHERE id = ? AND password = ?";

	public UserVO login(UserVO vo) {
		System.out.println("getJdbcTemplate() getUser 메소드 실행");
		Object[] args = { vo.getId(), vo.getPassword() };
		try {
			return getJdbcTemplate().queryForObject(USER_LOGIN, new UserRowMapper(), args);
//		} catch (EmptyResultDataAccessException e) {
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	public List<UserVO> getuserList() {
		System.out.println("getJdbcTemplate() getUserList 메소드 실행");
		try {
			return getJdbcTemplate().query(USER_LIST, new UserRowMapper());
		} catch (Exception e) {
			return null;
		}
	}

	public int userUpdate(UserVO vo) {
		System.out.println("getJdbcTemplate() userUpdate 메소드 실행");
		return getJdbcTemplate().update(USER_UPDATE, vo.getPassword(), vo.getName(), vo.getRole(), vo.getId());
	}

	public int userInsert(UserVO vo) {
		System.out.println("getJdbcTemplate() userInsert 메소드 실행");
		return getJdbcTemplate().update(USER_INSERT, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());
	}

	public int userDelete(UserVO vo) {
		System.out.println("getJdbcTemplate() userDelete 메소드 실행");
		return getJdbcTemplate().update(USER_DELETE, vo.getId(), vo.getPassword());
	}
}