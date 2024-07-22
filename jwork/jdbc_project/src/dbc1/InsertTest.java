package dbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
	private Connection con;
	private Statement st;
	private PreparedStatement pst;

	public static void main(String[] args) {
		new InsertTest(1, "Tom", 100);
		new InsertTest(2, "Javaking", 500);
	}

	public InsertTest(int empno, String ename, double sal) {
		try {
			User user = new User();
			Class.forName(user.getDriver());
			con = DriverManager.getConnection(user.getUrl(), user.getUser(), user.getPwd());
			System.out.println("DB 연결 성공");

			String sql = "insert into emp(empno,ename,sal) values" + "(" + empno + ",'" + ename + "'," + sal + ")";
			st = con.createStatement();
			int result = st.executeUpdate(sql);
			System.out.println("처리된 레코드 개수: " + result);
			st.close();
			
			sql = "insert into emp(empno,ename,sal) values(?, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, 1);
			pst.setString(2, "Tom");
			pst.setInt(3, 1200);
			result = pst.executeUpdate();
			System.out.println("처리된 레코드 개수: " + result);
			pst.close();

		} catch (ClassNotFoundException e) {
			System.out.println(e + "=> 드라이버 로드 실패");
		} catch (SQLException e) {
			System.out.println(e + "=> Sql 예외");
		} catch (Exception e) {
			System.out.println(e + "=> 일반 예외");
		} finally {
			try {
				con.close();

			} catch (SQLException e) {
				System.out.println("연결객체 닫기 오류");
			}
		}

	}
}