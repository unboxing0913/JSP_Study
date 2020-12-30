package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncoderFilter
 */
@WebFilter("/EncoderFiler")
public class EncoderFilter implements Filter {
	
	ServletContext context; //�ʵ�

    /**
     * Default constructor. 
     */
    public EncoderFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy ȣ��");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// pass the request along the filter chain
		
		// ��û�� ���信 ������ ���͸� ���ļ����ٰ� �����ϸ��
		System.out.println("doFilter ȣ��");
		request.setCharacterEncoding("UTf-8");
		String context = ((HttpServletRequest) request).getContextPath();
		String pathinfo = ((HttpServletRequest) request).getRequestURI();
		String realPath = request.getRealPath(pathinfo); 
		String mesg = "Context ����:"+context+"\n URI����:"+pathinfo+"\n ������ ���:"+realPath;
		System.out.println(mesg);
		
		chain.doFilter(request, response);	//���͸� get,post��Ŀ� ����			
		
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("utf-8���ڵ�...");
		context=fConfig.getServletContext();
	}

}
