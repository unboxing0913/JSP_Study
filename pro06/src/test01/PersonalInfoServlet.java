package test01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonalInfoServlet
 */
@WebServlet("/pinfo-result")
public class PersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 request.setCharacterEncoding("UTF-8"); //post ��Ŀ��� �ѱ��� ����ϱ����� �Է�
	 response.setContentType("text/html;charset=utf-8");
	 PrintWriter out = response.getWriter();
	 String name = request.getParameter("name");
	 String id = request.getParameter("id");
	 String password = request.getParameter("password");	 
	 String gender = request.getParameter("gender");
	 if(gender.equals("male")) {
		 gender="��";
	 }else {
		 gender="��";
	 }		 
	 String inotice = request.getParameter("inotice");
	 String cnotice = request.getParameter("cnotice");
	 String dnotice = request.getParameter("dnotice");	 
	 String job = request.getParameter("job");
	 
	 
	 
	 out.print("<html>");
	 out.print("<head><title>���� ���� �Է� - ��� ȭ��</title></head>");
	 out.print("<body>");
	 out.print("<h2>���� ���� �Է�</h2><br/>");
	 out.printf("�̸�: %s<br>",name);
	 out.printf("���̵�: %s<br>",id);
	 out.printf("��й�ȣ: %s<br>",password);
	 out.printf("����: %s<br>",gender);
	 out.printf("���� ����: %s<br>",noticeToHangul(inotice));
	 out.printf("���� ����: %s<br>",noticeToHangul(cnotice));
	 out.printf("��� Ȯ�� ����: %s<br>",noticeToHangul(dnotice));
	 out.printf("����:%s<br>",job);
	 out.print("</body>");
	 out.print("</html>");
	 
	 }
	 
	private String noticeToHangul(String notice) {
		if(notice==null) {
			return notice="���� ����";
		}else if(notice.equals("on")){
			return notice="����";
		}else {
			return notice;
		}
	}
	  
		
	}


