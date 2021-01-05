<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
    
<%request.setCharacterEncoding("utf-8");%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>예제-상품선택</h2>
<hr>
1.선택한 상품은 : ${param.itembox} <br>
2.num1 + num2 = ${product.num1+product.num2} <!-- product는 자바빈 프로퍼티(같이넘어옴) -->
</body>
</html>