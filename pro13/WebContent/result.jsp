<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %> <!-- 한글깨지는것 처리 -->
<%
String userID = request.getParameter("userID");
if(userID.length()==0){	

/*RequestDispatcher dispatch=request.getRequestDipatcher("login.jsp");
dispatcher.forward(request,response);*/
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%
}
%>
<h1>환영합니다 <%=userID %>님!!</h1>
</body>
</html>