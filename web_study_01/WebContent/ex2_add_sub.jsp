<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!

public int add(int a,int b){
	int result = a+b;	
	return result;
    }
public int sub(int a,int b){
	int result = a-b;	
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
<% 
int num1=50;
int num2=20;
%>
<%=num1%>+<%=num2%>=<%=add(num1,num2)%><br>
<%=num1%>-<%=num2%>=<%=sub(num1,num2)%><br>

</body>
</html>