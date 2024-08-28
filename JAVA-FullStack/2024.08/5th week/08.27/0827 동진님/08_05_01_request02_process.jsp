<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
MemberBean memberBean 객체 ;
소문자 아이디 소문자 네임. 소문자 등등이 있는것임.
 
--request Parameter--

------------------------
name =  value 
-----------------------
id      5
name = "관리자"	
hobby = ["영화", "독서", "여행"];

 -->





<%
	request.setCharacterEncoding("utf-8");
	String id  = request.getParameter("user_id");
	String name = request.getParameter("user_name");
	String [] hobby = request.getParameterValues("hobby");
	
/* 	MemeberBean memberBean = new MemberBean();
	
	memberBean.setId(Integer.parseInt(requst.getParameter("user_id")!=""> request.getParameter("user_id"):"0"));
 */%>
	<jsp:useBean id = "memberBean" class ="com.dto.MemberBean"/>
	<jsp:setProperty name = "memberBean" property = "id"/> 이름 :
	<jsp:setProperty name = "memberBean" property = "name"/> 아이디 :
	<jsp:setProperty name = "memberBean" property = "hobby"/> 취미 :

이름:	<jsp:getProperty name = "memberBean" property = "id"/> 
아이디 :	<jsp:getProperty name = "memberBean" property = "name"/> 아이디 :
취미:	<jsp:getProperty name = "memberBean" property = "hobby"/> 취미 :


요청 정보 콘텐츠 : 타입  = <%=request.getContentType() %><br>

	<small style = "color:red">
		클라이언트가 전송한 요청정보(post로 보낸 데이터만)의 컨테츠 타입을 구현함. String으로 반환함. 
	</small>

<%

	for(int i = 0; i < hobby.length; i ++){
		if(hobby[i] != null){
			out.write(hobby[i]);
			if(i != (hobby.length - 1)) out.write(", ");
		}else{
			if(i == 0) out.write(" 입력된 취미 정보가 확인되지 않습니다.");
		}
	}
 
%>



</body>
</html>