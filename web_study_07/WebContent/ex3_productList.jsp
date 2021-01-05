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

<form action="ex3_productSel.jsp" method="post">
<h2>예제-상품목록</h2>
<jsp:useBean id="product" class="com.saeyan.javabeans.Product" scope="session"/>   
<!-- 자바빈 불러옴 -->

<select name="itembox">
<%-- jstl --%>						<!-- product 자바빈 프로퍼티 -->
	<c:forEach var="item" items="${product.getProductList()}">
		<option>${item}</option>
	</c:forEach>
	
<%-- 스트립스트릿 
    for(String item:product.getProductList()){
	out.println("<option>"+item+"</option>");
	}
--%>
</select>
<input type="submit" value="선택">
</form>

</body>
</html>