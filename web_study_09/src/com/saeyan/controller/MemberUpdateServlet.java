package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/MemberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//main.jsp���� ȸ�������� �����Ϸ���
		String userid=request.getParameter("userid");
		//  �� ȸ���� ������ �������� ( ���� �� �������� ���̰Գ���)
		
		//������ ȸ�� ������ �����ٰ� �信 ���̰�����
		MemberDAO mDao=MemberDAO.getInstance();
		MemberVO mVo=mDao.getMember(userid);
		
		//mVo�� ������ ��
		request.setAttribute("mVo", mVo);
		
		//memberUpdate.jsp�� ���̰���
		RequestDispatcher dispatcher=request.getRequestDispatcher("member/memberUpdate.jsp");
		dispatcher.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone= request.getParameter("phone");
        String admin = request.getParameter("admin");
        
        MemberVO mVo = new MemberVO();
       
        mVo.setUserid(userid);
        mVo.setPwd(pwd);
        mVo.setEmail(email);
        mVo.setPhone(phone);
        mVo.setAdmin(Integer.parseInt(admin));
        
        MemberDAO dao=MemberDAO.getInstance();
        dao.updateMember(mVo); //�����Ϸ� ������
        
        //�����Ŀ� login.do�� get���ΰ��� 
        //���ǿ� �����Ͱ� �ִ� �����̱⶧���� request�� ���� �� �ʿ䰡����.
        //������ ��ü�� �����Ű�� redirect�� ����
        response.sendRedirect("login.do");
	}

}
