<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- 데이터베이스 처리 가장기본 -->
   <!-- db내용 바로출력되게 -->
<%!
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	String url="jdbc:oracle:thin:@localhost:1521:xe";
    String uid="scott";
    String pass="tiger";
    String sql="select * from employee";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="800" border="1">
	<tr>
		<th>name</th>
		<th>address</th>
		<th>ssn</th>		
	</tr>
<%
request.setCharacterEncoding("utf-8");
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn = DriverManager.getConnection(url,uid,pass);
stmt = conn.createStatement();
rs = stmt.executeQuery(sql);

while(rs.next()){
	out.print("<tr>");
	out.print("<td>"+rs.getString("name")+"</td>");
	out.print("<td>"+rs.getString("address")+"</td>");
	out.print("<td>"+rs.getString("ssn")+"</td>");
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