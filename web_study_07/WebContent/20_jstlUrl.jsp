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
<%--반복 사용 --%>
<c:url value="images/pic.jpg" var="data"></c:url>
<h3>${data}</h3>
<img src="${data}" width="150" height="150">
<img src="${data}" width="250" height="250">

</body>
</html>