package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.CusDAO;
import entity.Customer;
import entity.Film;

public class CusImpl implements CusDAO {

	public ResultSet getCus(Connection con,Customer cus) throws SQLException {
		String sql = "select fist_name from customer where fist_name=? ";
		PreparedStatement prst = con.prepareStatement(sql);
		return prst.executeQuery();
	}

	
}
