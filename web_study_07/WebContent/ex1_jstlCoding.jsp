<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	java.util.List<String> seasonList = new java.util.ArrayList<String>();
	seasonList.add("봄");
	seasonList.add("여름");
	seasonList.add("가을");
	seasonList.add("겨울");
	request.setAttribute("list",seasonList);
%>

<!-- 스트립트릿 코드 -->
<select name="season">
<% java.util.ArrayList<String> list = (java.util.ArrayList<String>)request.getAttribute("list");
for(int i=0;i<list.size();i++){
%>
<option value="<%=list.get(i)%>"><%=list.get(i)%></option>
<%}%>
</select> 


<!-- jstl 코드 -->
<select name="season">
<c:forEach var="item" items="${list}" varStatus="status">
	<option value="${item}">${item}</option>
</c:forEach>
</select>




</body>
</html>