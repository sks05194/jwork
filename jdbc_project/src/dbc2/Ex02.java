package dbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbc1.User;

public class Ex02 {
	// sql문 : INSERT INTO dept (deptno, dname, loc) Values (50, '개발', '서울')
	// 출력결과 : 처리한 행수 결과 : 1줄이 처리되었습니다.

	public static void main(String[] args) {
		// 객체선언만
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			User user = new User();
			// 1. 드라이버 설치
			Class.forName(user.getDriver());

			// 2. Connection 객체 생성
			conn = DriverManager.getConnection(user.getUrl(), user.getUser(), user.getPwd());

			// 3. 명령문 객체 생성
			ps = conn.prepareStatement("INSERT INTO dept (deptno, dname, loc) Values (?, ?, ?)");

			// 4. 명령문 객체 실행
			ps.setInt(1, 50);
			ps.setString(2, "개발");
			ps.setString(3, "서울");
			int rowCount = ps.executeUpdate();
			System.out.println("출력결과 : 처리한 행수 결과 : " + rowCount + "줄이 처리되었습니다.");
		} catch (Exception e) {
			System.out.println("드라이버 또는 sql 명령 에러");
		} finally {
			// 5. 객체 닫기
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("객체 닫기 오류");
			}
		}
	}
}