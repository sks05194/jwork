<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*, java.util.*" %>    
        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border = "1">
	<tr><th>요청 파라미터 이름</th><th>요청 파라미터 값</th></tr>
	<%
		request.setCharacterEncoding("UTF-8");
		Enumeration<String> paraName  = request.getParameterNames();
		while(paraName.hasMoreElements()){
			String name = (String) paraName.nextElement();
			out.println("<tr><td>" + name +"</td>");
			
			String paramValue = request.getParameter(name);
			out.println("<td>" + paramValue+"</td></tr>");
			
		}
		// 
	%>

</table>




</body>
</html>