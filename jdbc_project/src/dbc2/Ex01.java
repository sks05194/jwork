package dbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex01 {
	// sql문 : SELECT empno, ename, job, hiredate FROM emp WHERE deptno = 10
	// 출력결과 : 사번, 이름, 직책, 입사일자의 위에서 가져온 행 수만큼 출력되도록 처리할 것.
	// 단 한 행은 같은 줄에 출력되도록 해주세요.
	// 예시: 아래와 같이 출력되도록
	//	7782	CLARK	MANAGER		81/06/09 
	//	7839	KING	PRESIDENT	81/11/17 
	//	7934	MILLER	CLERK		82/01/23 

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 1. 드라이버 설치
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 객체 생성
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String username = "TEST";
			String password = "1111";
			conn = DriverManager.getConnection(url, username, password);

			// 3. 명령문 객체 생성
			String sql = "SELECT empno, ename, job, hiredate FROM emp WHERE deptno = 10";
			st = conn.createStatement();

			String sql1 = "SELECT empno, ename, job, hiredate FROM emp WHERE deptno = ?";
			ps = conn.prepareStatement(sql1);

			// 4. 명령문 객체 실행
			rs = st.executeQuery(sql);

			ps.setInt(1, 10);
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.printf("%d \t %s \t %s \t %s \n",
					rs.getInt("empno"), rs.getString("ename"),
					rs.getString("job"), rs.getString("hiredate"));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 오류");
		} catch (SQLException e) {
			System.out.println("sql 오류");
		} finally {
			// 5. 객체 닫기
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (st != null) st.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.out.println("객체 닫기 오류");
			}
		}
	}
}