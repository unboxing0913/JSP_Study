package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	private MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private static MemberDAO instance=new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
		
	}
	
	public Connection getConnection() throws Exception{
		Context context = null;
		DataSource dataSource = null;
		Connection connection = null;
		
		try {
			context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			connection=dataSource.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return  connection;
	}
	
	public int userCheck(String userid,String pwd) {
		int result=-1;
		String sql="select pwd form member where userid=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setNString(1, userid);
			rs=pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getNString("pwd") != null && rs.getString("pwd").contentEquals(pwd)
				}
			}
	}
}
