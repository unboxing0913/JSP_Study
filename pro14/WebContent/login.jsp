<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="result.jsp" method="post">
<!-- id값이 존재하면 세션에 저장  / 로그인창으로 복귀했을때 세션에 저장된 id값 출력 -->
<%-- 아이디 : <input type="text" name="id" value="<%if(session.getAttribute("id")!=null)
		out.println(session.getAttribute("id"));%>" >   선생님 방식 --%>
아이디:<input type="text" name="id"><br> 
비밀번호:<input type="password" name="pwd"><br>
<input type="submit" value="로그인">
<input type="reset" value="다시입력">
</form>
</body>
</html>