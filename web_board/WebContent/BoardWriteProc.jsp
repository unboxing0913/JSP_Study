<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.BoardDAO" %>
<%@ page import="model.BoardBean" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="boardbean" class="model.BoardBean">
	<jsp:setProperty name="boardbean" property="*"/>
</jsp:useBean>
<%

BoardDAO bdao= new BoardDAO();
bdao.insertBoard(boardbean);

%>


</body>
</html>