<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inser 폼생성</title>
</head>
<body>
복습을 하자면 form태그안 name이 있어야하고 sumbit 것이 있어야함. 
그래서 
<form action = "08_05_JSPparameter.jsp" method = "post">
	<label> 이름: <input type = "number" name = 'name' size = "30"></label>
	<label> 주소: <input type = "text" name = 'name' size = "30"></label>

	<br> 동물이름들 화면에 보이지 ? 
	<label> 강아지: <input type = "checkbox" name = 'pet' size = "30" value = "dog"></label>
	<label> 고양이: <input type ="checkbox" name = 'pet' size = "30" value = "cat"></label>
	<label> 돼지: <input type = "checkbox" name = 'pet' size = "30" valye = "pig"></label>
	
	<input type = "submit" value ="전송">
	
</form>


</body>
</html>