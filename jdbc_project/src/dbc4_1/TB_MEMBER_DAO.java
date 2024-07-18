package dbc4_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//DAO(=Data Access Object): SQL명령문을 담고 있는 클래스
public class TB_MEMBER_DAO {
	// --회원 로그인 체크
	public TB_MEMBER_VO login(String m_userid, String m_pwd) {
		String sql = "SELECT * FROM TB_MEMBER" + " WHERE M_YN = 'Y' AND M_USERID=? AND M_PWD =?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TB_MEMBER_VO tvo = null;

		try {
			con = DBConnec1.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, m_userid);
			ps.setString(2, m_pwd);
			rs = ps.executeQuery();

			if (rs.next()) {
				tvo = new TB_MEMBER_VO();
				tvo.setM_seq(rs.getInt("M_SEQ"));
				tvo.setM_userid(rs.getString("M_USERID"));
				tvo.setM_pwd(rs.getString("M_PWD"));
				tvo.setM_email(rs.getString("M_EMAIL"));
				tvo.setM_hp(rs.getString("M_HP"));
				tvo.setM_registdate(rs.getString("M_REGISTDATE"));
				tvo.setM_point(rs.getInt("M_POINT"));
				tvo.setM_yn(rs.getString("M_YN"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					rs.close();
				DBConnec1.close();
			} catch (SQLException e) {

			}
		}
		return tvo;
	}

//	--전체 회원목록 조회(보기)
//	select * from tb_member ; --ArrayList<>클래스
	public ArrayList<TB_MEMBER_VO> memberList() {
		String sql = "select * from tb_member";
		ArrayList<TB_MEMBER_VO> mList = new ArrayList<>();

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = DBConnec1.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				TB_MEMBER_VO tvo = new TB_MEMBER_VO(); // &200
				tvo.setM_seq(rs.getInt("M_SEQ"));
				tvo.setM_userid(rs.getString("M_USERID"));
				tvo.setM_pwd(rs.getString("M_PWD"));
				tvo.setM_email(rs.getString("M_EMAIL"));
				tvo.setM_hp(rs.getString("M_HP"));
				tvo.setM_registdate(rs.getString("M_REGISTDATE"));
				tvo.setM_point(rs.getInt("M_POINT"));
				tvo.setM_yn(rs.getString("M_YN"));
				mList.add(tvo);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				// 객체 닫기 conn, ps, st, rs
				rs.close();
				st.close();
				DBConnec1.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return mList;
	}

//	--로그인한 사용자 정보보기(내정보보기, 특정사용자 검색 메뉴) selOne(....)
//	select * from tb_member where m_userid = 'apple' AND  M_YN = 'Y' ;  --vo, dto클래스

//	--회원 가입
	/*
	 * M_SEQ NUMBER M_USERID VARCHAR2(20 BYTE) M_PWD VARCHAR2(20 BYTE) M_EMAIL
	 * VARCHAR2(50 BYTE) M_HP VARCHAR2(20 BYTE)
	 */
	// 회원 가입
	public int join(String m_userid, String m_pwd, String m_email, String m_hp) {
		String sql = "insert into tb_member (M_SEQ, M_USERID, M_PWD, M_EMAIL, M_HP) ";
		sql += " values (SEQ_TB_MEMBER.NEXTVAL , ? , ? , ?, ?)";

		Connection con = null;
		PreparedStatement ps = null;
		int rowCount = 0;

		try {
			con = DBConnec1.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, m_userid);
			ps.setString(2, m_pwd);
			ps.setString(3, m_email);
			ps.setString(4, m_hp);
			rowCount = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				// 객체 닫기 con, ps
				if (ps != null)
					ps.close();
				DBConnec1.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return rowCount;
	}

//	--내 정보 수정 , 특정사용자 정보 수정 myUpdate(....)
	// 수정가능한 정보들 M_PWD, M_EMAIL, M_HP
	public int myUpdate(String new_m_pwd, String old_m_pwd, String m_email, String m_hp, String m_userid) {
		String sql = "UPDATE TB_MEMBER SET ";
		if (!(new_m_pwd == null || new_m_pwd.equals("")))  sql += " M_PWD = '" + new_m_pwd + "' , ";
		else  sql += " M_PWD = M_PWD , ";
		
		if (!(m_email == null || m_email.equals("")))  sql += " M_EMAIL = '" + m_email + "' , ";
		else sql += " M_EMAIL = M_EMAIL , ";

		if (!(m_hp == null || m_hp.equals("")))  sql += " M_HP = '" + m_hp + "' ";
		else  sql += " M_HP = M_HP ";
		sql += " WHERE M_USERID = '"+m_userid+"' and M_PWD = '"+old_m_pwd+"' AND M_YN = 'Y' ";
		System.out.println("완성된 쿼리문 : "+ sql);
		
		int rowCount = 0;
		Connection con = null;
		Statement st = null;
		
		try {
			con = DBConnec1.getConnection();
			st = con.createStatement();
			rowCount = st.executeUpdate(sql);			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(st != null ) st.close();
				DBConnec1.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return rowCount;

	}

//	--회원탈퇴   notUse(...)
	public int notUse(String m_userid, String m_pwd) {
		String sql = "UPDATE TB_MEMBER SET M_YN = 'N' WHERE M_USERID = ? AND M_PWD = ?";
		int rowCount = 0;

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConnec1.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, m_userid);
			ps.setString(2, m_pwd);
			rowCount = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();
				DBConnec1.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return rowCount;
	}

}
