<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
</head>
<body>
<!-- 	<h1>interceptor 인덱스</h1> -->
<!-- 	<a href="login.do">로그인</a> -->
<!-- 	<a href="join.do">가입</a> -->
<!-- 	<a href="main.do">메인</a> -->
<!-- 	<a href="home.do">홈</a> -->
<!-- 	<a href="newFile.jsp">NEW파일</a> -->
<!-- 	<a onclick="tt()">테스트버튼</a> -->
<!-- 	<br><hr><br> -->
	
	<h1>pathvar 인덱스</h1>
	<a href="/pathvar/page/one">page1</a>
	<a href="/pathvar/page/two">page2</a>
	<a href="/pathvar/byGet?key1=111&key2=zzz">byGet쿼리스트링</a>
	<a href="/pathvar/byPath/qaz/987">byPath Restful 1</a>
	<a href="/pathvar/byPath/key1/123/key2/aza">byPath Restful 2</a>
</body>
</html>



