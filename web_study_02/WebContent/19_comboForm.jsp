<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>콤보 양식 페이지</title>
</head>
<body>
<h3>검색 엔진을 선택하세요.</h3>
<form  action="20_comboResult.jsp" method="post">
<select name="url">
	<option value="http://www.google.com">구글</option>
	<option value="http://www.naver.com">네이버</option>
	<option value="http://www.daum.net">다음</option>
</select>
<input type="submit" value="확인">
</form>
</body>
</html>