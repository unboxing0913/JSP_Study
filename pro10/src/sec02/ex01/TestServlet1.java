package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testServlet1
 */
@WebServlet("/first/test")
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String context=request.getContextPath(); //������Ʈ
		String url=request.getRequestURL().toString(); //��ü��ΰ�
		String mapping = request.getServletPath(); //�����̸�
		String uri=request.getRequestURI();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Test Servlet1</title>");
		out.println("</head>");
		out.println("<body bgcolor='green'>");
		out.println("<b>TestServlet1 �Դϴ�.</b><br>");
		out.println("<b>���ؽ��� :"+context+"</b><br>"); 
		out.println("<b>��ü��� :"+url+"</b><br>");
		out.println("<b>���θ� :"+mapping+"</b><br>");
		out.println("<b>URI :"+uri+"</b><br>");
		out.println("</body>");
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
