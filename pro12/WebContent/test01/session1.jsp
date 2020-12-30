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
String name = (String)session.getAttribute("name"); //반환하는타입 Object
session.setAttribute("address","서울시 노원구");
%>
이름 : <%=name%> 입니다<br>
<a href="session2.jsp">두번째 페이지로 이동</a>
 <!--  세션 객체는 브라우저가 사라지지않는한 계속 유효하다브라우저가 (크롬->익스플로)바뀌었을경우 사라짐 -->
</body>
</html>