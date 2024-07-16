package dbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DeleteTest {
	public DeleteTest(int empno) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TEST", "1111");

			Statement st = conn.createStatement();
			int rowCount = st.executeUpdate("delete from emp where empno=" + empno);
			
			PreparedStatement ps = conn.prepareStatement("delete from emp where empno=?");
			ps.setInt(1, empno);
			rowCount = ps.executeUpdate();

			if (rowCount > 0) {
				System.out.println("데이저 삭제 완료");
			} else {
				System.out.println("데이터 삭제 실패");
			}

			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new DeleteTest(1);
	}

}
