package dbc5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Score {
	public int insertDate() throws ClassNotFoundException, SQLException {
		int result = 0;

		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		String sql, hak, name;
		int kor, eng, mat;
		@SuppressWarnings("resource")
		Scanner br = new Scanner(System.in);

		try {
			System.out.println("학번?");
			hak = br.nextLine();

			System.out.println("이름?");
			name = br.nextLine();

			System.out.println("국어?");
			kor = Integer.parseInt(br.nextLine());

			System.out.println("영어?");
			eng = Integer.parseInt(br.nextLine());

			System.out.println("수학?");
			mat = Integer.parseInt(br.nextLine());

			sql = "INSERT INTO score ( hak, name, kor, eng, mat ) VALUES ( ";
			sql += "'" + hak + "', '" + name + "', " + kor + ", " + eng + ", " + mat + " )";

			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	public void selectAll() throws ClassNotFoundException, SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		String sql, hak, name, str;
		int kor, eng, mat, tot, ave;
		Connection conn = DBConn.getConnection();

		try {

			sql = "SELECT hak, name, kor, eng, mat, ";
			sql += "( kor + eng + mat ) AS tot, "; // 문자 인덱스 사용을 위해 별칭 필요
			sql += "( kor + eng + mat ) / 3 AS ave ";
			sql += "FROM score ORDER BY hak";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			str = String.format("%-10s %-15s %5s %5s %5s %5s %5s", "학번", "이름", "국어", "영어", "수학", "총합", "평균");
			System.out.println(str);
			
			while (rs.next()) {
				hak = rs.getString("hak");
				name = rs.getString("name");
				kor = rs.getInt("kor");
				eng = rs.getInt("eng");
				mat = rs.getInt("mat");
				tot = rs.getInt("tot");
				ave = rs.getInt("ave");
				str = String.format("%-10s %-15s %5d %5d %5d %5d %5d", hak, name, kor, eng, mat, tot, ave);
				System.out.println(str);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}

	public void selectName() throws ClassNotFoundException, SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = DBConn.getConnection();

		String sql, str, searchName, hak, name;
		int kor, eng, mat, tot, ave;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("검색할 이름?");
			searchName = br.readLine();

			sql = "SELECT hak, name, kor, eng, mat, ";
			sql += " ( kor + eng + mat ) AS tot, ";
			sql += " ( kor + eng + mat ) / 3 AS ave ";
			sql += " FROM score ";
			sql += " WHERE upper(name) LIKE upper('%" + searchName + "%')";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				hak = rs.getString("hak");
				name = rs.getString("name");
				kor = rs.getInt("kor");
				eng = rs.getInt("eng");
				mat = rs.getInt("mat");
				tot = rs.getInt("tot");
				ave = rs.getInt("ave");

				str = String.format("%-10s %-15s %5d %5d %5d %5d %5d", hak, name, kor, eng, mat, tot, ave);
				System.out.println(str);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public int deleteDate() throws ClassNotFoundException, SQLException {
		int result = 0;
		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		String sql, str;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("삭제할 학번?");
			str = br.readLine();
			sql = "DELETE FROM score WHERE hak = '" + str + "'";

			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}

		return result;
	}

	public int updateData() throws ClassNotFoundException, SQLException {
		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		int result = 0;

		String sql, hak, name;
		int kor, eng, mat;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("수정할 학번?");
			hak = br.readLine();

			System.out.println("이름?");
			name = br.readLine();

			System.out.println("국어?");
			kor = Integer.parseInt(br.readLine());

			System.out.println("영어?");
			eng = Integer.parseInt(br.readLine());

			System.out.println("수학?");
			mat = Integer.parseInt(br.readLine());

			sql = "UPDATE score SET";
			sql += " name = '" + name + "', kor = " + kor;
			sql += " , eng = " + eng + ", mat = " + mat;
			sql += " WHERE hak = '" + hak + "'";

			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return result;
	}
}