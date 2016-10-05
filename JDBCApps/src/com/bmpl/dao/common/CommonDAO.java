package com.bmpl.dao.common;
import static com.bmpl.dao.common.DBConstants.DB_CONFIG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


// Singleton = Only One Object is get Created
// DAO - Data Access Object 
public class CommonDAO {
	
	private static CommonDAO commonDAO ;
	private CommonDAO(){
		
	}
	
	public static CommonDAO getInstance(){
		if(commonDAO == null){
			commonDAO= new CommonDAO();
		}
		return commonDAO;
	}
	
	
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		ResourceBundle rb = ResourceBundle.getBundle(DB_CONFIG);
		String driverName = rb.getString("drivername");
		String dbURL = rb.getString("dburl");
		String dbUserid = rb.getString("userid");
		String dbPassword = rb.getString("password");
		
		Class.forName(driverName);
		
		// Step -2 Create Connection
		Connection con = DriverManager.
				getConnection(dbURL,dbUserid,dbPassword);
		return con;
	}

}
