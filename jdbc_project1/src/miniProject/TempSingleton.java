package miniProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class TempSingleton {
	private static Connection con = null;
	private static Scanner sc = null;

	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 커넥션 객체 생성을 위한 것을 만드는것.
	// user name 기타 등등이 있습니다.
	private String user = "LMS";
	private String pwd = "1111";
	private String driver = "oracle.jdbc.driver.OracleDriver";

	// 접근 불가능한 기본생성자
	private TempSingleton() {
		// 접근 불가능한 코드
	};

	{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/** Connection 객체를 반환합니다. */
	public Connection getConnection() {
		if (con == null) {
			try {
				con = DriverManager.getConnection(url, user, pwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return con;
	}

	/** Scanner 객체를 반환합니다. */
	public Scanner getScanner() {
		if (sc == null) {
			sc = new Scanner(System.in);
		}

		return sc;
	}

	/** Connection 객체를 닫아줍니다. */
	public void CloseConnection() {
		try {
			if (con != null) {
				if (!con.isClosed()) {
					con.close();
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}