<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("memberId");
String pw = request.getParameter("memberPass");
if (id != null && id.equals("admin") && pw != null && pw.equals("1234")) {
	response.sendRedirect("08_06_index.jsp");
} else {%>
	<!DOCTYPE html>
	<html><head><title>로그인에 실패</title></head>
	<body>잘못된 아이디입니다.</body>
	</html>
<%}%>