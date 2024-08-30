<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
// session.setAttribute("name", "<script>alert('하이!!');</script>");
// response.sendRedirect("13_03_jstl_core.jsp");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Test</title>
</head>
<body>
    <c:forEach var="i" begin="1" end="10" step="1">
        <p>안녕하세요? ${i}</p>
    </c:forEach><hr>
</body>
</html>