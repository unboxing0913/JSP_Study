<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
입력하신 정보는 아래와 같습니다.<br><br>
학력 : <%=request.getParameter("edu")%> 
소속국가 : <%=request.getParameter("na") %>
관심분야 : <% 
for(String b:request.getParameterValues("like")){
		 	out.print(b+" ");
}
 %>
 <br><br>
 <%//선생님방법
   String edu=request.getParameter("edu"); 
   String na = request.getParameter("na");
   String likes[] =request.getParameterValues("like");
   out.print("학력: "+edu+"\n");
   out.print("소속국가: "+na+"\n");
   out.print("관심분야: ");
   for(String like: likes){ //향상된for문
	   out.print(like+"\t");
   }
   out.print("<br><br>");
   
   for(int i=0;i<likes.length;i++){ //일반 for문
	   out.print(likes[i]+"\t");
   }
 %>
</body>
</html>