<%@page import="com.javalec.ex.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("Utf-8");

String id=request.getParameter("id");
String pw=request.getParameter("pw");

MemberDao dao=MemberDao.getInstance();
int checkNum = dao.userCheck(id,pw);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>