package service;

import impl.CusImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.CusDAO;
import entity.Customer;
import factory.ConFactory;

public class LoginService {
	
	private CusDAO dao = new CusImpl();
	
	public boolean check(Customer cus) {
		Connection con = null;
		try {
			con = ConFactory.getConFactory().getCon();
		//	System.out.println(con+"****************");
			con.setAutoCommit(false);
			ResultSet rs = dao.getCus(con,cus);
		//	System.out.println(dao.getU(con, user)+"&&&&&&&&&&&&&&&&&&&&&&");
			if(rs.next()){
				while(rs.next()){
					System.out.println(rs);
				}
				return true;
			}
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
