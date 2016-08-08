package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Customer;

public interface CusDAO {
	//判断登录名是否存在
	public ResultSet getCus(Connection con,Customer cus) throws SQLException;
}
