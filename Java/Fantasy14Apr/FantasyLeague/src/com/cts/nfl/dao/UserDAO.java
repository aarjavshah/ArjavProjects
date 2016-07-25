package com.cts.nfl.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.cts.nfl.constants.DataBaseConstants;
import com.cts.nfl.vo.UserVO;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * UserDatabaseAccessObject Class
 * 
 * @version 1
 * @author ARJAV
 * */

public class UserDAO {

	Logger LOG = Logger.getLogger(UserDAO.class);

	@SuppressWarnings("resource")
	public int UserValidation(UserVO userVO) {
		int isvalid = 0;
		String username = userVO.getUsername();
		String password = userVO.getPassword();
		Connection dbconnect = null;
		PreparedStatement stm = null;
		ResultSet res = null;
		ResultSet res1 = null;

		try {
			/* Get the Connection of the database */
			Class.forName(DataBaseConstants.DRIVER);
			dbconnect = (Connection) DriverManager.getConnection(
					DataBaseConstants.DATABASENAME,
					DataBaseConstants.DATABASEUSERNAME,
					DataBaseConstants.DATABASEPASSWORD);
			/*
			 * PrepareStatement for login into the account of specific user
			 * whose activation bit is not zero
			 */
			stm = (PreparedStatement) dbconnect
					.prepareStatement(DataBaseConstants.QUERY_VUSER_1);
			stm.setString(1, username);
			stm.setString(2, password);

			res = stm.executeQuery();

			if (res.next()) {
				/*
				 * If password matches to the password in the database then
				 * return 1
				 */
				isvalid = 1;
			} else {
				/*
				 * PrepareStatement for login into the account of specific user
				 * whose activation bit is not zero and password is wrong
				 */
				stm = (PreparedStatement) dbconnect
						.prepareStatement(DataBaseConstants.QUERY_VUSER_2);
				stm.setString(1, username);
				res = stm.executeQuery();
				if (res.next()) {
					/*
					 * PrepareStatement for decreasing the activation bit of the
					 * specific username
					 */
					stm = (PreparedStatement) dbconnect
							.prepareStatement(DataBaseConstants.QUERY_VUSER_3);
					stm.setString(1, username);
					stm.executeUpdate();

					/*
					 * PrepareStatement for warn the user that last valid
					 * attempt remaining before deactivation of the account
					 */
					stm = (PreparedStatement) dbconnect
							.prepareStatement(DataBaseConstants.QUERY_VUSER_4);
					stm.setString(1, username);
					res1 = stm.executeQuery();
					if (res1.next()) {
						isvalid = 2;
					}
					/*
					 * PrepareStatement for checking whether activation bit of
					 * specific user is 0 or not
					 */
					stm = (PreparedStatement) dbconnect
							.prepareStatement(DataBaseConstants.QUERY_VUSER_5);
					stm.setString(1, username);
					res1 = stm.executeQuery();
					if (res1.next()) {
						isvalid = 3;
					}
				} else {
					stm = (PreparedStatement) dbconnect
							.prepareStatement(DataBaseConstants.QUERY_VUSER_6);
					stm.setString(1, username);
					/*
					 * PrepareStatement for checking whether activation bit of
					 * specific user is 0 or not
					 */
					res = stm.executeQuery();
					if (res.next()) {
						isvalid = 4;
					} else {
						isvalid = 0;
					}
				}
			}
		}

		catch (Exception e) {
		} finally {
			try {
				res.close();
				res1.close();
				stm.close();
				dbconnect.close();

			} catch (Exception e) {

			}
		}
		return isvalid;
	}

