<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
 String name = request.getParameter("name");
 String imgName = request.getParameter("imgName");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>이름은 <%=name%>입니다</h1><br><br>
<img src="./image/<%=imgName%>"> <!-- 경로설정 중요함 -->

</body>
</html>