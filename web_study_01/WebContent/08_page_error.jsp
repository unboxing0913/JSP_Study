<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="09_error.jsp" %>  <%--예외발생시 예외페이지로 이동하게끔 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
숫자를 0으로 나누는 것은 오류입니다.
<%--강제로 예외를 발생시킴 --%>
<%=25/0%>

</body>
</html>