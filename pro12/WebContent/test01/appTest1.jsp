<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 스코프 테스트1</title>
</head>
<body>
<%
session.setAttribute("name","이순신");
application.setAttribute("address","서울 노원구");
%>
</body>
<h1>이름과 주소를 저장 합니다.</h1>
<a href="appTest2.jsp">두번째 웹 페이지로 이동</a>
<!-- 어플리케이션은 유효범위가 내 응용프로그램(서버)이 완전이 종료될때까지 -->
</html>