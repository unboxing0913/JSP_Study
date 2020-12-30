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
	 request.setCharacterEncoding("UTF-8"); //post 방식에서 한글을 사용하기위해 입력
	 response.setContentType("text/html;charset=utf-8");
	 PrintWriter out = response.getWriter();
	 String name = request.getParameter("name");
	 String id = request.getParameter("id");
	 String password = request.getParameter("password");	 
	 String gender = request.getParameter("gender");
	 if(gender.equals("male")) {
		 gender="남";
	 }else {
		 gender="여";
	 }		 
	 String inotice = request.getParameter("inotice");
	 String cnotice = request.getParameter("cnotice");
	 String dnotice = request.getParameter("dnotice");	 
	 String job = request.getParameter("job");
	 
	 
	 
	 out.print("<html>");
	 out.print("<head><title>개인 정보 입력 - 결과 화면</title></head>");
	 out.print("<body>");
	 out.print("<h2>개인 정보 입력</h2><br/>");
	 out.printf("이름: %s<br>",name);
	 out.printf("아이디: %s<br>",id);
	 out.printf("비밀번호: %s<br>",password);
	 out.printf("성별: %s<br>",gender);
	 out.printf("공지 메일: %s<br>",noticeToHangul(inotice));
	 out.printf("광고 메일: %s<br>",noticeToHangul(cnotice));
	 out.printf("배송 확인 메일: %s<br>",noticeToHangul(dnotice));
	 out.printf("직업:%s<br>",job);
	 out.print("</body>");
	 out.print("</html>");
	 
	 }
	 
	private String noticeToHangul(String notice) {
		if(notice==null) {
			return notice="받지 않음";
		}else if(notice.equals("on")){
			return notice="받음";
		}else {
			return notice;
		}
	}
	  
		
	}


