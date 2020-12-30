package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SetAttribute
 */
@WebServlet("/set")
public class SetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetAttribute() {
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
		String ctxMesg="context에 바인딩됩니다.";
		String sesMesg="session에 바인딩됩니다.";
		String reqMesg="request에 바인딩 됩니다.";
		
		ServletContext ctx=getServletContext(); 
		HttpSession session=request.getSession();
		
		ctx.setAttribute("context",ctxMesg);
		session.setAttribute("session", sesMesg);//세션안에 정보가들어감 
		request.setAttribute("requst",reqMesg);//서블릿바뀌면 reqeust는 응답후 사라짐
		
		out.print("바인딩을 수행합니다.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
