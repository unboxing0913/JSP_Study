<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="item" class="com.mission.javabeans.ItemBean"></jsp:useBean>
<jsp:setProperty property="*" name="item"/>
<h2>입력 완료된 정보</h2>
<table>
<tr>
<td>상품명</td><td><jsp:getProperty property="name" name="item"/></td>
</tr>
<tr>
<td>가격</td><td><jsp:getProperty property="price" name="item"/></td>
</tr>
<tr>
<td>설명</td><td><pre><jsp:getProperty property="description" name="item"/></pre></td>
<!-- 줄개행 <pre> 혹은 JavaScript 사용해야함 -->
</tr>
</table>
</body>
</html>