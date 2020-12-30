<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = (String)request.getAttribute("name");
String address = (String)request.getAttribute("address");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두번째 JSP/title></title>
</head>
<body>

<h1>이름은 <%=name%> 입니다.</h1><br/>
<h1>주소는 <%=address%> 입니다.</h1>
<!-- request 객체의 유효범위는 요청에 대한 응답이 완료될때까지  -->
</body>
</html>
