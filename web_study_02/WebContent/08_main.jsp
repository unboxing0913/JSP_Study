<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body> <!-- 다른페이지의 jsp 데이터를 연결후 가져오는 방법 -->
<%=request.getParameter("name") %>님 안녕하세요 !<br>
저희 홈페이지에 방문해 주셔서 감사합니다.<br>
즐거운 시간 되세요~~<br>
</body>
</html>