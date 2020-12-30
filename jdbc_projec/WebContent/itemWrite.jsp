<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	 String url="jdbc:oracle:thin:@localhost:1521:xe";
	 String uid="scott";
	 String pass="tiger";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>입력 완료된 정보</h2>
<table width="800" border="1">
	<tr>
		<td>상품명</td>
		<td>가격</td>
		<td>설명</td>
	</tr>	
	
	
<%
	request.setCharacterEncoding("UTF-8");

	try{	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("드라이버로딩 성공");
	conn = DriverManager.getConnection(url,uid,pass);
	System.out.println("연결 성공");
	stmt = conn.createStatement();
	rs = stmt.executeQuery("select * from item");
	
	while(rs.next()){
	out.print("<tr>");
	out.print("<td>"+rs.getString("name")+"</td>");
	//out.print("<td>"+Integer.parseInt((rs.getString("price"))+"</td>");
	out.print("<td>"+rs.getString("price")+"</td>");
	out.print("<td>"+rs.getString("description")+"</td>");

	out.print("</tr>");
	}
	
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(conn != null){
				conn.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(rs != null){
				rs.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>

</table>
</body>
</html>