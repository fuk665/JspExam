package servlet;

import impl.FilmImp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FilmDAO;
import entity.Film;
import factory.ConFactory;

public class DeleteServlet extends HttpServlet {

	public DeleteServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int film_id = Integer.parseInt(request.getParameter("id"));
		Connection con = ConFactory.getConFactory().getCon();
		FilmDAO f = new FilmImp();
		Film film = new Film();
		film.setFilm_id(film_id);
		RequestDispatcher rd = null;
		try {
			int b = f.delF(con, film);
			if(b>=0){
				request.getSession().setAttribute("msg", "删除成功！");
				rd = request.getRequestDispatcher("/del.jsp");
				rd.forward(request, response);
			}else{
				request.getSession().setAttribute("msg", "删除失败！");
				rd = request.getRequestDispatcher("/del.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
