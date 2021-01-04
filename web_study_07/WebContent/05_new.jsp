<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
EL 식<hr>
==연산자 사용 결과: ${param.id=="hong"}
EL에서는 피라미터를 찾지 못하면 공백으로 처리되기 때문에 예외처리를 하지 않아도 된다.
</body>
</html>