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
 * Servlet implementation class LoginTest2
 */
@WebServlet("/login2")
public class LoginTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context=null;
	List user_list=new ArrayList();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginTest2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		context=getServletContext();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		LoginImpl loginUser=new LoginImpl(user_id,user_pw);
		if(session.isNew()) {//���ο� �����Ͻ�
			session.setAttribute("loginUser", loginUser); //���ε�
			user_list.add(user_id);
			context.setAttribute("user_list", user_list);
		}
	    
		out.println("<html><body>");
	    //out.println("<form action='logout'>");
		out.println("���̵�� "+loginUser.user_id+"<br>");
		out.println("�� ������ ���� "+LoginImpl.total_user+"<br>");
		out.println("���� ���̵� :<br><br>");
		List list = (ArrayList)context.getAttribute("user_list");
		for(int i=0;i<list.size();i++) {
			out.print(list.get(i)+"<br>");
		}
		
		out.println("<a href='logout?user_id="+user_id+"'>�α׾ƿ�</a>");//��ũ
		            //?�� ��ũ�ϴ��������� ������������?      //��������ǥ�� �������� �� ��������ǥ ��ġ�߿��
		//out.println("<input type='submit' value='�α׾ƿ�'>");
		//out.println("</form>");
		out.println("</body></html>");
	}

}
