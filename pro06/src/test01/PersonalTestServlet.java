package test01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonalTestServlet
 */
@WebServlet("/ptest")
public class PersonalTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
	    String name = request.getParameter("name");
	    String color = request.getParameter("color");
	    String animal = request.getParameter("animal");
	    String food[] = request.getParameterValues("food");
	    
	    
	    
	    
	    out.print("<html>");
	    out.print("<head><title>성격 테스트</title></head>");
	    out.print("<body>");
	    out.print("<h2>성격 테스트</h2>");
	    out.print(name+"님의 성격 테스트 결과<br><br>");
	    
	    out.printf("%s색 을 좋아하는 당신은%s,그리고",color,animal);
	    for (int cnt = 0; cnt < food.length; cnt++) {
	         if (cnt > 0) {
	            out.printf("과 %s", food[cnt]);
	         } else {
	            out.printf("%s", food[cnt]);
	         }
	      }
	    out.print("을 좋아하는 성격입니다.");
	    out.print("</body>");
	    out.print("</html>");
	}

	

}
