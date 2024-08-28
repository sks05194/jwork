<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@page import = "com.dao.Calculator" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 액션태그는 이런식으로 한줄로 정리해서 만들 수 있습니다. 
 id = bean은 
 
<jsp:useBean id = "bean" class = "com.dao.Calculator"/>
<% 
int m = bean.process(5);
%>

</body>
</html>