	public String GetQuestion(String username) {
		String question = null;
		Connection dbconnect = null;
		ResultSet res = null;
		java.sql.PreparedStatement stm = null;

		try {
			// System.out.println("4");

			/* Get the Connection of the database */
			Class.forName(DataBaseConstants.DRIVER);
			dbconnect = (Connection) DriverManager.getConnection(
					DataBaseConstants.DATABASENAME,
					DataBaseConstants.DATABASEUSERNAME,
					DataBaseConstants.DATABASEPASSWORD);
			// System.out.println("5");

			/*
			 * PrepareStatement for getting security question of the specific
			 * user
			 */
			stm = (PreparedStatement) dbconnect
					.prepareStatement(DataBaseConstants.QUERY_GETQUES);
			stm.setString(1, username);
			// System.out.println("1");
			ResultSet re = stm.executeQuery();
			// System.out.println("2");
			if (re.next()) {
				question = re.getString(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			question = null;
		}
		return question;
	}

	public boolean AnswerCheck(String answer, String username) {
		boolean ret = false;
		Connection dbconnect = null;
		ResultSet res = null;
		java.sql.PreparedStatement stm = null;
		try {
			/* Get the Connection of the database */
			Class.forName(DataBaseConstants.DRIVER);
			dbconnect = (Connection) DriverManager.getConnection(
					DataBaseConstants.DATABASENAME,
					DataBaseConstants.DATABASEUSERNAME,
					DataBaseConstants.DATABASEPASSWORD);
			// System.out.println("5");
			/*
			 * PrepareStatement for checking the answer of the security question
			 * of specific user
			 */
			stm = (PreparedStatement) dbconnect
					.prepareStatement(DataBaseConstants.QUERY_VANS_1);
			stm.setString(1, username);
			stm.setString(2, answer);
			res = stm.executeQuery();
			if (res.next()) {
				/*
				 * PrepareStatement for setting up the activation bit to the
				 * maximum of the specific user if the answer matches with the
				 * answer of the database
				 */
				stm = (PreparedStatement) dbconnect
						.prepareStatement(DataBaseConstants.QUERY_VANS_2);
				stm.setString(1, username);
				stm.executeUpdate();
				ret = true;
			}
		} catch (Exception e) {

		}
		return ret;
	}

	/**
	 * reset the deactivation count once the user logs in
	 * */
	public void reactivationafterexit(String username) {
		Connection dbconnect = null;
		ResultSet res = null;
		java.sql.PreparedStatement stm = null;
		try {
			/* Get the Connection of the database */
			Class.forName(DataBaseConstants.DRIVER);
			dbconnect = (Connection) DriverManager.getConnection(
					DataBaseConstants.DATABASENAME,
					DataBaseConstants.DATABASEUSERNAME,
					DataBaseConstants.DATABASEPASSWORD);
			/*
			 * PrepareStatement for setting up the activation bit to the maximum
			 * of the specific user who currently logged in
			 */
			stm = (PreparedStatement) dbconnect
					.prepareStatement(DataBaseConstants.REACT_USER);
			stm.setString(1, username);
			stm.executeUpdate();
			LOG.info("User " + username + " Logging out");
		}

		catch (Exception e) {
		} finally {
			try {
				res.close();
				stm.close();
				dbconnect.close();
			} catch (Exception e) {

			}
		}
	}

	public boolean passwordReset(String username, String passwordNew) {
		Connection dbconnect = null;
		ResultSet res = null;
		java.sql.PreparedStatement stm = null;
		int x = 0;
		try {
			/* Get the Connection of the database */
			Class.forName(DataBaseConstants.DRIVER);
			dbconnect = (Connection) DriverManager.getConnection(
					DataBaseConstants.DATABASENAME,
					DataBaseConstants.DATABASEUSERNAME,
					DataBaseConstants.DATABASEPASSWORD);
			/*
			 * PrepareStatement for resetting the password of specific user
			 */
			stm = (PreparedStatement) dbconnect
					.prepareStatement(DataBaseConstants.RESET_PASSWORD);
			stm.setString(1, passwordNew);
			stm.setString(2, username);

			x = stm.executeUpdate();

		}

		catch (Exception e) {
		} finally {
			try {
				res.close();
				stm.close();
				dbconnect.close();
			} catch (Exception e) {

			}
		}
		if (x != 0) {
			return true;
		} else {
			return false;
		}
	}
}
