package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//a��ũ���� get������� �Ѿ�ö� login.jsp�� ��������ִ� ���
		String url="member/login.jsp";
		HttpSession session=request.getSession();
		if(session.getAttribute("loginUser") != null) {
			url="main.jsp";
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="member/login.jsp";
		//post��� 
		String userid = request.getParameter("userid");
	    String pwd = request.getParameter("pwd");

	    MemberDAO mDao = MemberDAO.getInstance(); //���Ϲޱ����� �ν��Ͻ� ��ü����
	    int result = mDao.userCheck(userid,pwd); //(1,0,-1 �� �ϳ��� �޾ƿ�)		
	  
	    //ù ������ 1���� �������
	    if(result == 1) {
	    	
	    	//���ǿ� �� ����� ������ �÷����� ������ �߱�
	    	MemberVO mVo = mDao.getMember(userid);
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", mVo); //loginUser ���ǿ� mVo��ü ����
            
            // ȸ�����Կ� �����ϸ� main.jsp�� ���ϱ� ���� ��� �� �ǹ̰� ����.
            request.setAttribute("message", "ȸ�������� �����߾��.");
            url = "main.jsp";
	    }else if(result == 0){
            request.setAttribute("message", "��й�ȣ�� Ʋ�Ⱦ��.");
            
        }else if(result == -1){
            request.setAttribute("message", "�������� �ʴ� ȸ���Դϴ�.");
        }
	    //login.jsp�� ����(message�� ��� ����.)
	    System.out.println(url);
	    RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
	}

}
