package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// Member 테이블의 데이터에 접근하기 위한 SQL 쿼리문을 담고 있는 클래스 생성
public class MemberDAO {
	private Connection conn = null;

	private Connection getConnect() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (Exception n) {
			System.out.println(n);
		}
		
		return conn;
	}
	
	// 로그인 메소드
	public MemberVO login(String id, String pw) {
		String sql = "SELECT * FROM member WHERE id = ? AND password = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		getConnect();
		MemberVO vo = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("ID"));
				vo.setPassword(rs.getString("PASSWORD"));
				vo.setName(rs.getString("NAME"));
				vo.setGender(rs.getString("GENDER"));
				vo.setBirth(rs.getString("BIRTH"));
				vo.setMail(rs.getString("MAIL"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("ADDRESS"));
				vo.setRegist_day(rs.getString("REGIST_DAY"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return vo;
	}
}