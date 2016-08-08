package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Film;

public interface FilmDAO {
	
	public int addF(Connection con,Film film) throws SQLException;
	
	public int delF(Connection con,Film film) throws SQLException;
	
	public int updF(Connection con,Film film) throws SQLException;
	
	public ResultSet listF(Connection con) throws SQLException;
	
	public ResultSet FindLanguage (Connection con) throws SQLException;
	
	public ResultSet FindFilm (Connection con,Integer id) throws SQLException;
	
	public ResultSet FindLanguageByLanguage_ID (Connection con,Integer id) throws SQLException;
	
}
