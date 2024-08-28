<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="person" class = "com.dto.Person" scope = "request"/>
<p> 아이디 : <%=person.getId() %>
<p> 이름 : <%=person.getName() %>

<%
	person.setId(20182005);
	person.setName("손동진");
%>
<p> 아이디 : <%=person.getId() %>
<p> 이름 : <%=person.getName() %>
<jsp:include page = "08_02_useBean03.jsp"/>
</body>
</html>