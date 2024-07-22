package dbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class UpdateTest {
	public UpdateTest(int empno, String ename, int sal) {
		User user = new User();

		try {
			// 오라클 드라이버 설치
			Class.forName(user.getDriver());
			System.out.println("DB conn Suceess!");

			// DB와 데이터를 주고 받기 위한 연결객체 생성(통로 open)
			Connection con = DriverManager.getConnection(user.getUrl(), user.getUser(), user.getPwd());

			Statement st = con.createStatement();
			String sql = "update emp set ename='" + ename + "', sal=" + sal + " where empno=" + empno;
			int rowCount = st.executeUpdate(sql);

			if (rowCount > 0) {
				System.out.println("수정완료");
			} else {
				System.out.println("수정실패");
			}
			st.close();

			sql = "update emp set ename=?, sal=? where empno=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "MIKAEL");
			ps.setInt(2, 4000);
			ps.setInt(3, 7844);
			rowCount = ps.executeUpdate();

			if (rowCount > 0) {
				System.out.println("수정완료");
			} else {
				System.out.println("수정실패");
			}

			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UpdateTest(7844, "TURNER", 8000);
	}
}