<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String userID = request.getParameter("userID");
String userPwd = request.getParameter("userPwd");
String loginCheck = request.getParameter("loginCheck");
if(loginCheck.equals("user")){
%>
   <jsp:forward page="userMain.jsp"> <!-- get전송시 문자열인코딩  -->
   <jsp:param value= "<%=URLEncoder.encode(\"전고객\",\"UTF-8\") %>"
      name="userName"/>
   
   </jsp:forward>
<% 
}else{
%>
<jsp:forward page="managerMain.jsp">
   <jsp:param value= "<%=URLEncoder.encode(\"성관리\",\"UTF-8\") %>"
      name="userName"/>
   
   </jsp:forward>
<%
}


%>


</body>
</html>