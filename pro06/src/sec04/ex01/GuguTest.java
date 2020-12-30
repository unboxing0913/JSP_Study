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
 * Servlet implementation class GuguTest
 */
@WebServlet("/gugutest")
public class GuguTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String a = request.getParameter("dan");
		int dan = Integer.parseInt(a);	
		
		out.print("<html>");
		out.print("<body>");
		out.print("<table border=1 width=800 align=center >");
	    out.print("<tr align=center bgcolor='#FFFF66'>");
	    out.print("<td colspan=2>"+dan+"�� ���</td>"); //colspan:���ʺ� , rowspan:������ 
	    out.print("</tr>");
		for(int i=1 ; i<=9 ; i++) { 
			if(i%2==0) {
				 out.print("<tr align=center bgcolor='#5858FA'>");
				    out.print("<td width=400>"+dan+" * "+i+"</td>");
				    out.print("<td width=400>"+dan*i+"</td>"); 	
			     out.print("</tr>");
			}else{
				 out.print("<tr align=center bgcolor='#D8F781'>");
				    out.print("<td width=400>"+dan+" * "+i+"</td>");
				    out.print("<td width=400>"+dan*i+"</td>"); 	
			     out.print("</tr>");
			}
	   
		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}
	

}
