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
        memberDAO = new MemberDAO(); //��ü �ʱ�ȭ
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
        
        else if(action.equals("/modMemberForm.do")){// ȸ�� ���� ��û�� ID�� ȸ�� ���� ��ȸ, ����â���� ������
             System.out.println("????? ���� ��ư ������ �Ǿߵ�??");
             String id=request.getParameter("id");
             MemberVO memInfo = memberDAO.findMember(id); //���۵� ID�� ȸ�� ������ ��ȸ
             request.setAttribute("memInfo",memInfo); // ���ε��Ͽ� �������� ȸ�������� ����
             nextPage="/test02/modMemberForm.jsp";
        }
        
        else if(action.equals("/modMember.do")){ //���̺� ȸ�������� ����
             String id=request.getParameter("id");
             String pwd=request.getParameter("pwd");
             String name= request.getParameter("name");
             String email= request.getParameter("email");
             MemberVO memberVO = new MemberVO(id, pwd, name, email); //�� ���� MemberVO ��ü �Ӽ��� ����
             memberDAO.modMember(memberVO);
             request.setAttribute("msg", "modified"); // ���� �Ϸ��� �޼����� ����
             nextPage="/members/listMembers.do";
        }
        
        else if(action.equals("/delMember.do")){
             String id=request.getParameter("id"); // ������ ID�� �޾ƿ�
             memberDAO.delMember(id); // DAO��  delMember
             request.setAttribute("msg", "deleted"); // ���� �Ϸ� �޼��� ����
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
