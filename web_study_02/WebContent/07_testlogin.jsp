<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %> <%-- URL인코더 임포트 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 인증 페이지</title>
</head>
<body>
<%
String id="hong";
String pwd="1234";
String name="홍길동";
request.setCharacterEncoding("UTF-8");

request.getParameter("id");
request.getParameter("pwd");

if(id.equals(request.getParameter("id"))&&pwd.equals(request.getParameter("pwd"))){
	//response.sendRedirect("08_main.jsp"); name의 값이 null
    response.sendRedirect("08_main.jsp?name="+URLEncoder.encode(name,"UTF-8"));
    //name의 값을 직접 넘겨 준뒤 다시 전송하기위해 (공백으로 인한 오류발생 조심)
}else{
	response.sendRedirect("06_loginFrom.html");
}


%>
</body>
</html>