package servlet;

import impl.FilmImp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FilmDAO;
import factory.ConFactory;

public class TOUpdateServlet extends HttpServlet {

	public TOUpdateServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int film_id = Integer.parseInt(request.getParameter("id"));
		Connection con = ConFactory.getConFactory().getCon();
		FilmDAO fd = new FilmImp();
		try {
			ResultSet rs = fd.FindFilm(con, film_id);
			HttpSession session = request.getSession();
			session.setAttribute("rs", rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
