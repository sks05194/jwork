package dbc4;

import java.sql.*;
import java.util.ArrayList;

// DAO( = Data Access Objet) : SQL 명령문을 담고 있는 클래스
public class TB_MEMBER_DAO {
	// 회원 로그인 체크
	public TB_MEMBER_VO login(String m_userid, String m_pwd) {
		String sql = "SELECT * FROM tb_member WHERE m_yn = 'Y' AND m_userid = ? AND m_pwd = ?";
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
				tvo.setM_seq(rs.getInt("m_seq"));
				tvo.setM_userid(rs.getString("m_userid"));
				tvo.setM_pwd(rs.getString("m_pwd"));
				tvo.setM_email(rs.getString("m_email"));
				tvo.setM_hp(rs.getString("m_hp"));
				tvo.setM_registdate(rs.getString("m_registdate"));
				tvo.setM_point(rs.getInt("m_point"));
				tvo.setM_yn(rs.getString("m_yn"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				DBConnec1.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tvo;
	}

	// 전체 회원목록 조회(보기)
	public ArrayList<TB_MEMBER_VO> memberList() {
		String sql = "SELECT * FROM tb_member";
		ArrayList<TB_MEMBER_VO> mList = new ArrayList<>();

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = DBConnec1.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				TB_MEMBER_VO tvo = new TB_MEMBER_VO();
				tvo.setM_seq(rs.getInt("m_seq"));
				tvo.setM_userid(rs.getString("m_userid"));
				tvo.setM_pwd(rs.getString("m_pwd"));
				tvo.setM_email(rs.getString("m_email"));
				tvo.setM_hp(rs.getString("m_hp"));
				tvo.setM_registdate(rs.getString("m_registdate"));
				tvo.setM_point(rs.getInt("m_point"));
				tvo.setM_yn(rs.getString("m_yn"));
				mList.add(tvo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				rs.close();
				st.close();
				DBConnec1.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return mList;
	}

	// 로그인한 사용자 정보보기(내정보보기, 특정사용자 검색 메뉴)
	public TB_MEMBER_VO selOne(int m_seq) {
		String sql = "SELECT * FROM tb_member WHERE m_seq = ? AND m_yn = 'Y'";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TB_MEMBER_VO tvo = null;

		try {
			con = DBConnec1.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, m_seq);
			rs = ps.executeQuery();

			if (rs.next()) {
				tvo = new TB_MEMBER_VO();
				tvo.setM_seq(rs.getInt("m_seq"));
				tvo.setM_userid(rs.getString("m_userid"));
				tvo.setM_pwd(rs.getString("m_pwd"));
				tvo.setM_email(rs.getString("m_email"));
				tvo.setM_hp(rs.getString("m_hp"));
				tvo.setM_registdate(rs.getString("m_registdate"));
				tvo.setM_point(rs.getInt("m_point"));
				tvo.setM_yn(rs.getString("m_yn"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				DBConnec1.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tvo;
	}

	// 회원 가입
	public int join(String m_userid, String m_pwd, String m_email, String m_hp) {
		String sql = "INSERT INTO tb_member ( m_seq, m_userid, m_pwd, m_email, m_hp ) VALUES ( seq_tb_member.NEXTVAL, ?, ?, ?, ? )";

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
				if (ps != null)
					ps.close();
				DBConnec1.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return rowCount;
	}

	// 내 정보 수정, 특정사용자 정보 수정 : myUpdate
	public int myUpdate(String m_pwd, String m_email, String m_hp) {
		String sql = "UPDATE tb_member SET ";
		if (!(m_pwd == null || m_pwd.equals("")))
			sql += "m_pwd = '" + m_pwd + "' ";
		else
			sql += "m_pwd = m_pwd, ";
		if (!(m_email == null || m_hp.equals("")))
			sql += "m_email = '" + m_email + "' ";
		else
			sql += "m_email = m_email, ";
		if (!(m_hp == null || m_hp.equals("")))
			sql += "m_hp= '" + m_hp + "' ";
		else
			sql += "m_hp = m_hp, ";
		sql += "WHERE m_userid = ? AND m_yn = 'Y'";

		int rowCount = 0;
		Connection con = null;
		Statement st = null;

		try {
			con = DBConnec1.getConnection();

			st = con.createStatement();

			rowCount = st.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (st != null)
					st.close();
				DBConnec1.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return rowCount;
	}

	// 회원탈퇴
	public int notUse(String m_userid, String m_pwd) {
		String sql = "UPDATE tb_member SET m_yn = 'N' WHERE m_userid = ? AND m_pwd = ?";
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
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return rowCount;
	}
}