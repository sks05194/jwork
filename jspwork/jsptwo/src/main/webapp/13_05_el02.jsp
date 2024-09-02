<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.dao.Thermometer" %>
<!DOCTYPE html>
<html>
<head>
	<title>EL로 객체의 메서드 호출하기</title>
</head>
<%
Thermometer thermometer = new Thermometer();
request.setAttribute("t", thermometer);
%>
<body>
	<h2>EL로 객체의 메서드 호출하기</h2>
	${t.setCelsius('서울', 27.3)}
	서울 온도: 섭씨 ${t.getCelsius('서울')}℃ / 화씨 ${t.getFahrenheit('서울')}℉

	<br>
	정보: ${t.info}<br>
	테스트: ${t.str}
</body>
</html>