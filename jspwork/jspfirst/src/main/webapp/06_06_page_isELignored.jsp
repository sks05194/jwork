<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directives Tag</title>
</head>
<body>
	<%
	request.setAttribute("RequestAttribute", "request 내장 객체");
	%>
	${RequestAttribute}
</body>
</html>