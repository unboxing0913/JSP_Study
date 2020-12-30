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
String name= (String)session.getAttribute("name");
String address= (String)session.getAttribute("address");
%>
이름은 <%=name%> 입니다.<br>
주소는 <%=address%> 입니다.
 <!--  세션 객체는 브라우저가 사라지지않는한 계속 유효하다 -->
</body>
</html>