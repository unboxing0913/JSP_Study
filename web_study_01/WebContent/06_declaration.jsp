<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    	String str="안녕하세요!";
    	int a=5,b=-5;
    	
    	public int abs(int n){
    		if(n<0){
    			n=-n;
    		}
    		return n;
    	}
    %> <%-- 위치상관없음 body태그안에 선언문 들어가도 결과는 같다 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
	out.print(str+"<br>");
	out.print(a+"의 절대값:"+abs(a)+"<br>");
	out.print(b+"의 절대값:"+abs(b)+"<br>");
%>
</body>
</html>