<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<title>현재 시간</title>
</head>
<body>
	<h1>Attribute 속성 사용하여 값 설정하고 받기</h1>
	<%Calendar cal = (Calendar)request.getAttribute("time"); %>
	현재 시간은
	<%=cal.get(Calendar.HOUR_OF_DAY) > 9 ? cal.get(Calendar.HOUR_OF_DAY):"0" + cal.get(Calendar.HOUR_OF_DAY)%>시
	<%=cal.get(Calendar.MINUTE) > 9 ? cal.get(Calendar.MINUTE):"0" + cal.get(Calendar.MINUTE)%>분
	<%=cal.get(Calendar.SECOND) > 9 ? cal.get(Calendar.SECOND):"0" + cal.get(Calendar.SECOND)%>초
	입니다.
	<hr>
	파라미터로 받아온 값: <%=request.getParameter("time") %>
</body>
</html>