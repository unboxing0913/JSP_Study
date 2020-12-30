package sec04.ex01;

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
 * Servlet implementation class LoginTest
 */
@WebServlet("/logintest")
public class LoginTest extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init �޼ҵ� ȣ��");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy �޼ҵ� ȣ��");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println("���̵�:"+id);
		System.out.println("��й�ȣ:"+pw);
		
		if(!(id.length()==0||id==null)) { //���Ǻ�
			out.print("<html>");
			out.print("<body>");
			out.print(id+"��!! �α����ϼ̽��ϴ�."); //�ƹ����� !! �α��� �ϼ̽��ϴ�.
			out.print("</body>");
			out.print("</html>");
		}else {
			out.print("<html>");
			out.print("<body>");
			out.print("���̵� �Է��ϼ���!!!");
			out.print("<br>");
			out.print("<a href=http://localhost:8080/pro06/test01/login.html>�α���â ���� �̵�</a>"); //�α��� â���� �̵�
			out.print("</body>");
			out.print("</html>");
		}
	}

}
