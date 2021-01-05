<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 페이지</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8");%>
<c:if test="${param.user == 1}">
${param.name}님 사용자로 로그인 하셨습니다.
</c:if>
<c:if test="${param.user == 2}">
${param.name}님 관리자로 로그인 하셨습니다.

<hr>
<!-- 다른방법 -->
<!-- if else 문 -->
<c:choose> 
	<c:when test="${param.user == 1}">
		${param.name}님 사용자로 로그인 하셨습니다.
	</c:when>
	<c:otherwise>
		${param.name}님 관리자로 로그인 하셨습니다.
	</c:otherwise>
</c:choose>
</c:if>
</body>
</html>