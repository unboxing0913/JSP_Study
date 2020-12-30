<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!


	Connection conn=null;
	
	PreparedStatement pstmt = null;
	String name,price,description;
	String sql="insert into item values(?,?,?)";
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");

name = request.getParameter("name");
price = request.getParameter("price");
description = request.getParameter("description");

try{
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
	pstmt = conn.prepareStatement(sql); //stmt -> conn.createStatement();
 	
	pstmt.setString(1, name); 
	//pstmt.setString(2, price);
	pstmt.setInt(2, Integer.parseInt(price)); 
	pstmt.setString(3, description);
	
	pstmt.executeUpdate();
	
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
	if(conn != null){
		conn.close();
	}
	if(pstmt != null){
		pstmt.close();
	}
   }catch(Exception e){
	   e.printStackTrace();
   }
}

%>
<h2>레코드가 추가되었습니다.</h2><br>
<a href="itemWrite.jsp">결과 보기</a>
</body>
</html>