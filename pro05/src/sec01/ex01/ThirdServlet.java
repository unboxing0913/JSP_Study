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
 * ��Ŭ�������� ���� �������� ������̼� ���� �ٷ��Ѱ�
 * pro05 ������Ʈ�� sec01.ex01 ��Ű���� ���� > ���콺 ��Ŭ�� > New > Servlet

	Ŭ������ ThirdServlet > Next

	�ϴ��� URL mappings: /ThirdServlet ���� > ������ Edit�� > ���� : /third > OK > Next

	�ϴ� Which method stubs would you like to create����
	[üũ����] Constructors from superclass
	[üũ-�⺻��] Inherited abstract methods
	�޼ҵ� �� init, destroy, doGet üũ > Finish
 */
@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("TirdServlet init �޼ҵ� ȣ��");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("TirdServlet destroy �޼ҵ� ȣ��");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TirdServlet doGet �޼ҵ� ȣ��");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
