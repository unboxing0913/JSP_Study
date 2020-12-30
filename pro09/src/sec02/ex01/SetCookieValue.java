package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieValue
 */
@WebServlet("/set")
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCookieValue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Date d = new Date(); //������ ��ü����
		// import java.util.Date; ������ ����Ʈ
		Cookie c = new Cookie("cookieTest",URLEncoder.encode("JSP���α׷����Դϴ�.","utf-8"));	//��Ű��ü���� (�̸�,����)
		//c.setMaxAge(24*60*60); //��Ű �����Ⱓ ����(�Ϸ�24�ð�*60��*60��)
		c.setMaxAge(-1);
		response.addCookie(c); //���� ��Ű ��ü�� Ŭ���̾�Ʈ������ ����
		out.println("����ð�"+d);
		out.println("<br>���ڿ��� Cookie�� �����մϴ�.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
