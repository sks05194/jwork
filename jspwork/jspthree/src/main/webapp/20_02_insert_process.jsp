<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
	<title>Database SQL</title>
</head>
<body>
	<%@ include file="20_02_dbconn.jsp" %>
	<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	
	Statement stmt = null;
	PreparedStatement ps = null;
	
	try {
		// String sql = "INSERT INTO member(id, passwd, name) VALUES('" + id + "','" + passwd + "','" + name + "')";
		// stmt = conn.createStatement();
		// int cnt = stmt.executeUpdate(sql);
		
		String sql = "INSERT INTO member(id, passwd, name) VALUES(?, ?, ?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, passwd);
		ps.setString(3, name);
		int cnt = ps.executeUpdate();
		
		if (cnt > 0) out.println("Member 테이블 삽입이 성공했습니다.<br>");
		else out.println("Member 테이블 삽입이 실패했습니다.<br>");
	} catch (SQLException ex) {
		out.println("SQLException: " + ex.getMessage());
	} finally {
		if (stmt != null) stmt.close();
		if (conn != null) conn.close();
	}
	%>
</body>
</html>