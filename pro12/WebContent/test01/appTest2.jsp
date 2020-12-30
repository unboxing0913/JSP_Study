<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 스코프 테스트2</title>
</head>
<body>
<%
String name = (String)session.getAttribute("name");
String address = (String)application.getAttribute("address");
%>
<h1>이름은 <%=name%> 입니다.</h1><br/>
<h1>주소는 <%=address%> 입니다.</h1>
<!-- 어플리케이션은 유효범위가 내 응용프로그램(서버)이 완전이 종료될때까지 -->
</body>
</html>