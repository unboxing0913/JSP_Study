<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!  //함수 , 절대값은 %! 
	public int mutiply(int x,int y){
		int result = x*y;
		return result;
	}

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  두 정수의 곱셈 <%=mutiply(10,20) %> -->
<%@ page import="java.util.Scanner"%>
<%
	int num1=new Scanner(System.in).nextInt();
	int num2=new Scanner(System.in).nextInt();

	
	
	out.print("두정수의 곱은"+mutiply(num1,num2));
%>
</body>
</html>