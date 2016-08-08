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
		String sql = "select first_name from customer where first_name=? ";
		PreparedStatement prst = con.prepareStatement(sql);
		prst.setString(1, cus.getFirst_name());
		return prst.executeQuery();
	}

	
}
