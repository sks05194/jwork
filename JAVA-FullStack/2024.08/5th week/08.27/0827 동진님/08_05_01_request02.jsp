<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "08_05_01_request02_process.jsp">
	<p>아이디 : <input type = "number" name = "id" ></p>
	
	<p>이름 : <input type = "text" name = "name" value = "관리자 입니다." ></p>

<!-- 	<p>아이디 : <input type = "number" name = "user_id" ></p> 값의 영역을 큰 따옴표 아님 작은 따옴표로 묶어줘야한다.  -->
	
<!-- 	<p>이름 : <input type = "text" name = "user_name" ></p> -->
	<p>취미</p>
	
	<input type = "checkBox" name = "hobby" value = "영화">영화
	<input type = "checkBox" name = "hobby" value = "독서">독서
	<input type = "checkBox" name = "hobby" value = "야구">야구
	
	<p><input type = "submit" value ="전송"></p>
	
	</form>



</body>
</html>