<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>MVC 게시판</title>
	<style type="text/css">
		#registForm {
			width: 500px;
			height: 600px;
			border: 1px solid red;
			margin: auto;
		}
		
		h2 {
			text-align: center;
		}
		
		table {
			margin: auto;
			width: 650px;
		}
		
		#tr_top {
			background: orange;
			text-align: center;
		}
		
		#pageList {
			margin: auto;
			width: 500px;
			text-align: center;
		}
		
		#emptyArea {
			margin: auto;
			width: 500px;
			text-align: center;
		}
	</style>
</head>

<body>
	<!-- 게시판 리스트 -->

	<section id="listForm">
	<h2>글 목록<br><a href="boardWriteForm.bo">게시판글쓰기</a></h2>
	<c:choose>
		<c:when test="${ not empty articleList}">
			<table>
				<tr id="tr_top">
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>날짜</td>
					<td>조회수</td>
				</tr>
			
			<c:forEach var="article" items="${articleList}">
				<tr>
					<td>${article.BOARD_NUM}</td>
					<td>
						<c:choose>
							<c:when test="${article.BOARD_RE_LEV ne 0 }">
								<c:forEach var="i" begin="0" end="${article.BOARD_RE_LEV*2}" step="1">&nbsp;</c:forEach>
							</c:when>
							<c:otherwise>  ▶  </c:otherwise>
						</c:choose>
						<a href="boardDetail.bo?board_num=${article.BOARD_NUM}&page=${pageInfo.page}">${article.BOARD_SUBJECT}</a>
					</td>
					<td>${article.BOARD_NAME}</td>
					<td>${article.BOARD_DATE}</td>
					<td>${article.BOARD_READCOUNT}</td>
				</tr>
			</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<section id="emptyArea">등록된 글이 없습니다.</section>
		</c:otherwise>
	</c:choose>
	</section>	
	<br><br>
	
	<section id="pageList">
		<c:choose>
			<c:when test="${pageInfo.page <= 1}">[이전]&nbsp;</c:when>
			<c:otherwise>
				<a href="boardList.bo?page=${pageInfo.page-1}">[이전]</a>&nbsp;
			</c:otherwise>
		</c:choose>
		<c:forEach var="a" begin="${pageInfo.startPage }" end="${pageInfo.endPage }" step="1">
			<c:choose>
				<c:when test="${a == pageInfo.page }"><span style="color:red;font-weight:bolder;">[${a}]</span></c:when>
				<c:otherwise><a href="boardList.bo?page=${a}">[${a}]</a></c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:choose>
			<c:when test="${pageInfo.page== pageInfo.maxPage}">[다음]</c:when>
			<c:otherwise><a href="boardList.bo?page=${pageInfo.page+1}">[다음]</a></c:otherwise>
		</c:choose>
	</section>
</body>
</html>