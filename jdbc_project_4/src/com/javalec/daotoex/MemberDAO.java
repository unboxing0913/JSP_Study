package com.javalec.daotoex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// DAO(Data Access Object)
// DB와관련되서 중복되는일들을 클래스하나로 처리하기위함
/*JDBC를  DBCP로 바꾼 페이지*/
/*DBCP는 서버안에서 직접설정 servers -> Context.xml -> */
public class MemberDAO {	
	 /*private String url="jdbc:oracle:thin:@localhost:1521:xe";
	   private String uid="scott";
	   private String pass="tiger";*/
	
	 /*DBCP 사용하기위한공식*/
     private DataSource dataSource; //sql 임포트
	 
	 //객체가 생성됬을시 제일먼저 처리함
	public MemberDAO() {	
		/*	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(Exception e){
			e.printStackTrace();
		} */
	
		/*DBCP 사용하기위한공식*/
		try {
		    
			Context context = new InitialContext(); //naming 임포트
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g"); //경로
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
		
		
	public ArrayList<MemberDTO> memberSelect() {
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			/*con=DriverManager.getConnection(url,uid,pass);*/
			
			/*DBCP 사용하기위한공식*/
			con=dataSource.getConnection();
			
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from m_member");
			
			while(rs.next()) {
				String name=rs.getString("name");
				String id=rs.getString("id");
				String pw=rs.getString("pw");
				String phone1=rs.getString("phone1");
				String phone2=rs.getString("phone2");
				String phone3=rs.getString("phone3");
				String gender=rs.getString("gender");
				
				MemberDTO dto = new MemberDTO(name,id,pw,phone1,phone2,phone3,gender);
				dtos.add(dto);//
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(con != null) {
					con.close();
				}
				if(stmt != null) {
					stmt.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtos;//
	}
}
