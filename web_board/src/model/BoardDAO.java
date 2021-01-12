package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {

	ResultSet rs;
	Connection conn;
	PreparedStatement pstmt;
	
	public BoardDAO() {
	}
	
	public void getCon() {
		try {
			Context initctx=new InitialContext();
			Context envctx=(Context)initctx.lookup("java:/comp/env");
			DataSource ds = (DataSource)envctx.lookup("jdbc/Oracle11g");
			conn=ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertBoard(BoardBean bean) {
		
	}

}
