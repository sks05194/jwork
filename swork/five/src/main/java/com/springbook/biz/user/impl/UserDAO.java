package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

@Repository
public class UserDAO {
	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	// 로그인
	private final String USER_LOGIN = "SELECT * FROM users WHERE id = ? AND password = ?";
	public UserVO login(UserVO vo) {
		UserVO uvo = null;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(USER_LOGIN);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			rs = ps.executeQuery();
			if (rs.next()) {
				uvo = new UserVO();
				uvo.setId(rs.getString("id"));
				uvo.setPassword(rs.getString("password"));
				uvo.setName(rs.getString("name"));
				uvo.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);
		}
		return uvo;
	}

	// 회원목록
	private final String USER_LIST = "SELECT * FROM users";
	public List<UserVO> getuserList() {
		List<UserVO> userList = new ArrayList<UserVO>();

		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(this.USER_LIST);
			rs = ps.executeQuery();

			while (rs.next()) {
				UserVO user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);
		}

		return userList;
	}

	// 회원 수정
	private final String USER_UPDATE = "UPDATE users SET password = ?, name = ?, role = ? WHERE id = ?";
	public int userUpdate(UserVO vo) {
		int cnt = 0;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(USER_UPDATE);
			ps.setString(1, vo.getPassword());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getRole());
			ps.setString(4, vo.getId());
			cnt = ps.executeUpdate();
			
//			if (cnt > 0) System.out.println("회원수정완료");
//			else System.out.println("회원수정실패");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, conn);
		}
		return cnt;
	}

	// 회원 가입
	private final String USER_INSERT = "INSERT INTO users VALUES (?, ?, ?, ?)";
	public int userInsert(UserVO vo) {
		int cnt = 0;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(USER_INSERT);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getRole());
			cnt = ps.executeUpdate();
			
//			if (cnt > 0) System.out.println("회원등록완료");
//			else System.out.println("회원등록실패");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, conn);
		}
		return cnt;
	}

	// 회원 탈퇴
	private final String USER_DELETE = "DELETE FROM users WHERE id = ? AND password = ?";
	public int userDelete(UserVO vo) {
		int cnt = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(USER_DELETE);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			cnt = ps.executeUpdate();
			
//			if (cnt > 0) System.out.println("회원탈퇴완료");
//			else System.out.println("회원탈퇴실패");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, conn);
		}
		
		return cnt;
	}
}
