<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		out.print("Value of the variable is: " + data + "<br>");
	
		String data = "히하하";
		out.print("2_Value of the variable is: " + data);
	%>
	<%!int data = 50;%>
	<%=data%>
</body>
</html>