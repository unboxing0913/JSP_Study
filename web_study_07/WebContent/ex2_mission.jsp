<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력 페이지</title>
</head>
<body>
<form action="ex2_missionResult.jsp" method="post">
아이디: <input type="text" name="name"><br>
비밀번호: <input type="password" name="pwd"><br>
<input type="radio" name="user" value="1" checked="checked">사용자<input type="radio" name="user" value="2">관리자<br>
<input type="submit" value="로그인">

</form>
</body>
</html>