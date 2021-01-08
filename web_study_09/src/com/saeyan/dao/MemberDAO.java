package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.saeyan.dto.MemberVO;
//https://jamesyleather.tistory.com/370
//https://m.blog.naver.com/PostView.nhn?blogId=roropoly1&logNo=221009133774&proxyReferer=https:%2F%2Fwww.google.com%2F
/*�α��� ó�� MVC ����*/
public class MemberDAO {
	
	/*�̱��� : DB������ �� ���� ������ �� �ֵ��� �Ѵ�.*/
	private MemberDAO() {
		
	}
	
	private static MemberDAO instance=new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	/*����޼ҵ�*/
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
	 
/*	public Connection getConnection(){
	        // �� �� alt+shift+z �� try block
	        Connection conn = null;
	        
	        try {
	            Context initContext = new InitialContext();
	            Context envContext  = (Context)initContext.lookup("java:/comp/env");
	                                                        // myoracle <-- context.xml
	            DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
	            conn = ds.getConnection();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	        return conn;
	    } */
	
	/*����� ������ ���
	����ڰ� �Է��� id pwd ��ġ�ϴ��� Ȯ��
	result �� : ���̺��� �����ϸ� 1 , pwdƲ���� 0�� userid�� �������������� -1�� ��ȯ*/
	public int userCheck(String userid,String pwd) {
		int result=-1;
		String sql="select pwd form member where userid=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
				
				if(rs.next()) {
					if(rs.getNString("pwd") != null && rs.getString("pwd").equals(pwd)){
					    result=1; //���̵� �н����� ��ġ
					}else {
						result=0; //���̵�� ������ �н����� ����ġ
					}
				}else {
					result=-1; //���̵� ������������
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs!=null)
						rs.close();
					if(pstmt!=null)
						pstmt.close();
					if(conn!=null)
						conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return result;
		}
	
	
	/*�Ű������� �Էµ� ����� id�� ������ Db���� ����� ������ ��ȸ�Ͽ� ��ȯ�ϴ� �޼ҵ�*/
	public MemberVO getMember(String userid) {
		MemberVO mVo=null;
		String sql="select * from member where userid=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				mVo = new MemberVO(); //
				mVo.setName(rs.getString("name"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setPwd(rs.getString("pwd"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAdmin(rs.getInt("admin"));
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
					conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return mVo;
	}
	
	/*�ߺ�Ȯ��
	�ش� ���̵� �ִ��� ������ Ȯ���ϴ� �޼ҵ� ( 1���� ,-1���� )*/
	public int confirmID(String userid) {
		System.out.println("confirmID dao");
		int result=-1;
		String sql="select userid from member where userid=?";
		Connection conn=null;
		//���ε������� ������ prepareStatement, ������ statement
		PreparedStatement pstmt=null;
		//���̵�� ����� �ִ��� ������ ��ȸ�� �ذ������ resultSet
		ResultSet rs=null;
		
		
		
		try {
			conn=getConnection();//����Ŭ 11,localhost�� xe,scott1400 tiger�� ����Ǿ�����
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=1; // �ش� id ���Ұ� 
			}else { 
				result=-1; // �ش� id ��밡��
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
					conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result; //�ٽ� �������� ����� �����
	}
	
    /*join �Խ��ǿ��� �ۼ��� 6�� ȸ�� ������ �Է��ϴ� �޼ҵ�*/
	public int insertMember(MemberVO mVo) {
		int result=-1;//
		String sql="insert into member values(?,?,?,?,?,?)"; //���ε�����
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mVo.getName());
            pstmt.setString(2, mVo.getUserid());
            pstmt.setString(3, mVo.getPwd());
            pstmt.setString(4, mVo.getEmail());
            pstmt.setString(5, mVo.getPhone());
            pstmt.setInt(6, mVo.getAdmin());
            
            result = pstmt.executeUpdate(); // ������ �߰� �Ǽ� ��ȯ���� (1)
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null) 
					pstmt.close();
				if(conn != null) 
					conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	    // JoinServlet���� �̵�!
	    return result;
}
	
     /* ���� �Խ��ǿ��� �ۼ��� ����(4��)�׸��� �����ϴ� sql����� ���� */		
	 public int updateMember(MemberVO mVo) {
		 int result=-1;
		 Connection conn=null;
		 String sql="update member set pwd=?, email=?, phone=?, admin=? where userid=?";
		 PreparedStatement pstmt=null;
		 
		 try{
	            conn = getConnection();
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, mVo.getPwd());
	            pstmt.setString(2, mVo.getEmail());
	            pstmt.setString(3, mVo.getPhone());
	            pstmt.setInt(4, mVo.getAdmin());
	            pstmt.setString(5, mVo.getUserid());
	 
	            result = pstmt.executeUpdate(); //������ ���� ���� ��ȯ (1)
	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }finally{
	            try{
	                if(pstmt != null) pstmt.close();
	                if(conn != null) conn.close();
	            }catch(Exception e){
	                e.printStackTrace();
	            }
	        }
	        
	        return result;
	 }
	
	
}
