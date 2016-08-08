package factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ConFactory {
	
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	
	static{
		Properties prop = new Properties();
		InputStream is  = ConFactory.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = prop.getProperty("driver");
		dburl = prop.getProperty("dburl");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}
	
	private ConFactory(){
	}
	
	private static final ConFactory factory = new ConFactory();
	
	public static ConFactory getConFactory(){
		return factory;
	}
	
	Connection con = null;
	
	public Connection getCon(){
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dburl,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
