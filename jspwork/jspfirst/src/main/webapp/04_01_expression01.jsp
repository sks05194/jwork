<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag</title>
</head>
<body>
	<p>Today's date: <%=new java.util.Date()%></p>
	<%
	int a = 10;
	int b = 20;
	int c = 30;
	%>
	<%=a + b + c%>
	<%-- <%=a + b + c %> --%>
	<!-- <p>test1</p> -->
	<%-- <p>test2</p> --%>
	<p>test3</p>
</body>
</html>