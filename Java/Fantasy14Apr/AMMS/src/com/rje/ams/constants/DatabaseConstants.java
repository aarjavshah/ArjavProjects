package com.rje.ams.constants;
/**
 * Database Constants Class
 * 
 * @version 1
 * @This class contains the constant declarations related to database
 * @author ARJAV
 * */
public class DatabaseConstants {
	/**
	 * The Database location
	 */
	public static final String DATABASE_NAME = "jdbc:mysql://localhost/amms";
	/**
	 * The Database drivers
	 */
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	/**
	 * Data base user name
	 */
	public static final String DATABASE_USERNAME = "root";
	/**
	 * Data base password
	 */
	public static final String DATABASE_PASSWORD = "root";
	/**
	 * Add a new asset : Insert statement
	 */	
	public static final String INSERT_INTO_ASSET_REGISTER = "INSERT INTO ASSET_REGISTER VALUES(?,?,?,?,?,?,?)";
	/**
	 * Edit an existing asset : Update statement
	 */	
	public static final String UPDATE_ASSET_REGISTER = "UPDATE ASSET_REGISTER SET ASSET_ID=?, EQUIPMENT_NAME=?, MODEL=?, MANUFACTURER=?, SERIAL_NUM=?, LOCATION=?, AVAILABILITY=? WHERE ASSET_ID=?" ;
	/**
	 * Remove an existing asset : Delete statement
	 */	
	public static final String DELETE_FROM_ASSET_REGISTER = "DELETE FROM ASSET_REGISTER WHERE ASSET_ID=?" ;
	/**
	 * Lend an asset : Insert statement
	 */
	public static final String INSERT_INTO_LENDING_REGISTER = "INSERT INTO LENDING_REGISTER VALUES(?,?,?,?,?,?,?,?)";
	/**
	 * Return the borrowed asset : Update statement
	 */
	public static final String UPDATE_LENDING_REGISTER = "UPDATE LENDING_REGISTER SET CHKIN_DT=?, CHKIN_TM=?, RETURN_STATUS=? WHERE TRANSACTION_ID=?";
	/**
	 * Make Asset Unavailable: Update statement(Lending/Return)
	 */
	public static final String UPDATE_ASSSET_REGISTER_UNAVAILABLE = "UPDATE ASSET_REGISTER SET AVAILABILITY=? WHERE ASSET_ID=?" ;
	/**
	 * Count number of assets in the inventory
	 */
	public static final String COUNT_RECORDS = "SELECT COUNT(*) FROM ASSET_REGISTER";
	
}
