<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 각각 객체의 범위 알아보기 -->
<% 
pageContext.setAttribute("name","page man");
request.setAttribute("name","request man");
session.setAttribute("name","sisson man");
application.setAttribute("name","application man");

System.out.println("하나의 페이지 속성:"+pageContext.getAttribute("name"));
System.out.println("하나의 요청 속성:"+request.getAttribute("name"));
System.out.println("하나의 세션 속성:"+session.getAttribute("name"));
System.out.println("하나의 애플리케이션 속성:"+application.getAttribute("name"));

//RequestDispatcher dispatcher=request.getRequestDispatcher("13_secondPage.jsp");
//dispatcher.forward(request,response);
request.getRequestDispatcher("13_secondPage.jsp").forward(request,response);//같은방법
%>
</body>
</html>