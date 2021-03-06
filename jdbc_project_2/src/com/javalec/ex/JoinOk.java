package com.javalec.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinOk
 */
//회원가입 정보를 db와 연결하는과정
@WebServlet("/JoinOk")
public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection connection; //sql임포트
    private Statement stmt; //sql임포트
    
    
    private String name,id,pw,phone1,phone2,phone3,gender;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		actionDo(request,response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("doPost");
		actionDo(request,response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.setCharacterEncoding("utf-8");
		
		name=request.getParameter("name");
		id=request.getParameter("id");
		pw=request.getParameter("pw");
		phone1=request.getParameter("phone1");
		phone2=request.getParameter("phone2");
		phone3=request.getParameter("phone3");
		gender=request.getParameter("gender");
		
		String query="insert into member values('"+name+"','"+id+"','"+pw+"','"+phone1+"','"+phone2+"','"+phone3+"','"+gender+"')";
		//문자열로 미리 쿼리문을 만들어둠
		
		
		//항상 db와 연결할때는 try catch finally문 (공식)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//오라클드라이버를 자바드라이버연결
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");//getConnerction을통해 연결
			stmt=connection.createStatement(); //실제작업을하는객체 
			int i=stmt.executeUpdate(query); //한사람일경우 반환값 return 1 // 실패할경우 : 0
			if(i == 1) { //db에 정상저장이 됬으면
				System.out.println("insert success");
				response.sendRedirect("joinResult.jsp");//결과페이지
			}else { //아니면
				System.out.println("insert fail");
				response.sendRedirect("join.html"); //원래페이지로 다시요청
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt !=null) {
					stmt.close();
				}				
				if(connection != null){
					connection.close();
				}
			}catch(Exception e){
				
			}
			
		}
	}
}
