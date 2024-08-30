<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSTL fmt태그</title>
</head>
<body>
    <h3>bundle태그 이용하여 메세지 읽어오기</h3>
    <ol>
        <li>src 디렉토리 안에 하위 디렉토리 생성</li>
        <li>
            하위 디렉토리 안에 확장자가 .properties 파일 생성<br>
            <small style="color: red;">
                (영문을 경우 파일명 뒤에 _en, 한글일 경우 파일명 뒤에 _ko 추가)
            </small><br>

            <small style="color: red;">
                예시: message_ko.properties, message_en.properties
            </small><br>
        </li>
    </ol>

    <pre style="border: 1px solid #555;">
        <h2>bundle 태그 형식</h2>
        <span>- 사용할 리소스 번들을 설정하는 태그</span><hr>
        &lt;fmt:bundle basename="패키지경로포함.파일이름까지(_언어코드.properties는 제외)"&gt;
        &lt;/fmt:bundle &gt;
    </pre>

    <pre style="border: 1px solid #555;">  
        <h2>message 태그 형식</h2>
        <span>- 리소스 번들 안에 존재하며 번들 안의 메세지를 읽어오는 태그</span><hr>
        &lt;fmt:message key="properties 파일 안의 변수 이름" var="메세지를 저장하는 변수 이름" scope="4개영역"/&gt;<br>
    </pre>
    
    <fmt:bundle basename="com.member">
    	<p><fmt:message key="idKey"/>: <fmt:message key="id"/></p>
    	<p><fmt:message key="passwordKey"/>: <fmt:message key="password"/></p>
    	<p><fmt:message key="nameKey"/>: <fmt:message key="name" var="msg"/>${msg}</p>
    </fmt:bundle>
</body>
</html>