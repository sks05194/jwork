<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Internationalization</title>
</head>
<body>
    <p><jsp:useBean id="now" class="java.util.Date" /></p>
    <p>date: <fmt:formatDate value="${now}" type="date" /></p>
    <p>time: <fmt:formatDate value="${now}" type="time" /></p>
    <p>both: <fmt:formatDate value="${now}" type="both" /></p>

    <p>short:
        <fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short" />
    </p>

    <p>default:
        <fmt:formatDate value="${now}" type="both" dateStyle="default" timeStyle="default" />
    </p>
    <p>medium:
        <fmt:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="medium" />
    </p><hr>

    <p>long:
        <fmt:formatDate value="${now}" type="both" dateStyle="long" timeStyle="long" />
    </p>
    <p>full:
        <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" />
    </p>
    <p>pattern:
        <fmt:formatDate value="${now}" type="both" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초 E요일" />
    </p>
    <p>pattern:
        <fmt:formatDate value="${now}" type="both" pattern="yyyy-MM-dd HH:mm:ss E요일" />
    </p>
    <p>**formatDate의 pattern은 SimpleDateFormat과 동일함.</p>
</body>
</html>