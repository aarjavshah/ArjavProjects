package com.rje.ams.dao;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.rje.ams.constants.DatabaseConstants;
import com.mysql.jdbc.Connection;
public class DBConnection {
	public static Connection GetDBConnection() throws SQLException, ClassNotFoundException{
		Connection dbconnect = null;
		Class.forName(DatabaseConstants.DRIVER);
		dbconnect = (Connection) DriverManager.getConnection(
				DatabaseConstants.DATABASE_NAME,
				DatabaseConstants.DATABASE_USERNAME,
				DatabaseConstants.DATABASE_PASSWORD);
		return dbconnect;
	}
	
	public static void TerminateConnection(Connection dbconnect) throws SQLException{
		dbconnect.close();
	}
	
}
