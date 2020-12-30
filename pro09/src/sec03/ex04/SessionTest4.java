package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest4
 */
@WebServlet("/login")
public class SessionTest4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTest4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doHandle(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		doHandle(request,response);
	}
    public void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   	
    	request.setCharacterEncoding("utf-8"); //post ����� 3���� 
    	response.setContentType("text/html;charset=utf-8"); //post ����� 3���� 
    	PrintWriter out = response.getWriter(); //post ����� 3���� 
    	HttpSession session=request.getSession(); // ���ǰ�ü����
    	String user_id = request.getParameter("user_id");
    	String user_pw = request.getParameter("user_pw");
    	//String hp = request.getParameter("user_hp");
    
    	if(session.isNew()) {
    		if(user_id != null) {
    			session.setAttribute("user_id",user_id);
    			//�Ѿ�� id�� ���ǿ� ��ȯ
    			//out.print("<a href='login.html'>�α��� ���� Ȯ��</a>");
    			out.print("<a href='login'>�α��� ���� Ȯ��</a>"); //Ȯ���ڰ� ���ٸ� ���ο���
    			//session.invalidate(); ������ �����Ű��ȵ� 
    		}else {
    			out.print("<a href='login2.html'>�ٽ� �α��� �ϼ���!!</a>");

    		}
    		
    	}else {
    		user_id=(String)session.getAttribute("user_id");
    		if(user_id != null && user_id.length() != 0){
    			out.print("�ȳ��ϼ���"+user_id+"��!!!");   			
    			//out.print(hp+"�Դϴ�"); login.html�� �Ѱ��ָ� ���̳���
    		}else {
    			out.print("<a href='login2.html'>�ٽ� �α��� �ϼ���!!</a>");
    			session.invalidate();
    		}
    		
    	}
    }
    
}
