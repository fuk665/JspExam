package test;

import impl.FilmImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.FilmDAO;
import factory.ConFactory;

public class test {

	public static void main(String[] args) throws SQLException {
		FilmDAO dao = new FilmImp();
		Connection con = ConFactory.getConFactory().getCon();
		ResultSet rs = dao.listF(con);
		while(rs.next()){
			System.out.println(rs.getInt("film_id"));
			System.out.println(rs.getInt("title"));
			System.out.println(rs.getInt("description"));
			System.out.println(rs.getInt("name"));
		}
	}

}
