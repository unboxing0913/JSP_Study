<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int age=Integer.parseInt(request.getParameter("age"));//입력한 나이값넘어옴
if(age<=19){
	
%>
<script type="text/javascript">
alert("19세 미만은 입장 불가능");
history.go(-1);
</script>
<%
}else{
	request.setAttribute("name","홍길동"); //저장을한뒤
	RequestDispatcher dispatcher=request.getRequestDispatcher("11_forwardResult.jsp");  //객체화(이쪽으로보낸다)
	dispatcher.forward(request,response);
}
%>
</body>
</html>