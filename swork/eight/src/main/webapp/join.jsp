<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<body>
	<%@include file="menu.jsp"%>
	<div class="container-fluid" style="max-width: 1000px;">
		<div class="jumbotron"><h1>회원가입</h1></div>
		<form action="join.do" method="post">
			<label for="id">아이디</label>
			<input type="text" id="id" name="id">
			<label for="password">비밀번호</label>
			<input type="password" id="password" name="password">
			<label for="name">이름</label>
			<input type="text" id="name" name="name">
			<button type="submit">가입하기</button>
		</form>
	</div>
</body>
</html>