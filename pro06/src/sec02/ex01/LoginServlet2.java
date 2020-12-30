package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy 메소드 호출");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	   response.setContentType("text/html;charset=UTF-8");
	   PrintWriter out = response.getWriter(); //객체생성
	   
	   String id = request.getParameter("user_id");
	   String pw = request.getParameter("user_pw");
		
	   /*
	   String data="<html>";
	   String data2="<body>";
	   String data3="아이디:"+id;
	   String data4="<br>";
	   String data5="비밀번호:"+pw;
	   String data6="</body>";
	   String data7="</html>";
	  
	   out.print(data);
	   out.print(data2);
	   out.print(data3);
	   out.print(data4);
	   out.print(data5);
	   out.print(data6);
	   out.print(data7);
	   */
	   /*
	   String data="<html>";
	   data+="<body>";
	   data+="아이디:"+id;
	   data+="<br>";
	   data+="비밀번호:"+pw;
	   data+="</html>";
	   data+="</body>";
	  
	   out.print(data);
	   */
	   
	   String data="<html>"+
	   "<body>"+
	   "아이디:"+id+
	   "<br>"+
	  "비밀번호:"+pw+
	   "</html>"+
	   "</body>";
	  
	   out.print(data);
	   
	   //data안에 전부 입력해도 가능
	
	
	}

}
