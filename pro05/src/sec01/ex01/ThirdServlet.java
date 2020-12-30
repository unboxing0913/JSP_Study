package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThirdServlet
 * 
 * 이클립스에서 서블릿 생성으로 어노테이션 적용 바로한것
 * pro05 프로젝트의 sec01.ex01 패키지를 선택 > 마우스 우클릭 > New > Servlet

	클래스명 ThirdServlet > Next

	하단의 URL mappings: /ThirdServlet 선택 > 우측의 Edit… > 패턴 : /third > OK > Next

	하단 Which method stubs would you like to create에서
	[체크해제] Constructors from superclass
	[체크-기본값] Inherited abstract methods
	메소드 중 init, destroy, doGet 체크 > Finish
 */
@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("TirdServlet init 메소드 호출");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("TirdServlet destroy 메소드 호출");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TirdServlet doGet 메소드 호출");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
