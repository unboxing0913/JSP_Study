package com.javalec.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginOk
 */
// Db데이터와 내가입력한값이 같은지 비교하는 서블릿
@WebServlet("/LoginOk")
public class LoginOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection connection;
    private Statement stmt;
    private ResultSet resultSet;
   
    private String name,id,pw,phone1,phone2,phone3,gender;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		actionDo(request,response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		id=request.getParameter("id");
		pw=request.getParameter("pw");
		String query="select * from member where id='"+id+"'and pw='"+pw+"'"; // 조회하기위한 쿼리문
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		stmt=connection.createStatement();
		resultSet = stmt.executeQuery(query); //조회
		
		while(resultSet.next()) {
		name = resultSet.getString("name");
		id = resultSet.getString("id");
		pw = resultSet.getString("pw");
		phone1 = resultSet.getString("phone1");
		phone2 = resultSet.getString("phone2");
		phone3 = resultSet.getString("phone3");
		gender = resultSet.getString("gender");
		}
		
		HttpSession httpSession=request.getSession(); //세션사용하기위한 객체생성
		httpSession.setAttribute("name",name);
		httpSession.setAttribute("id",id);
		httpSession.setAttribute("pw",pw);
		
		//jsp로 넘겨줌
		response.sendRedirect("loginResult.jsp");
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null)
					resultSet.close(); //종료해줘야함
				if(stmt != null)
					stmt.close();
				if(connection != null) 
					connection.close();			
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	
		
	}
}
