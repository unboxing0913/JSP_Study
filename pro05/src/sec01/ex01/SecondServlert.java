package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlert extends HttpServlet{
	
	public void init() throws ServletException{
		System.out.println("init �޼ҵ� ȣ��>>>");
	}
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
				System.out.println("doGet �޼ҵ� ȣ��>>>");
			}
	
	public void destory(){
		System.out.println("destory �޼ҵ� ȣ��"); //����ɶ� �۵�
	}
}
