<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:requestEncoding value="utf-8"/>
<c:set var="dan" value="${param.dan }"/>
<table border="1" width="800" align="center">
	<tr align="center">
		<td colspan="2">${dan }단 출력</td>
	</tr>
	<c:forEach var="cnt" begin="1" end="9" step="1" varStatus="status" >
	<tr align="center">	
		<td width="400"><c:out value="${dan }"/>*<c:out value="${cnt }"/></td>
		<td width="400"><c:out value="${dan*cnt }"/></td>	
	</tr>
	</c:forEach>
</table>
</body>
</html>