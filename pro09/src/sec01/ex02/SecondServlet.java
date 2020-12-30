package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init �޼��� ȣ��");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy �޼��� ȣ��");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
		String user_address=request.getParameter("user_address");
		
		out.println("<html><body>");
		if(user_id != null && user_id.length() != 0) {
			out.println("�̹� �α��� �����Դϴ�!<br><br>");
			out.println("ù ��° �������� �Ѱ��� ���̵�: "+user_id+"<br>");
			out.println("ù ��° �������� �Ѱ��� ��й�ȣ: "+user_pw+"<br>");
			out.println("ù ��° �������� �Ѱ��� �ּ�: "+user_address+"<br>");
		}else {
			out.println("�α��� ���� �ʾҽ��ϴ�.<br><br>");
			out.println("�ٽ� �α��� �ϼ���!!<br>");
			out.println("<a href='/pro09/login.html'>�α��� â���� �̵��ϱ�</a>");
		}
	}

}
