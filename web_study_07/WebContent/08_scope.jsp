<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("name","page man");
request.setAttribute("name", "request man");
session.setAttribute("name","session man");
application.setAttribute("name","application");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
name : ${name}<br>
<%--내장 객체를 명시하지 않으면 가장 협소한 범위 내에서 사용가능한 pageScope에서 부터 찾아온다. --%>
page 속성 :${pageScope.name}<br>
request 속성 :${requestScope.name}<br>
session 속성 :${sessionScope.name}<br>
application 속성 :${applicationScope.name}<br>
</body>
</html>