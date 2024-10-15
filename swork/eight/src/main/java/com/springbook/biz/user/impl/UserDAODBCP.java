package com.springbook.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository
public class UserDAODBCP {
	private final String USER_LOGIN = "SELECT * FROM users WHERE id = ? AND password = ?";
	private final String USER_UPDATE = "UPDATE users SET password = ?, name = ?, role = ? WHERE id = ?";
	private final String USER_INSERT = "INSERT INTO users VALUES (?, ?, ?, ?)";
	private final String USER_DELETE = "DELETE FROM users WHERE id = ? AND password = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserVO login(UserVO vo) {
		System.out.println("jdbcTemplate getUser 메소드 실행");
		Object[] args = { vo.getId(), vo.getPassword() };
		try {
			return jdbcTemplate.queryForObject(USER_LOGIN, new UserRowMapper(), args);
//		} catch (EmptyResultDataAccessException e) {
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	public int userUpdate(UserVO vo) {
		System.out.println("jdbcTemplate userUpdate 메소드 실행");
		return jdbcTemplate.update(USER_UPDATE, vo.getPassword(), vo.getName(), vo.getRole(), vo.getId());
	}

	public int userInsert(UserVO vo) {
		System.out.println("jdbcTemplate userInsert 메소드 실행");
		return jdbcTemplate.update(USER_INSERT, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());
	}

	public int userDelete(UserVO vo) {
		System.out.println("jdbcTemplate userDelete 메소드 실행");
		return jdbcTemplate.update(USER_DELETE, vo.getId(), vo.getPassword());
	}

	public List<UserVO> getUserList(String keyword) {
		System.out.println("jdbcTemplate getUserList 메소드 실행");

		String USER_LIST = "SELECT * FROM users WHERE 1=1";

		if (keyword != null) {
			USER_LIST += " AND id LIKE CONCAT('%', ? '%') OR name LIKE CONCAT('%', ?, '%') ";
			Object[] args = { keyword, keyword };
			if (jdbcTemplate.query(USER_LIST, new UserRowMapper(), args).isEmpty()) {
				return null;
			} else {
				return jdbcTemplate.query(USER_LIST, new UserRowMapper(), args);
			}
		} else {
			if (jdbcTemplate.query(USER_LIST, new UserRowMapper()).isEmpty()) {
				return null;
			} else {
				return jdbcTemplate.query(USER_LIST, new UserRowMapper());
			}
		}
	}

	public UserVO selUser(UserVO vo) {
		String USER_GET = "SELECT * FROM users WHERE id = ?";

		Object[] args = { vo.getId() };
		try {
			return jdbcTemplate.queryForObject(USER_GET, new UserRowMapper(), args);
		} catch (Exception e) {
			return null;
		}
	}
}