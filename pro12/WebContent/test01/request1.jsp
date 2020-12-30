<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setAttribute("name", "이순신");
request.setAttribute("address","서울시 강북구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫번째 JSP</title>
</head>
<body>
<%
RequestDispatcher dispatch = request.getRequestDispatcher("request2.jsp");
dispatch.forward(request,response);
//forward를 사용하기위함 request를 보냄
//forward방식
%>
</body>
</html>