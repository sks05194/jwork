<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.dto.Member" %>
<!DOCTYPE html>
<html>
<head>
	<title>Session</title>
</head>
<body>
	<%
	String user_id = request.getParameter("id");
	String user_pw = request.getParameter("passwd");
	
	Member mem = new Member(user_id, user_pw);
	
	if (mem.login() != null) {
		session.setAttribute("userID", user_id);
		session.setAttribute("userPW", user_pw);
		out.println("세션 설정이 성공했습니다.<br>");
		out.println(user_id + "님 환영합니다.");
	} else {
		out.println("세션 설정이 실패했습니다.");
	}
	%>
	<a href="14_01_session02.jsp">세션 확인하기</a>
</body>
</html>