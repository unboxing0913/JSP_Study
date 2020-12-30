<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! 
	public int sum(int a){
	int total=0;
	for(int i=1;i<=a;i++){
		total+=i;
	}
	return total;
	
}

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 페이지</title>
</head>
<body>
<%
int num=Integer.parseInt(request.getParameter("num"));
	for(int i=1;i<num;i++){
		out.print(i+"+");
	}
out.print(num+"="+sum(num));
%>



</body>
</html>