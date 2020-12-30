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
<!-- https://blog.naver.com/mwpte_evil/221383200026 include,flush 설명 -->
<!-- flush:버퍼(데이터를일시적으로 보관하는장소)의 용량이 꽉차면 자동으로 비워라 t/f -->
<jsp:include page="duke_image.jsp" flush="true">
	<jsp:param value="듀크" name="name"/>
	<jsp:param value="duke.png" name="imgName"/>
</jsp:include>
<br>
안녕하세요. 쇼핑몰 DUKE 끝 부분입니다.!!!<br>
</body>
</html>