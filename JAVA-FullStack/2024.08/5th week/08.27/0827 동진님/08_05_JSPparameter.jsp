<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.Enumeration" %>
<%@ page import = "java.util.Map" %>
<%
// request의 데이터 영역에 저장된 데이터의 인코딩만 설정할 때 사용함. 
// get방식은 인코딩이 안됨 get방식에 따라 웹페이지의 인코딩이나 브라우저의 인코딩으로 시작함. 
	request.setCharacterEncoding("utf-8");


%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inser 폼생성</title>
</head>
<body>

 <h1>객체=의 파라미터를 가져오는 메서드의 종류 </h1>
	<b>requst.getParameter():</b> 한개의 인자값만을 가져오는 경우 사용한다.  
	
	name 파라미터 <%=request.getParameter("name") %>
	name 파라미터 <%=request.getParameter("address") %>
	
	<br>
	<br>
	<b>requst.getParameterValues():</b> 여러 개개의 인자값만을 가져오는 경우 사용한다. 
	<p>해당 속성값을 배열로 받아서 반복문으로 하는 방식 
	<%
	String[] value = request.getParameterValues("pet");
	if(value != null ){
		for(int i = 0; i < value.length; i++){
			out.println(value[i]);
		}
	}
	%>
	<hr><br>
	<b>request.getParameterName() : </b> 인자값에 매칭되어 있는 name 속성값을 가져온다. 동일한 속성명은 1개만 가져온다..
	이름들을 가져오는것입니다.  
	
	<%
		int i = 0 ;
		Enumeration<String> PE = request.getParameterNames();// "name" "address" "pet"
		while(PE.hasMoreElements()){ // hasMoreElement 다음의 요소를 가져올게 있니? 
			i++;
			String name = PE.nextElement();
			out.println("폼 요소의 name 속성명 : [" +i+" 번]" +name );
		}
	%>	


</body>
</html>