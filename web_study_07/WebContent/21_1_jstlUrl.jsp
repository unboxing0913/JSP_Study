<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="myurl" value="2" scope="request"/>
<c:if test="${myurl<1}">
	<c:redirect url="http://www.naver.com"/>
</c:if>
<c:if test="${myurl>1}">
	<c:redirect url="http://www.google.com"/>
</c:if>
</body>
</html>