<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조건문 적용</title>
</head>
<body>
<c:if test="${param.color==1}">
	<span style="color:red;">빨강</span>
</c:if> 

<c:if test="${param.color==2}">
	<span style="color:green;">초록</span>
</c:if>
<c:if test="${param.color==3}">
	<span style="color:blue;">파랑</span>
</c:if>


<%-- <%
String c = request.getParameter("color");
int color = Integer.parseInt(c);
if(color==1){
%>
<span style="color:red;">빨강</span>
<%}else if(color==2){%>
<span style="color:green;">초록</span>	
<%}else{%>
<span style="color:blue;">파랑</span>
<%} %> --%>        <%-- 스파게티코드 --%>


</body>
</html>