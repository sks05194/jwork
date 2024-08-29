<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="java.util.*, java.io.*, java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>
	<%
	// 현재 파일 위치의 상대경로 지정가능
	// String savePath = application.getRealPath("파일을 저장할 폴더");
	// String savePath = application.getRealPath("\product");
	String fileUploadPath = "C:\\uploadts";
	
	// 파일 업로드를 위해 객체 생성
	@SuppressWarnings("deprecation")
	DiskFileUpload upload = new DiskFileUpload();
	
	// 파일최대크기 용량제한. 최대로 업로드 할 수 있는 파일의 크기를 바이트 단위로 지정
	// upload.setSizeMax(2 * 1024 * 1024); // 2MB정도 = 1 * 1024 * 1024
	
	// 홈페이지에서 전송된 요청 파라미터를 가져오기
	@SuppressWarnings("deprecation")
	List<FileItem> items = upload.parseRequest(request);
	// 요청 파라미터를 모아놓은 items 배열객체를 가져오기 쉽게 iterator 객체로 변환함.
	Iterator<FileItem> params = items.iterator();
	
	while (params.hasNext()) {
		FileItem fileItem = params.next();
		if (fileItem.isFormField()) {
			// 필드 이름 = 파라미터명 = 속성명
			String name = fileItem.getFieldName();
			
			// 필드 값, 한글 인코딩 = 파라미터 값 = 속성값
			String value = new String(fileItem.getString().getBytes("8859_1"), "utf-8");
			out.print(name + ": " + value + "<br>");
		} else {
			String fileName = fileItem.getName();
			out.print("originfileName: " + fileName + "<br>");
			fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
			File file = new File(fileUploadPath + "/" + fileName);
			String orginName = fileName;
			
			// 동일한 파일명이 존재하는 경우 파일명 변경하기
			// => 동일한 파일이 존재하는 경우 새이름 생성하는 로직이 없으면 에러 발생
			if (file.exists()) {
				long tsl = System.currentTimeMillis();
				fileName = tsl + fileName.substring(fileName.lastIndexOf("."));
				file = new File(fileUploadPath + "/" + fileName);
			}
			out.print("newfileName: " + fileName + "<br>");
			
			// 파일이 실제로 업로드되는 시점
			fileItem.write(file);
		}
	}
	%>
</body>
</html>