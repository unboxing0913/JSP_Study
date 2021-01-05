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
<%
String[] movieList={"타이타닉","시네마 천국","혹성 탈출","킹콩"};
pageContext.setAttribute("movieList",movieList);//접점
%>
<ul>
<c:forEach var="movie" items="${movieList}" varStatus="status">
<c:choose>
	<c:when test="${status.first}"> <!-- first:현재루프가 처음인가? t/f -->
		<li style="font-weight:bold;color:red;">${movie}</li>
	</c:when>
	<c:otherwise>
		<li>${movie}</li>
	</c:otherwise>
</c:choose>
</c:forEach>
</ul>
<c:forEach var="movie" items="${movieList}" varStatus="status">
	${movie}
	<c:if test="${not status.last}">,</c:if> <!-- last:현재루프가 마지막인가? t/f -->
</c:forEach>

</body>
</html>