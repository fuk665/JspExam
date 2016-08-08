package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.FilmDAO;
import entity.Film;

public class FilmImp implements FilmDAO {

	public int addF(Connection con,Film film) throws SQLException {
		String sql = "insert into film (title,description,language_id) values(?,?,?)";
		PreparedStatement prst = con.prepareStatement(sql);
		prst.setString(1, film.getTitle());
		prst.setString(2, film.getDescription());
		prst.setInt(3, film.getLanguage_id());
		return prst.executeUpdate();
	}

	public int delF(Connection con,Film film) throws SQLException {
		String sql = "delete from film where film_id=?";
		PreparedStatement prst = con.prepareStatement(sql);
		prst.setInt(1, film.getFilm_id());
	//	System.out.println(prst.executeUpdate()+"*********************");
		return prst.executeUpdate();
	}

	public int updF(Connection con,Film film) throws SQLException {
		String sql = "update from film set title=?,description=?,language_id=? where film_id=?";
		PreparedStatement prst = con.prepareStatement(sql);
		prst.setInt(4, film.getFilm_id());
		prst.setString(1, film.getTitle());
		prst.setString(2, film.getDescription());
		prst.setInt(3, film.getLanguage_id());
		return prst.executeUpdate();
	}

	public ResultSet listF(Connection con) throws SQLException {
		String sql = sql = "SELECT  film.film_id ,  film.title , film.description , `language`.`name`  "
				+ "FROM film ,`language` "
				+ "WHERE film.language_id = `language`.language_id ";
		PreparedStatement prst = con.prepareStatement(sql);
		ResultSet rs = prst.executeQuery();
		
		return rs;
	}

	public ResultSet FindLanguage(Connection con)
			throws SQLException {
		String sql = "select name,language_id from language ";
		PreparedStatement prst = con.prepareStatement(sql);
		ResultSet rs = prst.executeQuery();
		return rs;
	}

	public ResultSet FindFilm(Connection con, Integer id) throws SQLException {
		String sql = "select * from film where film_id=?";
		PreparedStatement prst = con.prepareCall(sql);
		return prst.executeQuery();
	}

	public ResultSet FindLanguageByLanguage_ID(Connection con, Integer id)
			throws SQLException {
		return null;
	}

}
