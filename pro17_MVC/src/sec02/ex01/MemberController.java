package sec02.ex01;

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

@WebServlet("/members/*")
public class MemberController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    MemberDAO memberDAO;
    
    public void init(ServletConfig config) throws ServletException {
        memberDAO = new MemberDAO(); //객체 초기화
    }
 
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doHandle(request, response);
    }
 
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doHandle(request, response);
    }
    
    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nextPage = null;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getPathInfo();
        System.out.println("action:" + action);
        
        if (action == null || action.equals("/listMembers.do")) {
            List<MemberVO> membersList = memberDAO.listMembers();
            request.setAttribute("membersList", membersList);
            nextPage = "/test02/listMembers.jsp";
            
        } 
        
        else if (action.equals("/addMember.do")) {
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            MemberVO memberVO = new MemberVO(id, pwd, name, email);
            memberDAO.addMember(memberVO);
            request.setAttribute("msg", "addMember");
            nextPage = "/members/listMembers.do";
        } 
        else if (action.equals("/memberForm.do")) {
            nextPage = "/test02/memberForm.jsp";
        }
        
        else if(action.equals("/modMemberForm.do")){// 회원 수정 요청시 ID로 회원 정보 조회, 수정창으로 포워딩
             System.out.println("????? 수정 버튼 누르면 되야됨??");
             String id=request.getParameter("id");
             MemberVO memInfo = memberDAO.findMember(id); //전송된 ID로 회원 정보를 조회
             request.setAttribute("memInfo",memInfo); // 바인딩하여 수정전의 회원정보를 전달
             nextPage="/test02/modMemberForm.jsp";
        }
        
        else if(action.equals("/modMember.do")){ //테이블 회원정보를 수정
             String id=request.getParameter("id");
             String pwd=request.getParameter("pwd");
             String name= request.getParameter("name");
             String email= request.getParameter("email");
             MemberVO memberVO = new MemberVO(id, pwd, name, email); //각 값을 MemberVO 객체 속성에 설정
             memberDAO.modMember(memberVO);
             request.setAttribute("msg", "modified"); // 수정 완료한 메세지를 보냄
             nextPage="/members/listMembers.do";
        }
        
        else if(action.equals("/delMember.do")){
             String id=request.getParameter("id"); // 삭제할 ID를 받아옴
             memberDAO.delMember(id); // DAO의  delMember
             request.setAttribute("msg", "deleted"); // 삭제 완료 메세지 전달
             nextPage="/members/listMembers.do";
        }
        
        else {
            List<MemberVO> membersList = memberDAO.listMembers();
            request.setAttribute("membersList", membersList);
            nextPage = "/test02/listMembers.jsp";
        }
        RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
        dispatch.forward(request, response);
    }
}
