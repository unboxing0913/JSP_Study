package sec04.ex01;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class LoginImpl implements HttpSessionBindingListener {
	String user_id;
	String user_pw;
	static int total_user=0;
	
	
	
	public LoginImpl() {
		
	}
	
	public LoginImpl(String user_id,String user_pw) {
		this.user_id=user_id;
		this.user_pw=user_pw;
	}
	// 구현 객체가 세션에 바인딩 될때 호출됨
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("사용자 접속");
		++total_user;
		
	}
	// 구현 객체가 세션에 언바인딩(제거) 될때 호출됨
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("사용자 접속 해제");
		total_user--;
		
	}

}



