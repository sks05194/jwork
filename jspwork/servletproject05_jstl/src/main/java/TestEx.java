import java.sql.*;

public class TestEx {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","test","1111");
			String sql ="insert into BOARD values( ? , '테스트', '1111', ?, ? , '', 0, 0, 0, 0, SYSDATE)";
			ps = conn.prepareStatement(sql);
			
			//BOARD테이블에 1번부터 52번 글까지 한꺼번에 생성하기 
			for(int i=1; i <= 52; i++){
				ps.setInt(1, i);
				ps.setString(2, "테스트글 제목: "+i);
				ps.setString(3, "테스트글 내용: "+i);
				ps.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) ps.close();
				if(conn !=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}


	}

}
