package test01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//1~100까지의 합을 구하는 서블릿
/**
 * Servlet implementation class HundredServlet
 */
@WebServlet("/hundred")
public class HundredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    response.setContentType("text/html; charset=utf-8");
		int total=0;
	    for(int cnt=1;cnt<101;cnt++) {
	    	total+=cnt;
	    }
	    
	    PrintWriter out = response.getWriter();
	    out.print("<html>");
	    out.print("<head><title>1부터 100까지 더하는 서블릿</title></head>");
	    out.print("<body>");
	    out.printf("1부터 100까지의 합은=%d",total);
	    out.print("</body>");
	    out.print("</html>");       
	    
	    
	}

}
