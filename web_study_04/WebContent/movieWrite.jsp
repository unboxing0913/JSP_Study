<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="movie" class="com.mission.javabeans.MovieBean"></jsp:useBean>
<jsp:setProperty property="*" name="movie"/>

<h2>입력된 정보 출력</h2>
<table>
<tr>
<td>제목</td><td><jsp:getProperty property="title" name="movie"/></td>
</tr>
<tr>
<td>가격</td><td><jsp:getProperty property="pirce" name="movie"/></td>
</tr>
<tr>
<td>감독</td><td><jsp:getProperty property="director" name="movie"/></td>
</tr>
<tr>
<td>출연배우</td><td><jsp:getProperty property="actor" name="movie"/></td>
</tr>
<tr>
<td>시놉시스</td><td><pre><jsp:getProperty property="synopsis" name="movie"/></pre></td>
</tr>
<tr>
<td>장르</td><td><jsp:getProperty property="genre" name="movie"/></td>
</tr>
</table>
</body>
</html>