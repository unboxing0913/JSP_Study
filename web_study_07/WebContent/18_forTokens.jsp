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
<%--delimiter(구분자) java의 Tokenizer와 비슷--%>
<!-- delims를 기준으로 구분해준다. -->
<c:forTokens var="city" items="서울.인천,대구.부산" delims=",">
	${city} <br>
</c:forTokens>
<c:forTokens var="city" items="서울.인천,대구.부산" delims=",.">
	${city} <br>
</c:forTokens>
</body>
</html>