<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 출력창</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String age = request.getParameter("age");
%>

<% //if(name != null || name.length() != 0){
   //if(name != null && name.length() != 0){
   //if(!name.equals("") && name.length() != 0){
	 if(!name.contains(" ") && name.length() != 0){
     //공백처리를 하기위해 conains()을 사용 : 포함된문자 검색
%>
<h1><%=name%>,<%=age%></h1>
<%
}else{
%>
<h1>이름을 입력하세요</h1>
<%
}
%>


<%--out객체를 이용한 같은방법으로 출력시키기 --%>
<%
if(!name.contains(" ") && name.length() != 0){
%>
<h1><%out.println(name+","+age);%></h1>
<%
}else{
%>
<h1>이름을 입력하세요</h1>
<%
}
%>
</body>
</html>