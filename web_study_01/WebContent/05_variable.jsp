<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%! int global_cnt=0; %> <%-- ! 전역 변수 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  //지역변수와 전역변수의 차이 새로고침으로 확인해보기
	int local_cnt=0; //지역변수
	out.print("<br>local_cnt:");
	out.print(++local_cnt);
	out.print("<br>global_cnt:");
	out.print(++global_cnt);
%>

</body>
</html>