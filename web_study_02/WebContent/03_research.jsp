<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 조사 결과</title>
<style type="text/css">

b{
	font-size:16pt;
}

</style>
</head>
<body>
<h2>설문 조사 결과</h2>
<% 
   request.setCharacterEncoding("UTF-8");
   String name = request.getParameter("name");
   out.print("이름 :<b>"+name+"</b><br>");
   String gender = request.getParameter("gender"); 
   out.print("성별 :");
   
   if(gender.equals("male")){
	   out.print("<b>남자</b><br>");
   }else{
	   out.print("<b>여자</b><br>");
   }
   String[] seasonArr = request.getParameterValues("season");
   out.print("당신이 좋아하는 계절은");
   for(int i=0;i<seasonArr.length;i++){
	   int n = Integer.parseInt(seasonArr[i]);
	   switch(n){
	   case 1:
		   out.print("<b>봄</b>입니다");
		   break;
	   case 2:
		   out.print("<b>여름</b>입니다");
		   break;
	   case 3:
		   out.print("<b>가을</b>입니다");
		   break;
	   case 4:
		   out.print("<b>겨울</b>입니다");
		   break;
	   }
   }
   
%>
<br>
<b><a href="javascript:history.go(-1)">다시 작성</a></b> <!-- 이전페이지 -->
</body>
</html>