<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder"%>
<!DOCTYPE html>
<html>
<head>
<title>3장 예제</title>
</head>
<body>
	<%-- 인덱스 페이지: <%=request.getParameter("name") != null ? request.getParameter("name") : "로그인에서 이동됨." %> --%>
	
	인덱스 페이지: <%=request.getParameter("name") != null ? URLDecoder.decode(request.getParameter("name"), "utf-8") : "로그인에서 이동됨." %>
</body>
</html>