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
String id=(String)request.getAttribute("id");
String name=(String)request.getAttribute("name");
%>

forwardTo_eun.jsp페이지 입니다.<br>
forwardTo_eun.jsp페이지는 포워딩 페이지로<br>
forwardFrom_eun.jsp페이지와 같은 request객체를 공유한다 !<br>
이메일 : <b><%=id%></b><br>
이름:<b><%=name%></b>
</body>
</html>