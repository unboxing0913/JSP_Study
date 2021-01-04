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
<c:set var="msg" value="Hello"/> <!-- 변수저장 (value에 넣는방식)-->
\${msg}=${msg}<hr>

<c:set var="age"> <!-- 변수저장(태그로 넣는방식) -->
30
</c:set>
\${age}=${age}<hr>

<!-- 객체생성후 객체에 값 저장 --><!-- scope 생략가능 기본값은 page -->
<c:set var="member" value="<%=new com.saeyan.javabeans.MemberBean()%>" scope="page"></c:set>
<c:set target="${member}" property="name" value="홍길동"/>
<c:set target="${member}" property="userid">honggildong</c:set>
\${member} = ${member}<hr>

<!-- 값을주며 연산,조건 가능 -->
<c:set var="add" value="${10+5}"></c:set>
\${add}=${add}<br>
<c:set var="flag" value="${10>5}"/>
\${flag}=${flag}<br>
</body>
</html>
<%--
request.setAttribute("msg2","Hello2")
==><c:set var="mag2" value="Hello2" scope="request"/>
 --%>
