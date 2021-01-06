<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 선행조건 (now변수의 value값 (Date) 정의)-->
<c:set var="now" value="<%=new java.util.Date() %>"></c:set>
\${now } : ${now }
<hr>

<!-- 날짜를 2020.01.06와 같은 형태로 출력하고자 할 경우 사용됨. -->
<!-- value속성에 date를 넣어 처리하기위해서는 java.util.Date클래스로 객체생성하는 것이 필수적 -->
<fmt:formatDate value="${now }"/><br>

<!-- type : 형식화할 데이터 타입 (date:날짜,time:시간,both:모두) -->
date : <fmt:formatDate value="${now }" type="date"/><br>
time : <fmt:formatDate value="${now }" type="time"/><br>
both : <fmt:formatDate value="${now }" type="both"/>
<hr>

<!-- dataStyle,timeStyle의 날짜,시간 형식 4가지 (생략시 default) short|medium|log|full  -->
default : <fmt:formatDate value="${now }" type="both" dateStyle="default" timeStyle="default"/><br>
short : <fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="short"/><br>
medium : <fmt:formatDate value="${now }" type="both" dateStyle="medium" timeStyle="medium"/><br>
long :  <fmt:formatDate value="${now }" type="both" dateStyle="long" timeStyle="long"/><br>
full : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
<hr>
<!-- pattern으로 사용자 지정형식 만들어줌  -->
pattern="YYYY년 MM월 dd일 hh시 mm분 ss초": <fmt:formatDate value="${now }" pattern="YYYY년 MM월 dd일 hh시 mm분 ss초"/>
</body>
</html>