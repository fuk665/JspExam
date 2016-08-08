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
	public LoginServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String first_name = req.getParameter("first_name");
		
		System.out.println("username:"+first_name);
		Customer cus = new Customer(first_name);
		Connection con = ConFactory.getConFactory().getCon();
		CusDAO dao = new CusImpl();
		RequestDispatcher rd = null;
		try {
			
			ResultSet rs = dao.getCus(con, cus);
			
			if(rs.next()==true){
				req.getSession().setAttribute("flag", "success");
				rd = req.getRequestDispatcher("/success.jsp");
				rd.forward(req, resp);
			}else{
				req.getSession().setAttribute("flag", "error");
//				req.getSession().setAttribute("flag", "用户名不存在或未登录,请重新登录！");
//				rd = req.getRequestDispatcher("/login.jsp");
//				rd.forward(req, resp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
