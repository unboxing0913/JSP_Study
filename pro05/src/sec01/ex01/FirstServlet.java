package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{

	public void init() throws ServletException{ //시작할때
		System.out.println("init 메소드 호출");
	}
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
	throws ServletException,IOException{ //반복
		System.out.println("doGet 메소드 호출");
	}
	
	public void destory(){
		System.out.println("destory 메소드 호출"); //종료될때 작동
	}
}
