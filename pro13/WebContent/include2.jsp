<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
안녕하세요. 쇼핑몰 DUKE 시작입니다.!!!<br>
<br>
<jsp:include page="duke_image.jsp" flush="true">
	<jsp:param value="듀크2" name="name"/>
	<jsp:param value="duke2.png" name="imgName"/>
</jsp:include>
<br>
안녕하세요. 쇼핑몰 DUKE 끝 부분입니다.!!!<br>
</body>
</html>