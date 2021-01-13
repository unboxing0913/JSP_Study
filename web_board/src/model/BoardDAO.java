package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {

	ResultSet rs;
	Connection conn;
	PreparedStatement pstmt;
	
	/*https://dlgkstjq623.tistory.com/195*/
	
	public BoardDAO() {
		// TODO Auto-generated constructor stub
	}

	public void getCon() {
		try {
			Context initctx = new InitialContext();
			Context envctx = (Context)initctx.lookup("java:/comp/env");
				DataSource ds = (DataSource)envctx.lookup("jdbc/Oracle11g");
				conn=ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertBoard(BoardBean bean) { //�Խñ��߰�
		
		getCon();
		
		int ref=0; //�� �׷�
		int re_step=1; 
		int re_level=1;
		
		try {
			String refSQL = "select max(ref) from board";
			pstmt=conn.prepareStatement(refSQL);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				ref=rs.getInt(1)+1; //�ִ밪�� +1�� ���ؼ� �� �׷��� ����
				
			}
			String sql="insert into board values(board_seq.NEXTVAL,?,?,?,?,sysdate,?,?,?,0,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bean.getWriter());//
			pstmt.setString(2, bean.getEmail());//
	        pstmt.setString(3, bean.getSubject());//
	        pstmt.setString(4, bean.getPassword());//
	        pstmt.setInt(5, ref);//
	        pstmt.setInt(6, re_step);//
	        pstmt.setInt(7, re_level);//
	        pstmt.setString(8, bean.getContent());//
		
	        pstmt.executeUpdate();
			
	            conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public Vector<BoardBean> getAllBoard(){ //��ü�Խñۺ���
		
		Vector<BoardBean> v = new Vector<>();
		getCon();
		try {
			String sql="select * from board order by ref desc,re_step asc";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
		
			while(rs.next()) {
				BoardBean bean = new BoardBean();
				bean.setNum(rs.getInt(1));
				bean.setWriter(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSubject(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setReg_date(rs.getDate(6).toString());
				bean.setRef(rs.getInt(7));
				bean.setRe_step(rs.getInt(8));
				bean.setRe_level(rs.getInt(9));
				bean.setReadcount(rs.getInt(10));
				bean.setContent(rs.getString(11));
				
				v.add(bean);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	return v;	//
		
	}
	
	public BoardBean getOneBoard(int num){ //�ѻ���� ������(�Խñ�)�� ������ , ��ȸ������
		
		getCon();
		BoardBean bean=null;
		try {
			//�ϳ��� �Խñ��� �о����� ��ȸ������
			String readsql="update board set readcount=readcount+1 where num=?";
			pstmt=conn.prepareStatement(readsql);
			pstmt.setInt(1,num);
			pstmt.executeUpdate();
			
			// �� �Խñۿ� ���� ������ ��������
			String sql="select * from board where num=?";		
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				bean=new BoardBean();
				bean.setNum(rs.getInt(1));
				bean.setWriter(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSubject(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setReg_date(rs.getDate(6).toString());
				bean.setRef(rs.getInt(7));
				bean.setRe_step(rs.getInt(8));
				bean.setRe_level(rs.getInt(9));
				bean.setReadcount(rs.getInt(10));
				bean.setContent(rs.getString(11));
			}
			conn.close();			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
			return bean;
	}
}
