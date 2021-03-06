package com.javalec.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	public static final int MEMBER_NONEXITSTENT=0;
	public static final int MEMBER_EXISTENT=1;
	public static final int MEMBER_JOIN_FAIL=0;
	public static final int MEMBER_JOIN_SUCCESS=1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD=0;
	public static final int MEMBER_LOGIN_SUCCESS=1;
	
	public static final int MEMBER_LOGIN_IS_NOT=-1;
	
	private static MemberDao instance = new MemberDao(); 
	
	// 외부에서 new연산자 사용하지못하게 (싱글톤)singleton 
	// 객체를 단하나만 생성할때
	// 객체생성에 대한 관리를 내부적으로 처리하겠다.
	// 메모리낭비 방지
	// DBCP사용할때 싱글톤을 많이 사용한다.
	
	private MemberDao() {
		
	}
	
	public static MemberDao getInstance() { //싱글톤메소드이름 (관례)
		return instance;
	}
	
	//입력받은 회원정보를 db에 저장
	public int insertMember(MemberDto dto) {
		int ri=0;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		String query="insert into dto_members values(?,?,?,?,?,?)";
		
		try {
			connection=getConnection();//
			pstmt=connection.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.geteMail());
			pstmt.setTimestamp(5, dto.getrDate());
			pstmt.setString(6, dto.getAddress());
			
			pstmt.executeUpdate();//디비에 저장함(갱신문)
			
			ri = MemberDao.MEMBER_JOIN_SUCCESS;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close(); //반납
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return ri;
	}
	
	//아이디중복확인
	public int confirmId(String id) {
		int ri=0;
		
		Connection connection=null; /*초기화문은 try안에 들어가있으면 안됨*/
		PreparedStatement pstmt=null;
		ResultSet set = null;
		String query="select id from dto_members where id=?";
		
		try {
		connection = getConnection();//
		pstmt = connection.prepareStatement(query);//
		pstmt.setString(1,id);
		set = pstmt.executeQuery();
		
		if(set.next()) {
			ri=MemberDao.MEMBER_EXISTENT;
		}else {
			ri=MemberDao.MEMBER_NONEXITSTENT;
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(set != null) {
					set.close();
				}
				if(connection != null) {
					connection.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return ri;
	
	}
	
	//로그인 시도시 아이디 비밀번호 체크
	public int userCheck(String id,String pw) {
		int ri=0;
		String dbPw;
		Connection connection=null; 
		PreparedStatement pstmt=null;
		ResultSet set = null;
		String query = "select pw from dto_members where id=?";
		
		try{			
			connection=getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			set=pstmt.executeQuery();
			if(set.next()) { //로그인성공
				dbPw = set.getString("pw"); //가져온 pw값이 dbpw 와 같다면
				if(dbPw.equals(pw)) {
					ri=MemberDao.MEMBER_JOIN_SUCCESS;
				}else { //비밀번호 오류 (가져온pw값이 dbpw값과 다를때
					ri=MemberDao.MEMBER_LOGIN_PW_NO_GOOD;
				}
				
			}else { //가입된 회원아 아니라면
				ri=MemberDao.MEMBER_LOGIN_IS_NOT;
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(set != null){
					set.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return ri;
	}

	//회원정보를 조회해서  dto 객체에 저장
	public MemberDto getMember(String id) {
		Connection connection=null; 
		PreparedStatement pstmt=null;
		ResultSet set = null;
		String query = "select * from dto_members where id=?";
		MemberDto dto= null;
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id); //prepareStatement의 메소드 (?에 아이디값을 설정)
			set=pstmt.executeQuery();
			
			if(set.next()) {
				dto=new MemberDto();
				dto.setId(set.getString("id"));//가입을 해서 db에 정보가있는상태
				dto.setPw(set.getString("pw"));
				dto.setName(set.getString("name"));
				dto.seteMail(set.getString("eMail"));
				dto.setrDate(set.getTimestamp("rDate"));
				dto.setAddress(set.getString("address"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(set != null) {
					set.close();
				}
				if(connection != null) {
					connection.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return dto;
		
	}
	
	
	// 회원정보 수정후 db에 저장
	public int updateMember(MemberDto dto) {
		int ri = 0;
				
		Connection connection = null;
		PreparedStatement pstmt = null;
		String query = "update dto_members set pw=?, eMail=?, address=? where id=?";
			
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.geteMail());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getId());
			ri = pstmt.executeUpdate(); //여기서 1을 증가시킴
					
		} catch (Exception e) {
				e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}			
				
	return ri;		
				
	}
	
	//연결설정
	private Connection getConnection() { //여러번사용하기위한 메소드
		Context context = null;
		DataSource dataSource= null;
		Connection connection = null;
		
		try {		    
			context = new InitialContext(); 
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			connection = dataSource.getConnection();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
