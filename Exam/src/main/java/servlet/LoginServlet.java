package servlet;

import impl.CusImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CusDAO;
import entity.Customer;
import factory.ConFactory;

public class LoginServlet extends HttpServlet {
	
	static{
	//	System.out.println("我就是要看你有没有执行");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String first_name = req.getParameter("first_name");
		Customer cus = new Customer();
		cus.setFirst_name(first_name);
		RequestDispatcher rd = null;
		
	//	System.out.println("first_name*****************"+first_name);
		if(first_name==""){
			req.setAttribute("msg", "用户名或密码不能为空！");
			rd = req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);
		}else{
			
			CusDAO dao = new CusImpl();
			Connection con = ConFactory.getConFactory().getCon();
			try {
				ResultSet rs = dao.getCus(con, cus);
			//	System.out.println("是否存在账户："+rs.next());
				if( rs.next() ){
			//		System.out.println("存在--true---------------");
					req.getSession().setAttribute("flag", "success");
					rd = req.getRequestDispatcher("/success.jsp");
					rd.forward(req, resp);
				}else{
			//		System.out.println("cuowuxuowuxuowuxuowu");
					req.setAttribute("msg", "用户名错误！");
					req.getSession().setAttribute("flag", "error");
					rd = req.getRequestDispatcher("/login.jsp");
					rd.forward(req, resp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}

}
