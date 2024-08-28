<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		 border: solid 1px;
		 border-collapse :collapse; 
		background-color : #ccc;
		
	}

</style>

</head>
<body>
<%
	String md = request.getMethod();
	String  hostValue = request.getHeader("Host"); // 호스트라는 값을 가져와라 
	String  alValue = request.getHeader("accept-language");
	String  cookie = request.getHeader("cookie");
	String cookies = request.getCookies()[0].getValue();
	
	
%>
  메소드 : <%=md %> <br>
  쿠키 : <%=cookies%> <br>
<table>
	<tr><th>호스트명</th><th>설정된 언어</th><th>쿠키</th></tr>
	<tr><td><%=hostValue %></td><th><%=alValue %></th><th><%=cookie %></th></tr>
	
</table>

</body>
</html>