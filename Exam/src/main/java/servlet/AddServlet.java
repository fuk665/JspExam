package servlet;

import impl.FilmImp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;

import dao.FilmDAO;
import entity.Film;
import entity.Language;
import factory.ConFactory;

public class AddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
	//	String language = request.getParameter("language_id");
	//	Integer ii = Integer.parseInt(request.getParameter("language"));
	//	System.out.println(ii+"********************");
		
		Integer language_id = Integer.parseInt(request.getParameter("language"));
		RequestDispatcher rd = null;
		Connection con = ConFactory.getConFactory().getCon();
		FilmDAO fd = new FilmImp();
		Film f = new Film();
//		Language l = new Language();
		f.setTitle(title);
		f.setLanguage_id(language_id);
		f.setDescription(description);
		try {
			
			int b = fd.addF(con, f);
			
			if(b>=0){
				request.getSession().setAttribute("msg", "添加成功！");
				rd = request.getRequestDispatcher("/del.jsp");
				rd.forward(request, response);
			}else{
				request.getSession().setAttribute("msg", "添加失败！");
				rd = request.getRequestDispatcher("/del.jsp");
				rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
