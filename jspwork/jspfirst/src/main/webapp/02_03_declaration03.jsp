<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!String makeItLower(String data) {
		System.out.println("콘솔창에 출력");
		return data.toLowerCase();
	}%>
	<%
	out.println(makeItLower("Hello World"));
	%>
</body>
</html>