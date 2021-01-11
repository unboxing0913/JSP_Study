package sec01.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*https://vhxpffltm.tistory.com/136*/
/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    MemberDAO memberDAO;
    
    public void init(ServletConfig config) throws ServletException {
        memberDAO = new MemberDAO(); //��ü �ʱ�ȭ
    }
	
    public MemberController() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void  doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage=null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String action=request.getPathInfo(); //url���� ��û���� �����´�.
		System.out.println("action:"+action);
		
		if(action == null || action.contentEquals("listMember.do")) {//���� ��û Ȥ�� ȸ�� ��ȸ�̸� ��ȸ ������ 
		    List<MemberVO> membersList = memberDAO.listMembers();  //��û�� ���� �ܿ� ������ ��ȸ
			request.setAttribute("membersList", membersList);//��ȸ�� ������ request�� ���ε�
			nextPage = "/test01/listMembers.jsp";
		}else if(action.equals("/addMember.do")) {// ���۵� ȸ�� ������ ������ ���̺� �߰��ϴ� ����
	            String id = request.getParameter("id");
	            String pwd = request.getParameter("pwd");
	            String name = request.getParameter("name");
	            String email = request.getParameter("email");
	            MemberVO memberVO = new MemberVO(id,pwd,name,email);
	            memberDAO.addMember(memberVO); //DAO�� addmember�� DB�� ����
	            request.setAttribute("msg","addMember"); 
	            nextPage = "/member/listMembers.do"; //ȸ�� ����� �ٽ� ȸ�� ����� ���
		}else if (action.equals("/memberForm.do"))  {// ȸ�� ����â�� ���
            nextPage = "/test01/memberForm.jsp"; // �ش� ����� jsp�� �������Ѵ�.
        }
        else { 
            List<MemberVO> membersList = memberDAO.listMembers();
            request.setAttribute("membersList", membersList);
            nextPage = "/test01/listMembers.jsp";
        }//�� �� �ٸ� action ���� ȸ�� ����� ���
        RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); //nextPage�� ���� ��û������ ������ ��û
        dispatch.forward(request, response); 
        //��Ʈ�ѷ����� ǥ���ϰ��� �ϴ� JSP�� ������
       
    
        /*
		List<MemberVO> membersList=memberDAO.listMembers();//��û�� ���� ȸ������ ��ȸ
		System.out.println(membersList);
        request.setAttribute("membersList", membersList); //��ȸ�� ������ request�� ���ε�
        RequestDispatcher dispatch = request.getRequestDispatcher("/test01/listMembers.jsp");//��Ʈ�ѷ����� ǥ���ϰ��� �ϴ� JSP�� ������
        dispatch.forward(request, response); 
        //������, ���ε��� Servlet���� ���Ŀ� ����
         * 
         */
	}
}
