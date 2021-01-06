<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%
request.setCharacterEncoding("utf-8");
%>  --%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--<c:choose><c:when><c:otherwise> --%>
<!-- 바로 전 페이지로 이동해 text박스에 원래있던값이 위치하게함 -->
<fmt:requestEncoding value="utf-8"/>       
<!-- empty : 객체에 값이 비어있냐 ? t/f -->
<c:choose>
	<c:when test="${empty param.id}">
			아이디를 입력하세요.<br>
			<a href="#" onclick="history.go(-1)">다시입력</a>
	</c:when>
	<c:when test="${param.pwd eq ''}">
			비밀번호를 입력하세요.<br>		
			<a href="#" onclick="history.go(-1)">다시입력</a>
	</c:when>
	<c:otherwise>
			<h2>${param.id }님 환영합니다!</h2>
	</c:otherwise>
</c:choose>

<%-- <!-- empty : 객체가 있냐 없냐 -->          
//선생님방식 session에 객체를저장해둔뒤 text박스에 넣어줌 이후 다시입력버튼이 작동하지않는 문제발생
<c:choose>
	<c:when test="${empty param.id }">
		아이디를 입력하세요.<br>
		<a href="login.jsp">로그인 창</a>
	</c:when>	
	<c:when test="${empty param.pwd }">
		<%session.setAttribute("id",request.getParameter("id")); %>
		비밀번호를 입력하세요.<br>
		<a href="login.jsp">로그인 창</a>
	</c:when>
	<c:otherwise>
		<h2>${param.id }님 환영합니다!</h2>
	</c:otherwise>
</c:choose> --%>
</body>
</html>