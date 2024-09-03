<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>Filter</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	%>
	<p>입력된 id 값: <%=id %></p>
	<p>입력된 pw 값: <%=passwd %></p>
	<a href="18_01_filter02.jsp">돌아가기</a>
	<%System.out.println("18_01_filter02_process.jsp 실행"); %>
</body>
</html>