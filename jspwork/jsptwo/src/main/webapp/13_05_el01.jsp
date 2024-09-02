<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setAttribute("person", "호동이"); %>
<!DOCTYPE html>
<html>
<head>
	<title>EL의 기본객체</title>
</head>
<body>
	<h2>기본객체를 사용한 EL</h2>
	<fmt:requestEncoding value="utf-8"/>
	<%-- <%request.setCharacterEncoding("UTF-8"); %> --%>
	요청 URI: ${pageContext.request.requestURI}<br>
	request에 설정한 person 속성: ${requestScope.person}<br><hr>
	
	<%-- request에 설정한 person 속성: ${person}<br><hr> --%>
	<%-- request에 설정한 person 속성: <%=request.getAttribute("person")%><br><hr> --%>
	
	<!-- param.code => request.getParameter("code") -->
	<c:choose>
		<c:when test="${param.code ne null}">
			<p>code 파라미터: ${param.code}</p>
		</c:when>
		<c:otherwise>
			<p>code 파라미터가 없습니다.<br>code 파라미터를 전송해주세요.</p>
		</c:otherwise>
	</c:choose>

	<form method="post">
		<input type="text" name="code">
		<input type="submit" value="전송">
	</form>
</body>
</html>