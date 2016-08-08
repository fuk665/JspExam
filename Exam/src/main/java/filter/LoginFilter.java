package filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	
    public LoginFilter() {
    }
    
    public void init(FilterConfig fConfig) throws ServletException {
    }
    
	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String servletPath = req.getServletPath();
		HttpSession session = req.getSession();
	
//		Long d = session.getLastAccessedTime();
//		Long d1 = (long) session.getCreationTime();
//		Date date = new Date(d);
//		Date date1 = new Date(d1);
//		System.out.println(date.toString()+"==================");
//		System.out.println(date1.toString()+"==================");
//		System.out.println(session.getMaxInactiveInterval()+"=================");
		
		String flag = (String) session.getAttribute("flag");
		
		System.out.println("过滤器得到flag=="+flag);
//		System.out.println("过滤器得到servletpath=="+servletPath);
		if(servletPath!=null && ( servletPath.equals("/login.jsp")
				|| servletPath.equals("/index.jsp") 
						|| servletPath.equals("/LoginServlet") )){
			chain.doFilter(request, response);
//			System.out.println("过滤器通过--");
		}else{
			if(flag!=null && flag.equals("error")){
		//		System.out.println("过滤器flag=error");
				req.setAttribute("msg", "登录失败，请重新登录！");
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.forward(req, resp);
			}else {
		//		System.out.println("过滤器flag没有东西");
				req.setAttribute("msg", "你尚未登录，请登录！");
				req.setAttribute("flag", servletPath);
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.forward(req, resp);
			}
		}
		
		
	}

}
