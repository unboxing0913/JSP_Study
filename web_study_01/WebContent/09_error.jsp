<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> <%--예외 페이지 --%>
<%-- isErrorPage  -> true 해주면 예외임포트 안해줘도 오류가안나옴 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
다음과 같은 오류가 발생하였습니다.
0으로 나눌 수 없습니다.
<%=exception.getMessage() %>

</body>
</html>