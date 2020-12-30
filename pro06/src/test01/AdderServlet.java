package test01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HundredServlet
 */
@WebServlet("/adder")
public class AdderServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
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
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String str1 = request.getParameter("num1");
		String str2 = request.getParameter("num2");
        
		
		int num1 = Integer.parseInt(str1);   //기본int가 필요하면 parseInt
		int num2 = Integer.parseInt(str2);
//		int num1 = Integer.valueOf(str1);    래퍼객체가 필요하면 valueOf
//		int num2 = Integer.valueOf(str2);
		int sum=num1+num2;
		int add=0;
		for(int i= num1 ; i<=num2 ; i++) {
			add+=i;
		} 
		System.out.println(num1+"+"+num2+"="+sum);		
		System.out.println(num1+" 부터"+num2+" 까지의 합은 ="+add);		
		out.print("<html>");
		out.print("<head><title>덧셈 프로그램 - 결과화면</title></head>");
		out.print("<body>");
		out.print(num1+"+"+num2+"="+sum+"<br>");	
		out.print(num1+"부터"+num2+"까지의 합은 ="+add);
		out.print("</body>");
		out.print("</html>");
	}

}
