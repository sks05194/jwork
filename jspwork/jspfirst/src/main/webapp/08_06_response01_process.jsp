<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Implicit Objects</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("id");
	String password = request.getParameter("passwd");
	
	if (userid.equals("admin") && password.equals("1234")) {
		response.sendRedirect("08_06_response01_success.jsp");
	} else {
		response.sendRedirect("08_06_response01_failed.jsp");
	}
	%>
</body>
</html>