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

import dao.FilmDAO;
import entity.Film;
import factory.ConFactory;

public class UpdateServlet extends HttpServlet {

	public UpdateServlet() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Connection con = ConFactory.getConFactory().getCon();
		FilmDAO fd = new FilmImp();
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		Integer language_id = Integer.parseInt(request.getParameter("language_id"));
		Film f = new Film(title, description, language_id);
		RequestDispatcher rd = null;
		try {
			int b = fd.updF(con, f);
			
			if(b>=0){
				request.getSession().setAttribute("msg", "修改成功！");
				rd = request.getRequestDispatcher("/upd.jsp");
				rd.forward(request, response);
			}else{
				request.getSession().setAttribute("msg", "修改失败！");
				rd = request.getRequestDispatcher("/upd.jsp");
				rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
