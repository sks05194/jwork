<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><% 
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	
	String phone1 = request.getParameter("phone1");
	String phone2 = request.getParameter("phone2");
	String phone3 = request.getParameter("phone3");
	String gender = request.getParameter("gender");
	
	String hobby[] = request.getParameterValues("hobby");
	String comment  = request.getParameter("comment");
	
	%>
	<%
		if(id == "admin"){
		out.println("중복값이 있스");
		}
		else {
			out.println("중복값이 없어요");
		}
	%>
	<p> 아이디 : <%=id %> </p>
	<p> 비밀번호 : <%=passwd %> </p>
	<p> 이름 : <%=name %> </p>
	<p> 연락처: <%=phone1 %> <%=phone2 %><%=phone3 %></p>
	<p> 성별 : <%=gender %> </p>
	<p> 취미: <%=hobby %></p>
	<p> 가입인사: <%=comment %> </p>
	<p>가입 인사 : <textarea><%=comment.replace("\n", "<br>") %></textarea></p>
	

</body>
</html>