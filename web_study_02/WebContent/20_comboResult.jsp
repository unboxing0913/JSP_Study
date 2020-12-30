<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 페이지</title>
</head>
<body>
<%
 	
	String result = request.getParameter("url");
	if(result.equals("http://www.google.com")){
		response.sendRedirect("http://www.google.com");
	}else if(result.equals("http://www.naver.com")){
		response.sendRedirect("http://www.naver.com");
	}else{
		response.sendRedirect("http://www.daum.net");
	}
 

%>
</body>
</html>