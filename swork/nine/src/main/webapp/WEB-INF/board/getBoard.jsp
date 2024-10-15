<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<body>
<style>
	#imgBox {display:none;position:absolute;top:0;left:0;height:100vh!important;background-color:rgba(0,0,0,0.5);z-index:9999999;}
	#imgContentBox {width:600px;max-height:550px;overflow:auto;position:absolute;top:30%;left:30%;border-radius:5px;z-index:9999999;}
	#imgBoxTitleBar {border-bottom:1px solid #777;border-radius:5px 5px 0 0;background-color:#ddd;width:100%;padding:10px;text-align:right;font-size:20px;font-weight:bolder;}
	#imgBoxImg {width:100%;border-radius: 0 0 5px 5px;}
	#closeX {padding:5px 20px;border-radius:5px;border:1px solid #777;background-color:red;color:#fff;}
	#closeX:hover {background-color:#777;cursor:pointer;}
</style>
<div class="jumbotron">
   <h1>상세 보기</h1>      
</div>
<div class="container-fluid">
<%
	if (request.getParameter("error")!=null) {
		out.println("<div class='alert alert-danger'>");
		out.println("해당 글은 작성자만이 수정할 수 있습니다.");
		out.println("</div>");
	}
%>
  <form name="fm" action="updateBoard.do" method="post">
  <input type="hidden" name="seq" value="${board.seq}">
    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text">제목</span>
      </div>
      <input type="text" class="form-control innm" name="title" value="${board.title}" >      
    </div>
    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text">작성자</span>
      </div>
      <input type="text" class="form-control innm" value="${board.writer}" readonly >      
    </div>
    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text">내용</span>
      </div>
      <textarea class="form-control innm" rows="10" id="comment" name="content">${board.content}</textarea>      
    </div>  
    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text">파일</span>
        <input type="hidden" name="filename" value="${board.filename }">
      </div>
   		<c:if test="${board.filename ne NULL}">
   			<span style="cursor:pointer;padding:0 20px;" onclick="seeImg()">[파일보기]</span>
   			<script>
	        	function seeImg(){
	        		$("#imgBox").show();
	        	}
	        </script>
   			<span style="cursor:pointer;" onclick="downloadFile('${board.filename}')">[파일다운]</span>
   			<script>
	   			function downloadFile(filename){
	   			    window.location ='download.do?filename='+filename;
	   			}
			</script>
   		</c:if>
    </div>
    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text">등록일</span>
      </div>
      <input type="text" class="form-control innm" name="regDate" value="${board.regdate}" readonly >      
    </div>
    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text">조회수</span>
      </div>
      <input type="text" class="form-control innm" name="cnt" value="${board.cnt}" readonly>      
    </div>
    <div id="footer">
	  	<button id="conList" type="button" class="btn btn-primary">글목록</button>
	</div>
  </form>  
</div>
<!-- 클릭시 보이는 이미지 start -->
<div id="imgBox" class="container-fluid">
	<div id="imgContentBox">
		<div id="imgBoxTitleBar">
			<span id="closeX" onclick="closeX()">X</span>
			 <script>
        	function closeX(){
        		$("#imgBox").hide();
        	}
        </script>
		</div>
		<img id="imgBoxImg" src="img/${board.filename}">
	</div>
</div>
<!-- 클릭시 보이는 이미지 end -->
</body>
</html>
