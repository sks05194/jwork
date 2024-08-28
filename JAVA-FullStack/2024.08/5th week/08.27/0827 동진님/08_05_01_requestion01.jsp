<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ids = request.getParameter("id") != null? request.getParameter("id"):"아이디  없음";

	//
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "08_05_01_request_process.jsp" method = "get">

<!-- 	<form method = "get">  get방식은 인코딩이 필요 없다,  post가 필요함. 
	속성명 : name , password 
	속성값 : 브라우저에서 입력한 값  
	
-->
	<p>아이디 : <input type = "text" name = "id" value = "<%=ids %>"></p>
	<p>비밀번호 : <input type = "password" name = "password" ></p>
		<input type = "submit" value = "전송"/>
	</form>
	

</body>
</html>