<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
입력한 정보는 아래와 같습니다.<br>
ID : <%=request.getParameter("id") %><p/>
Password : <%=request.getParameter("pwd") %><p/>
자기 소개 : <%=request.getParameter("contents") %><p/>
</body>
</html>