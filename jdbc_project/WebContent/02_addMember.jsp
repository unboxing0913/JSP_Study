<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    Connection conn=null;
    PreparedStatement pstmt=null; //sql 명령어를 쉽게사용하기위해 선언
    String url="jdbc:oracle:thin:@localhost:1521:xe";
    String uid="scott";
    String pass="tiger";
    String sql="insert into member values(?, ?, ?, ?, ?, ?)"; //이런식으로
    %>                                <!--1,2,3,4,5,6  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 페이지</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");
String userid = request.getParameter("userid");
String pwd = request.getParameter("pwd");
String email = request.getParameter("email");
String phone = request.getParameter("phone");
String admin = request.getParameter("admin");


	try{
		//(1단계) JDBC 드라이브로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//(2단계) 데이터베이스 연결 객체인 Connection 생성
		conn=DriverManager.getConnection(url,uid,pass);
		//(3단계) Statement 객체 생성
		pstmt=conn.prepareStatement(sql);
		//(4단계 ) 바인딩 변수를 채운다.
		pstmt.setString(1, name); //?의 1번
		pstmt.setString(2, userid); //?의 2번
		pstmt.setString(3, pwd);//?의 3번
		pstmt.setString(4, email);//?의 4번
		pstmt.setString(5, phone);//?의 5번
		pstmt.setInt(6, Integer.parseInt(admin));//?의 6번 number타입
		//(5단계 ) SQL문을 실행하여 결과 처리
		pstmt.executeUpdate();//pstmt는 써줘야 데이터베이스에 전송됨

	}catch(Exception e){
		e.printStackTrace();
	}finally{
		//(6단계 ) 사용한 리소스 해제
		try{
			if(pstmt != null){
				pstmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

%>
<h3>회원 가입 성공</h3>
<a href="01_allMember.jsp">회원 전체 목록 보기</a>
</body>
</html>