<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재요청</title>
</head>
<body>
구글 홈페이지로 이동
<%
response.sendRedirect("http://www.google.com"); //서버가 클라이언트에 재요청하는 메소드
%>
</body>
</html>