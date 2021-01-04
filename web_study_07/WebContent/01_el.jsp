<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
EL(Expression Language): JSP출력에 대한 부분을 쉽게 하기 위해 개발한 태그<br>
<%="Hello" %><br><!-- 표현식(Expression) -->
<% out.println("Hello"); %> <br><!-- 스트립트릿(scriptlet) -->
${"Hello"} <!-- EL -->
</body>
</html>