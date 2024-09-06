<%@page import="vo.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
<style>
	#memberListArea{
		width : 400px;
		border : 1px solid gray;
		margin : auto;
	}
	table{
		width : 380px;
		margin : auto;
		text-align: center;
	}
</style>
</head>
<body>
	<section id = "memberListArea">
		<table>
			<tr>
				<td><h1>일반 회원</h1></td>
			</tr>
			<tr>
				<td><p>${id}님 환영합니다.</p></td>
			</tr>
		</table>
	</section>
	<div style="width: 400px; margin : auto; margin-top: 10px; text-align: right;">
		<a href="./memberLogout.me">로그아웃</a>
	</div>
</body>
</html>