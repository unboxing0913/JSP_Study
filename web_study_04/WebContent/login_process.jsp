<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.saeyan.javabeans.MemberBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("id");
String password = request.getParameter("password");

MemberBean m = new MemberBean();
m.setUserid("edukms");
m.setPwd("1234");

if(id.equals(m.getUserid()) && password.equals(m.getPwd())){
	out.print(m.getUserid()+"님 반갑습니다.");
}else{
	out.print("회원 정보가 존재하지 않습니다.");
}

%>
</body>
</html>