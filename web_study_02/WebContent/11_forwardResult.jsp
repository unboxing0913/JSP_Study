<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//넘어온 값을 받음
String age = request.getParameter("age");
String name = (String)request.getAttribute("name"); //Object타입으로 넘어옴으로 강제타입변환 필요
// name은  setAttribute( ) 메소드를 사용해 보낸값
%>
forward 방식으로 이동된 페이지<p>
나이 : <%=age%><p>
이름 : <%=name%>
</body>
</html>