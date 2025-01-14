<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../header.jsp" %>
<style>
#searchNav{-webkit-justify-content: flex-end; justify-content: flex-end; }
.navbar {padding: 10px 0px !important;}
.pagination {justify-content : center;}
</style>
<body>
<div class="jumbotron">
   <h1>공지 사항 ${userRole }</h1>      
</div>
<%@ include file="../../menu.jsp" %>
<div class="container">
	<nav id="searchNav" class="navbar navbar-expand-sm navbar-dark">
		<form class="form-inline" action="getBoardList.do" method="get">
			<select class="form-control" id="sel1" name="searchCondition" style="display:inline-block!important;margin-right:10px;">
				<c:forEach items="${conditionMap}" var="option">
					<option value="${option.value}">${option.key}</option>
				</c:forEach>
			</select>
			
			<div class="input-group mb-3">
				<input class="form-control mr-sm-2" type="text" name="searchKeyword" placeholder="검색어를 입력하세요.">
				<div class="input-group-append">
					<button class="btn btn-success" type="submit">검색</button>
				</div>
				<div class="input-group-append">
					<button type="button" id="conWrite" class="btn btn-outline-primary">글쓰기</button>
				</div>
			</div>
			
			
		</form>
	</nav>
	
	<table class="table table-hover">
		<thead class="btn-primary">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boardList}" var="board">
				<tr onclick="selTr(${board.seq})" style="cursor:pointer;">
<!-- 				<tr style="cursor:pointer;"> -->
					<td class="tdCenter"><a href="getBoard/${board.seq}">${board.seq}</a></td>
					<td>${board.title}</td>
					<td class="tdCenter">${board.writer}</td>
					<td class="tdCenter">${board.regdate}</td>
					<td class="tdCenter">${board.cnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
  
	<ul class="pagination">
		<c:if test="${paging.nowPage > 1 && paging.lastBtn > paging.viewBtnCnt}">
			<li class="page-item"><a class="page-link" href="getBoardList.do?nowPage=${paging.nowPage-1}">이전</a></li>
		</c:if>
		<c:forEach var="i" begin="${paging.startBtn}" end="${paging.endBtn}" step="1">
			<c:choose>
				<c:when test="${paging.nowPage==i}"><li class="page-item active"><a class="page-link" >${i}</a></li></c:when>
				<c:otherwise><li class="page-item"><a class="page-link" href="getBoardList.do?nowPage=${i}">${i}</a></li></c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.nowPage < paging.lastBtn  && paging.lastBtn > paging.viewBtnCnt}">
			<li class="page-item"><a class="page-link" href="getBoardList.do?nowPage=${paging.nowPage+1}">이후</a></li>
		</c:if>
	</ul>
  
	<br><br>

</div>

</body>
</html>
