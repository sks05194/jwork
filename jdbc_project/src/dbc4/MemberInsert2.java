package dbc4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberInsert2 {
	public static void main(String[] args) {
		try {
			Connection conn = DBConnec1.getConnection();
			String userid = "tiger";
			String pwd = "1111";
			String email = "tiger@java.com";
			String hp = "010-1111-3333";

			// Statement
			// String클래스의 format 메서드를 사용하여 보기좋게 작성.
			String sql = String.format("INSERT INTO tb_member ( m_seq, m_userid, m_pwd, m_email, m_hp ) "
					+ "VALUES ( seq_tb_member.NEXTVAL, '%s', '%s', '%s', '%s' )", userid, pwd, email, hp);

			Statement stmt = conn.createStatement();
			int count = stmt.executeUpdate(sql);
			System.out.println(count + "개 행 입력");

			// PreparedStatement
			sql = "INSERT INTO tb_member ( m_seq, m_userid, m_pwd, m_email, m_hp ) "
					+ "VALUES ( seq_tb_member.NEXTVAL, :userid, :pwd, :email, :hp )";
//			sql = "INSERT INTO tb_member ( m_seq, m_userid, m_pwd, m_email, m_hp ) "
//					+ "VALUES ( seq_tb_member.NEXTVAL, ?, ?, ?, ? )";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, pwd);
			ps.setString(3, email);
			ps.setString(4, hp);
			count = ps.executeUpdate();
			System.out.println(count + "개 행 입력");

			stmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				DBConnec1.close();
			} catch (SQLException e2) {
			}
		}
	}
}