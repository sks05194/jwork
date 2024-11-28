<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
<h1>Ajax Home</h1>
	<form>
		boardNo : <input type="text" name="boardNo" id="boardNo"/><br>
		title : <input type="text" name="title" id="title"/><br>
		content : <input type="text" name="content" id="content"/><br>
		writer : <input type="text" name="writer" id="writer"/><br>
	</form>
	<div>
		<button id="listBtn">List</button>
		<button id="readBtn">Read</button>
		<button id="registerBtn">Register</button>
		<button id="deleteBtn">Delete</button>
		<button id="modifyBtn">Modify</button>
	</div>
	<div id="dataBox"></div>
<script>
$(document).ready(function(){
	$("#listBtn").on("click", function(){
		$.get("/boards", {id : "admin"} ,function(data){
			console.log(data);
// 			alert(JSON.stringify(data));
			$("#dataBox").empty();
			if(data!= '') {
				$.each(data,function(i,v){
					$("#dataBox").append("번호: "+v.boardNo+"/ 제목: "+v.title+"/ 저자: "+v.writer+"/ 출판일: "+v.regDate.substr(0,10)+"/ 내용: "+v.content+"<br>");
				});
			}
		});
	});
	
	$("#readBtn").on("click", function(){
		let boardNoVal = $("#boardNo").val();
		if(boardNoVal == '' || boardNoVal == null || boardNoVal == undefined ){
			alert("글 번호를 입력해주세요.");
			return;
		}else{	
			$.get("/boards/"+boardNoVal, function(data){
				console.log(data);
				$("#dataBox").empty();
				if(data!= '') {
					$("#dataBox").append("번호: "+data.boardNo+"/ 제목: "+data.title+"/ 저자: "+data.writer+"/ 출판일: "+data.regDate.substr(0,10)+"/ 내용: "+data.content+"<br>");
					$("#boardNo").val(data.boardNo);
					$("#title").val(data.title);
					$("#content").val(data.content);
					$("#writer").val(data.writer);
				}
			});
		}
	});
	
	$("#registerBtn").on("click", function(){
		let boardObject = {
			boardNo : $("#boardNo").val(),
			title: $("#title").val(),
			content : $("#content").val(),
			writer : $("#writer").val()
		};
		
		//JSON.stringify( )는 자바스크립트의 값을 JSON 문자열로 변환함.
		$.post({url: "/boards", data: JSON.stringify(boardObject), contentType: "application/json; charset=UTF-8"}).done( function(result){
				console.log(result);
				if(result != '') alert('글 등록이 완료 되었습니다.');
				location.reload();
				
		});
		
// 		$.ajax({
// 			type : "POST",
// 			url : "/boards",
// 			data : JSON.stringify(boardObject),
// 			contentType : "application/json; charset=UTF-8",
// 			success : function(result){
// 				console.log(result);
// 				alert(result);
// 			},
// 			error : function(request, status, error){
// 				alert("code: "+request.status + "\n"
// 				+ "message: "+request.responseText + "\n"
// 				+ "error: "+error);
// 			}
// 		});
	});
	
	$("#deleteBtn").on("click", function(){
		let boardNo =  $("#boardNo").val();
		$.ajax({
			type : "DELETE",
			url : "/boards/"+boardNo,
			data : JSON.stringify(boardNo),
			contentType : "application/json; charset=UTF-8",
			success : function(result){
				console.log(result);
				alert(result);
				$("#dataBox").empty();
				$("#boardNo").val("");
				$("#title").val("");
				$("#content").val("");
				$("#writer").val("");
			}
		});
	});
	
	
	$("#modifyBtn").on("click", function(){
		let boardNo =  $("#boardNo").val();
		let boardObject = {
			title: $("#title").val(),
			content : $("#content").val(),
			writer : $("#writer").val()
		};
		
		$.ajax({
			type : "PUT",
			url : "/boards/"+boardNo,
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=UTF-8",
			success : function(result){
				console.log(result);
				alert(result);
				$("#dataBox").empty();
			}
		});
	});
});
</script>
</body>
</html>