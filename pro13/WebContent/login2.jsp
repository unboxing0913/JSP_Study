<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String msg=request.getParameter("msg"); //로그인창->결과창->로그인창
if(msg!=null){
%>
<h2><%=msg %></h2> <!-- 첫화면에선 null 이후 전송되서 다시 값을가져오며 값출력 -->
<%
}
%>
<form action="result2.jsp" method="post">
아이디 : <input type="text" name="userID"><br>
비밀번호 : <input type="password" name="userPw"><br>
<input type="submit" value="로그인">
<input type="reset" value="다시입력">
</form>
</body>
</html>