package dbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JoinEX {
	public static boolean cntResult(String str) {
		for (int i = 0; i < str.length(); i++) {
			int asciiCode = (int) str.charAt(i);
			boolean isNumberOrEngChar = (asciiCode < 48) || (asciiCode > 58 && asciiCode < 65)
					|| (asciiCode > 90 && asciiCode < 97) || (asciiCode > 122);
			if (isNumberOrEngChar) {
				System.out.println("영어 대소문자, 숫자만 입력하실 수 있습니다.");
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		Scanner sc = null;

		try {
			// 1. 드라이버 설치
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TEST", "1111");

			// 3. 명령문 객체 생성
			String sql = "INSERT INTO member ( mid, mpw, mnm, mph, mzip, maddr ) VALUES ( ?, ?, ?, ?, ?, ? )";
			ps = conn.prepareStatement(sql);

			// 4. 명령문 실행
			sc = new Scanner(System.in);

			// 0-9: 48~57; A-Z: 65~90 a~z: 97~122
			while (true) {
				System.out.print("아이디(영어대소문자,숫자포함20자이내)>>");
				String mid = sc.next();

				if (cntResult(mid)) {
					ps.setString(1, mid);
					break;
				}
			}

			while (true) {
				System.out.print("비밀번호(영어대소문자,숫자포함20자이내)>>");
				String mpw = sc.next();
				
				if (cntResult(mpw)) {
					ps.setString(2, mpw);
					break;
				}
			}
			
			sc.nextLine(); // String mpw = sc.next()의 엔터를 상쇄시키기 위해 기술
			System.out.print("이름입력>>");
			String mnm = sc.nextLine();
			ps.setString(3, mnm);

			System.out.print("전화번호입력(예: 01012341234)>>");
			String mph = sc.next();
			ps.setString(4, mph);

			System.out.print("우편번호입력(예: 12345)>>");
			System.out.println("입력여부 선택: 1. 예  2. 아니오");
			int yes_no = sc.nextInt();
			if (yes_no == 1) {
				System.out.print("우편번호입력>>");
				String mzip = sc.next();
				ps.setString(5, mzip);
			} else {
				ps.setString(5, "");
				System.out.println();
			}

			sc.nextLine(); // String mzip = sc.next()의 엔터를 상쇄시키기 위해 기술
			System.out.print("주소 입력>>");
			System.out.println("입력여부 선택: 1. 예  2. 아니오");
			yes_no = sc.nextInt();
			if (yes_no == 1) {
				System.out.print("주소 입력>>");
				String maddr = sc.nextLine();
				ps.setString(6, maddr);
			} else {
				ps.setString(6, "");
			}

			int rowCount = ps.executeUpdate();

			if (rowCount > 0)
				System.out.println("회원가입 완료");
			else
				System.out.println("회원가입 실패");
		} catch (Exception e) {
			System.out.println("드라이버 연결실패 또는 SQL명령 오류");
		} finally {
			// 5. 객체 닫기
			try {
				if (sc != null)
					sc.close();
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