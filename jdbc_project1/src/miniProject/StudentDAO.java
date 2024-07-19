package miniProject;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
	// 로그인 구현
	public void loginStudent(String sid, String spw) throws SQLException {
		String sql = "SELECT * FROM student WHERE sid = '?', spw = '?'";
		
		PreparedStatement ps = TempSingleton.getConnection().prepareStatement(sql);
	}
	
	
	
	
	
	
	
	// 지혁님
	// 회원가입 기능 구현
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
}