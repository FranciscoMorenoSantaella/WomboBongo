package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Conexion {
	private static Connection con;
	private final static String server=XMLReader.getConectionInfo("server");
	private final static String database=XMLReader.getConectionInfo("database");
	private final static String username=XMLReader.getConectionInfo("user");
	private final static String password=XMLReader.getConectionInfo("password");
	
	public static void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(server+"/"+database,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			con=null;
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		if(con==null) {
			connect();
		}
		return con;
	}
}
