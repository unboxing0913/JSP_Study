<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
//데이터베이스와 JSP연결 (연결 순서 중요함)
Connection conn=null; //연결하기위한 객체생성
Statement stmt=null; //SQL문을 전달 하기위한 객체생성
ResultSet rs=null; //SQL문을 받을수있는 객체
String url="jdbc:oracle:thin:@localhost:1521:xe"; //공식 처럼 쓰면됨(실제데이터 베이스 파일위치)
String uid="scott"; //실제 유저 id
String pas="tiger"; //실제  password
String sql="select * from member";
//String sql2="insert into member values('강현승','liver','1234','liver@naver.com','010-3333-3232',0)";
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
		<th>이름</th>
		<th>아이디</th>
		<th>암호</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>권한(1:관리자,2:일반회원)</th>
	</tr>
<% //jsp의 선언문 <%
//try catch finally 문법적으로 필요함
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");//오라클드라이버 java드라이버연결
		conn=DriverManager.getConnection(url,uid,pas); // url,아이디,비밀번호 넘겨줘야함
	    //드라이버를 conn객체에 연결
		//conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		stmt = conn.createStatement(); // sql문을 실행하기위한 연결
		//stmt.executeUpdate(sql2); //userid가 pk이기 때문에 중복으로 넣을수없어서 중복실행불가 
		rs = stmt.executeQuery(sql);		
		
		
		while(rs.next()){
			out.print("<tr>");
			out.print("<td>"+rs.getString("name")+"</td>");
			out.print("<td>"+rs.getString("userid")+"</td>");
			out.print("<td>"+rs.getString("pwd")+"</td>");
			out.print("<td>"+rs.getString("email")+"</td>");
			out.print("<td>"+rs.getString("phone")+"</td>");
			out.print("<td>"+rs.getString("admin")+"</td>");
			out.print("</tr>");
			
		}
	
			
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs != null)
				rs.close();
			if((stmt != null))
				stmt.close();
			if(conn != null)
				conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>
</table>
</body>
</html>