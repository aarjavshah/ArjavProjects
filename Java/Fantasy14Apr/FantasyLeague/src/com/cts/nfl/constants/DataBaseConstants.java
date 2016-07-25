package com.cts.nfl.constants;

/**
 * Database Constants Class
 * 
 * @version 1
 * @This class contains the constant declarations related to database
 * @author 454591(Dev Gaba)
 * */
public final class DataBaseConstants {

	private DataBaseConstants() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * The Database location
	 */
	public static final String DATABASENAME = "jdbc:mysql://localhost/pharma";

	/**
	 * The Database drivers
	 */

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	/**
	 * Data base user name
	 */
	public static final String DATABASEUSERNAME = "root";
	/**
	 * Data base password
	 */
	public static final String DATABASEPASSWORD = "root";
	/**
	 * insert query to add batch details
	 */
	public static final String QUERY_ADDBATCH = "insert into batch_info values(?,?,?,?,?,?,?)";

	/**
	 * delete query to delete batch details
	 */
	public static final String QUERY_DELETEBATCH = "delete from batch_info where batchcode=? ";

	/**
	 * update query to update batch details
	 */
	public static final String QUERY_UPDATEBATCH = "update batch_info set batchcode=?,medicinecode=?,weight=?,price=?,medicinetypecode=?,shipping_charge=?,level=? where batchcode=?";

	/**
	 * select query to search batch details
	 */
	public static final String QUERY_SEARCHBATCH1 = "select * from batch_info where batchcode=?";
	/**
	 * select query to calculate shipping charge for searched batch
	 */
	public static final String QUERY_SEARCHBATCH2 = "select shipping_charge from shipping_master where shipping_charge=?";

	/**
	 * Check whether the Batch code already exists or not
	 */
	public static final String QUERY_VBATCODE = "select * from batch_info where batchcode=?";

	/**
	 * Select query to verify the medicine code entered by the user
	 */
	public static final String QUERY_VMEDICODE = "select * from medicine_master where medicinecode=?";
	/**
	 * Select query to get the length of the list of the existing medicine code
	 */
	public static final String QUERY_GETMEDICODE1 = "select count(*) from medicine_master";
	/**
	 * Select query to get the list of the existing medicine code
	 */
	public static final String QUERY_GETMEDICODE2 = "select * from medicine_master";
	/**
	 * Select query to get the length of the list of the existing batch code
	 */
	public static final String QUERY_GETBATCODE1 = "select count(*) from batch_info";
	/**
	 * Select query to get the list of the existing batch code
	 */
	public static final String QUERY_GETBATCODE2 = "select BATCHCODE from batch_info";

	/**
	 * Query to calculate the Shipping Charge
	 */
	public static final String QUERY_SHP_CHRG = "select shipping_charge from shipping_master a,shipping_weight_master b where a.weight_range=b.weight_range and b.weight_range =(select weight_range from shipping_weight_master where min_weight<=? and max_weight>=?) and a.medicinetypecode=?";

	/**
	 * select query for validating the user
	 * */
	public static final String QUERY_VUSER_1 = "select * from users_master where username=? and password=?";// and activation_bit!=0";
	/**
	 * select query for checking the correctness of the username
	 * */
	public static final String QUERY_VUSER_2 = "select * from users_master where username=? and activation_bit!=0";

	/**
	 * update query for reducing activation bit on invalid login by a valid user
	 * */
	public static final String QUERY_VUSER_3 = "update users_master set activation_bit=activation_bit-1 where username=?";

	/**
	 * select query to check the attempt being last or not
	 * */
	public static final String QUERY_VUSER_4 = "select * from users_master where username=? and activation_bit=1";

	/**
	 * select query to check the user being deactivated
	 * */
	public static final String QUERY_VUSER_5 = "select * from users_master where username=? and activation_bit=0";
	/**
	 * select query to check the user being deactivated
	 * */
	public static final String QUERY_VUSER_6 = "select * from users_master where username=? and activation_bit=0";

	/**
	 * select query to retrieve question from the database for a particular user
	 * */
	public static final String QUERY_GETQUES = "select questions from users_master a,questions_master b where a.question_id=b.question_id  and a.username=?";

	/**
	 * select query to verify the answer to the security question
	 * */
	public static final String QUERY_VANS_1 = "select * from users_master where username=?  and secret_answer=?";
	/**
	 * reset the activation bit to 3
	 * */
	public static final String QUERY_VANS_2 = "update users_master set activation_bit=3 where username=?";
	/**
	 * reset the activation bit to 3
	 * */
	public static final String REACT_USER = "update users_master set activation_bit=3 where username=?";
	/**
	 * password change query
	 * */
	public static final String RESET_PASSWORD = "update users_master set password=? where username=?";
}
