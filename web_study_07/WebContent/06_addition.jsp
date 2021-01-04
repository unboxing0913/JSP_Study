<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--scriptlet --%>
<%
String str1 = request.getParameter("num1");
String str2 = request.getParameter("num2");
int num1 = Integer.parseInt(str1); 
int num2 = Integer.parseInt(str2); 
%>

<%--10+20=30:expression --%>
<%=num1%>+<%=num2%>=<%=num1+num2%><br>

EL 방식 : ${param.num1}+${param.num2}=${param.num1+param.num2}<br>
문자열로 출력 : ${param.num1}${param.num2}

</body>
</html>