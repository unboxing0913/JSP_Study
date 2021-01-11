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
        memberDAO = new MemberDAO(); //객체 초기화
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
		String action=request.getPathInfo(); //url에서 요청명을 가져온다.
		System.out.println("action:"+action);
		
		if(action == null || action.contentEquals("listMember.do")) {//최초 요청 혹은 회원 조회이면 조회 페이지 
		    List<MemberVO> membersList = memberDAO.listMembers();  //요청에 대해 외원 정보를 조회
			request.setAttribute("membersList", membersList);//조회한 정보를 request에 바인딩
			nextPage = "/test01/listMembers.jsp";
		}else if(action.equals("/addMember.do")) {// 전송된 회원 정보를 가져와 테이블에 추가하는 역할
	            String id = request.getParameter("id");
	            String pwd = request.getParameter("pwd");
	            String name = request.getParameter("name");
	            String email = request.getParameter("email");
	            MemberVO memberVO = new MemberVO(id,pwd,name,email);
	            memberDAO.addMember(memberVO); //DAO의 addmember로 DB에 저장
	            request.setAttribute("msg","addMember"); 
	            nextPage = "/member/listMembers.do"; //회원 등록후 다시 회원 목록을 출력
		}else if (action.equals("/memberForm.do"))  {// 회원 가입창일 경우
            nextPage = "/test01/memberForm.jsp"; // 해당 경로의 jsp로 포워딩한다.
        }
        else { 
            List<MemberVO> membersList = memberDAO.listMembers();
            request.setAttribute("membersList", membersList);
            nextPage = "/test01/listMembers.jsp";
        }//그 외 다른 action 값은 회원 목록을 출력
        RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); //nextPage에 따른 요청명으로 서블릿에 요청
        dispatch.forward(request, response); 
        //컨트롤러에서 표시하고자 하는 JSP로 포워딩
       
    
        /*
		List<MemberVO> membersList=memberDAO.listMembers();//요청에 대한 회원정보 조회
		System.out.println(membersList);
        request.setAttribute("membersList", membersList); //조회한 정보를 request에 바인딩
        RequestDispatcher dispatch = request.getRequestDispatcher("/test01/listMembers.jsp");//컨트롤러에서 표시하고자 하는 JSP로 포워딩
        dispatch.forward(request, response); 
        //포워딩, 바인딩은 Servlet에서 추후에 설명
         * 
         */
	}
}
