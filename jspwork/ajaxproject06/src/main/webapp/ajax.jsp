<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.js"></script>
	<title>Insert title here</title>
	<style>
		table, th, td { border: 1px solid #000; }
	</style>
	<script>
		$(function () {
			$("button").click(function () {
				$.ajax({
					url: "ajaxCon",
					type: "get",
					// async: false,
					success: function (data) {
						$("#divBox").empty();

						let str = "<table>";
						str += '<tr><th>아이디</th><th>이름</th><th>주소</th><th>성별</th></tr>';

						$.each(data, function (i, v) {
							str += '<tr><th>' + v.id + '</th><th>' + v.name + '</th><th>' + v.address + '</th><th>' + v.gender + '</th></tr>';
						});
						str += '</table>';

						$("#divBox").append(str);
						alert('완성');
					},
					error: function () { alert('error'); }
				});

				console.log('추가');
				let str = "<p>데이터 추가하기</p>";
				$("#ConBox").html(str);
			});
		});
	</script>
</head>
<body>
	<button type="button">확인</button><br><br>
	<div id="divBox"></div><br><br>
	<div id="ConBox"></div>
</body>
</html>