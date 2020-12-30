package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest4
 */
@WebServlet("/login")
public class SessionTest4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTest4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doHandle(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		doHandle(request,response);
	}
    public void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   	
    	request.setCharacterEncoding("utf-8"); //post 연결시 3가지 
    	response.setContentType("text/html;charset=utf-8"); //post 연결시 3가지 
    	PrintWriter out = response.getWriter(); //post 연결시 3가지 
    	HttpSession session=request.getSession(); // 세션객체생성
    	String user_id = request.getParameter("user_id");
    	String user_pw = request.getParameter("user_pw");
    	//String hp = request.getParameter("user_hp");
    
    	if(session.isNew()) {
    		if(user_id != null) {
    			session.setAttribute("user_id",user_id);
    			//넘어온 id를 세션에 반환
    			//out.print("<a href='login.html'>로그인 상태 확인</a>");
    			out.print("<a href='login'>로그인 상태 확인</a>"); //확장자가 없다면 매핑연결
    			//session.invalidate(); 세션을 종료시키면안됨 
    		}else {
    			out.print("<a href='login2.html'>다시 로그인 하세요!!</a>");

    		}
    		
    	}else {
    		user_id=(String)session.getAttribute("user_id");
    		if(user_id != null && user_id.length() != 0){
    			out.print("안녕하세요"+user_id+"님!!!");   			
    			//out.print(hp+"입니다"); login.html로 넘겨주면 값이나옴
    		}else {
    			out.print("<a href='login2.html'>다시 로그인 하세요!!</a>");
    			session.invalidate();
    		}
    		
    	}
    }
    
}
