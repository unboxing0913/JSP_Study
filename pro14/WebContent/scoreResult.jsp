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
	<!-- set으로 변수를 만들어줘야 (&&,||)조건식을 사용가능 -->
	<c:set var="score" value="${param.score }"/>
  <c:choose>	
  		<c:when test="${score<=100 && score>=0 }">
	<c:choose>				
		<c:when test="${score >= 90}">
			<h2>시험점수 ${score }</h2>
			<h2>A학점입니다.</h2>
			<a href="#" onclick="history.go(-1)">다시입력</a>
		</c:when>
		<c:when test="${score >= 80}">
			<h2>시험점수 ${score }</h2>
			<h2>B학점입니다.</h2>
			<a href="#" onclick="history.go(-1)">다시입력</a>
		</c:when>
		<c:when test="${score >= 70}">
			<h2>시험점수 ${score }</h2>
			<h2>C학점입니다.</h2>
			<a href="#" onclick="history.go(-1)">다시입력</a>
		</c:when>
		<c:when test="${score <= 60}">
			<h2>시험점수 ${score }</h2>
			<h2>D학점입니다.</h2>
			<a href="#" onclick="history.go(-1)">다시입력</a>
		</c:when>
	</c:choose>			
   	</c:when>
   	<c:otherwise>
   		<h2>시험점수 ${score }</h2>
			<h2>100보다 크거나 0보다 작습니다. 다시 입력 하세요</h2>
			<a href="#" onclick="history.go(-1)">다시입력</a>
   	</c:otherwise>
  </c:choose>	
</body>
</html>