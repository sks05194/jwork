<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
	<title>Session</title>
</head>
<body>
	<p><h4>----- 세션을 삭제하기 전 -----</h4></p>
	<%
	// request.getSession() => request.getSession(false)와 동일
	// 기존의 session 객체가 있으면 가져오고, 없으면 null값 반환
	// request.getSession(true): 기존의 session 객체가 있으면 가져오고, 없으면 새로운 세션 객체 생성
	// HttpSession ss = request.getSession();
	String user_id = (String) session.getAttribute("userID");
	String user_pw = (String) session.getAttribute("userPW");
	out.println("설정된 세션 userId: " + user_id + "<br>");
	out.println("설정된 세션 userPW: " + user_pw + "<br>");
	
	out.print("<hr>" + "만료전 세션 id: " + session.getId() + "<br><hr>");
	
	if (request.isRequestedSessionIdValid())
		out.print("세션이 유효합니다.");
	else
		out.print("세션이 유효하지 않습니다.");
	
	// 다중 세션 삭제(Attribute 속성 및 세션 id까지 제거함. session 객체 안의 데이터 모두 초기화)
	session.invalidate();
	%>
	<h4>----- 세션을 삭제한 후 -----</h4>
	<%
	out.print("<hr>" + "만료후 세션 id: " + session.getId() + "<br><hr>");
	
	if (request.isRequestedSessionIdValid())
		out.print("세션이 유효합니다.");
	else
		out.print("세션이 유효하지 않습니다.");
	%>
</body>
</html>