<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- url ?파라미터=값 으로 주소창에서 값을줄수있음 -->
자바 코드<hr>
==연산자 사용 결과:<%= request.getParameter("id")=="pinksung" %><br>
equals()사용 결과:
<%= request.getParameter("id").equals("pinksung") %> <br>
</body>
</html>