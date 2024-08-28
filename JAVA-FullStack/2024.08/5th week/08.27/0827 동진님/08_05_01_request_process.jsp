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
String userid = request.getParameter("id");
String password = request.getParameter("password");

//아스키코드가 벗어난 범위일경우에 인코딩이 깨진다. 아스키코드의 범위를 깨지지 않기 위해 만들어진 인코딩방식
	
%>
<p>아이디 :<%=userid %><p/>
<p>비밀번호 :<%=password %><p/>

</body>
</html>