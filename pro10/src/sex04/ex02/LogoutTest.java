package sex04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutTest
 */
@WebServlet("/logout")
public class LogoutTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServletContext context; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutTest() {
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
		 doHandle(request,response);
	}

	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		context=getServletContext();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();		
		String user_id = request.getParameter("user_id"); //user_list에서 삭제할 id가져옴
		
		session.invalidate(); // 세션소멸
		
		List user_list = (ArrayList)context.getAttribute("user_list");
		user_list.remove(user_id);
		context.setAttribute("user_list",user_list);
		out.println("<br>로그아웃 했습니다.");
		out.println("<a href='login2.html'>확인</a>");
	}
	
}
