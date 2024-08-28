<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="m" class ="com.dto.MemberBean"/>
<%-- property는 멤버변수명을 의미함  --%>
	<jsp:setProperty name = "m" property = "id" value = "2" />
<%-- 	<% m.setId(2) %> --%>
	<%="아이디 :"+ m.getId() %>
<%-- 이름: <jsp:getProperty name = "mem" property = "id" /> --%>
	
</body>
</html>