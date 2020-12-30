package sex04.ex02;

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
	// ���� ��ü�� ���ǿ� ���ε� �ɶ� ȣ���
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("���� ����");
		++total_user;
		
	}
	// ���� ��ü�� ���ǿ� ����ε�(����) �ɶ� ȣ���
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("���� �Ҹ�");
		total_user--;
		
	}

}



