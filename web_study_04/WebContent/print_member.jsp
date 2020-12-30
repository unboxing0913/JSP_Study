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
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean class="com.saeyan.javabeans.MemberBean" id="member" scope="page"/>
<!--
<jsp:setProperty name="member" property="name" value='<%=request.getParameter("name") %>'/>
<jsp:setProperty name="member" property="userid" value='<%=request.getParameter("userid") %>'/>
<jsp:setProperty name="member" property="nickname" value='<%=request.getParameter("nickname") %>'/>
<jsp:setProperty name="member" property="pwd" value='<%=request.getParameter("pwd") %>'/>
<jsp:setProperty name="member" property="email" value='<%=request.getParameter("email") %>'/>
<jsp:setProperty name="member" property="phone" value='<%=request.getParameter("phone") %>'/> 
-->
<jsp:setProperty name="member" property="*" />

<h2>입력된 회원정보 출력</h2>
<table>
<tr>
<td>이름</td><td><jsp:getProperty property="name" name="member"/></td>
</tr>
<tr>
<td>아이디</td><td><jsp:getProperty property="userid" name="member"/></td>
</tr>
<tr>
<td>별명</td><td><jsp:getProperty property="nickname" name="member"/></td>
</tr>
<tr>
<td>비밀번호</td><td><jsp:getProperty property="pwd" name="member"/></td>
</tr>
<tr>
<td>이메일</td><td><jsp:getProperty property="email" name="member"/></td>
</tr>
<tr>
<td>전화번호</td><td><jsp:getProperty property="phone" name="member"/></td>
</tr>
</table>
</body>
</html>