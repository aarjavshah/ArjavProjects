package com.cts.pharma.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Arrays;

import org.apache.log4j.Logger;

import com.cts.pharma.bo.BatchBO;
import com.cts.pharma.constants.DataBaseConstants;
import com.cts.pharma.constants.LoggerConstants;
import com.cts.pharma.vo.BatchVO;

/**
 * Batch Database Access Object Class
 * 
 * @version 1
 * @author 454579(Fenil Tailor)
 * */
public class BatchDAO implements IBatchDAO {

	/**
	 * Logger object
	 * */
	public static final Logger LOG = Logger.getLogger(BatchDAO.class);

	/**
	 * Add Batch Business Logic function
	 **/
	public boolean addDetails(BatchVO temp) {
		int x = 0;
		String wrange = null;
		int shipping_charge = 0;
		boolean exit = true;
		Connection dbconnect = null;
		ResultSet res = null;
		java.sql.PreparedStatement stm = null;

		while (exit) {
			try {
				/* Get the Connection of the database */
				Class.forName(DataBaseConstants.DRIVER);
				dbconnect = DriverManager.getConnection(
						DataBaseConstants.DATABASENAME,
						DataBaseConstants.DATABASEUSERNAME,
						DataBaseConstants.DATABASEPASSWORD);
				/*
				 * Calculate the shipping charge based on weight and
				 * medicinetype
				 */
				shipping_charge = getShippingCharges(temp.getWeight(),
						Character.toString(temp.getMedicinetype()));
				/*
				 * PrepareStatement for adding the batch to database
				 */
				stm = dbconnect
						.prepareStatement(DataBaseConstants.QUERY_ADDBATCH);
				LOG.info("In add batch function");
				/* Setting up the parameter into the parameterized query */
				stm.setString(1, temp.getBatchcode());
				stm.setString(2, temp.getMedicinecode());
				stm.setInt(3, temp.getWeight());
				stm.setInt(4, temp.getPrice());
				stm.setString(5, Character.toString(temp.getMedicinetype()));
				stm.setInt(6, temp.getShippingcharge());
				stm.setString(7, temp.getLevel());
				/*
				 * if(temp.getRefregeration().equalsIgnoreCase("yes"))
				 * stm.setInt(6, (int) (shipping_charge*1.05)); else
				 * if(temp.getRefregeration().equalsIgnoreCase("no"))
				 * stm.setInt(6, (int) (shipping_charge));
				 * 
				 * if(temp.getMedicinetype()=='T' ||
				 * temp.getMedicinetype()=='t') stm.setString(7, "High"); else
				 * if(temp.getMedicinetype()=='C' ||
				 * temp.getMedicinetype()=='c') stm.setString(7, "Normal"); else
				 * if(temp.getMedicinetype()=='S' ||
				 * temp.getMedicinetype()=='s') stm.setString(7, "Extr High");
				 */
				x = stm.executeUpdate();
				LOG.info("AddBatch Query Execution");
				exit = false;
			}

			catch (Exception e) {
				// System.out.println(e.getMessage());
				LOG.info("in addDetails() "
						+ LoggerConstants.ERROR_DAO_EXCEPTION);
				LOG.info("Batchcode Conflict");
				exit = false;
				x = 0;
				continue;
			}

			finally {
				try {
					res.close();
					stm.close();
					dbconnect.close();
				} catch (Exception e) {
					// LOG.error("in addDetails() "
					// + LoggerConstants.ERROR_DAO_EXCEPTION);
				}
			}
		}
		if (x != 0) {
			LOG.info("Batch " + temp.getBatchcode() + " added");
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Delete Batch Business Logic function
	 **/

	public boolean deleteDetails(String deletebatchcode) {
		int i = 0;
		Connection dbconnect = null;
		ResultSet res = null;
		java.sql.PreparedStatement stm = null;
		if (checkBatchCode(deletebatchcode)) {
			try {
				/* Get the Connection of the database */
				Class.forName(DataBaseConstants.DRIVER);
				dbconnect = DriverManager.getConnection(
						DataBaseConstants.DATABASENAME,
						DataBaseConstants.DATABASEUSERNAME,
						DataBaseConstants.DATABASEPASSWORD);
				/* PrepareStatement for Deleting Batchcode */
				stm = dbconnect
						.prepareStatement(DataBaseConstants.QUERY_DELETEBATCH);
				stm.setString(1, deletebatchcode);
				i = stm.executeUpdate();
				LOG.info("In Delete Function");
			} catch (Exception e) {
				// e.printStackTrace();
				LOG.info("in deleteDetails() "
						+ LoggerConstants.ERROR_DAO_EXCEPTION);
				i = 0;
			} finally {
				try {
					res.close();
					stm.close();
					dbconnect.close();
				} catch (Exception e) {
					// LOG.error("in deleteDetails() "
					// + LoggerConstants.ERROR_DAO_EXCEPTION);
				}
			}
		}

		if (i != 0) {
			LOG.info("Batch " + deletebatchcode + " deleted");
			return true;

		} else
			return false;

	}

	/**
	 * Search Batch Business Logic function
	 **/

	public BatchVO searchDetails(String batchcode) {
		int i = 0;
		String medicincecode = "", Refregeration = "", level = "";
		int weight = 0, price = 0, shipping_charge = 0;
		char medicinetypecode = '\0';
		BatchVO ret_bean = null;
		Connection dbconnect = null;
		ResultSet res = null;
		java.sql.PreparedStatement stm = null;

		if (new BatchDAO().checkBatchCode(batchcode)) {
			try {
				/* Get the Connection of the database */
				Class.forName(DataBaseConstants.DRIVER);
				dbconnect = DriverManager.getConnection(
						DataBaseConstants.DATABASENAME,
						DataBaseConstants.DATABASEUSERNAME,
						DataBaseConstants.DATABASEPASSWORD);
				/* PrepareStatement for Deleting Batchcode */
				stm = dbconnect
						.prepareStatement(DataBaseConstants.QUERY_SEARCHBATCH1);
				stm.setString(1, batchcode);
				ResultSet re = stm.executeQuery();
				LOG.info("In Search Function");
				if (re.next()) {
					LOG.info("Retrieving the values from database");
					i = 1;
					medicincecode = re.getString(2);
					weight = re.getInt(3);
					price = re.getInt(4);
					medicinetypecode = re.getString(5).charAt(0);
					shipping_charge = re.getInt(6);
					/*
					 * System.out.println("");
					 * System.out.format("%-20s%-20s\n","BATCHCODE",batchcode);
					 * System
					 * .out.format("%-20s%-20s\n","MEDICINECODE",medicincecode);
					 * System.out.format("%-20s%-20s\n","WEIGHT",weight);
					 * System.out.format("%-20s%-20s\n","PRICE",price);
					 * System.out
					 * .format("%-20s%-20s\n","MEDICINE TYPE CODE",String
					 * .valueOf(medicinetypecode));
					 */
					stm = dbconnect
							.prepareStatement(DataBaseConstants.QUERY_SEARCHBATCH2);
					stm.setInt(1, shipping_charge);
					re = stm.executeQuery();
					if (re.next()) {
						// System.out.format("%-20s%-20s\n","REFREGERATION","NO");
						Refregeration = "No";
					} else {
						// System.out.format("%-20s%-20s\n","REFREGERATION","YES");
						Refregeration = "Yes";
					}
					// System.out.println("");
					ret_bean = new BatchBO().setBatchVO(batchcode,
							medicincecode, weight, price, medicinetypecode,
							Refregeration);
					LOG.info("Setting the BatchVO");
				}
			} catch (Exception e) {
				i = 0;
				LOG.info("in searchDetails() "
						+ LoggerConstants.ERROR_DAO_EXCEPTION);
			} finally {
				try {
					res.close();
					stm.close();
					dbconnect.close();
				} catch (Exception e) {
					// LOG.error("in searchDetails() "
					// + LoggerConstants.ERROR_DAO_EXCEPTION);
				}
			}
		}
		LOG.info("Batch " + batchcode + " was searched");
		return ret_bean;
	}

	/**
	 * Update Batch Business Logic function
	 **/

	public boolean updateDetails(BatchVO temp, String batchcode) {
		int x = 0, y = 0;
		int shipping_charge = 0;
		boolean exit = true;
		Connection dbconnect = null;
		ResultSet res = null;
		java.sql.PreparedStatement stm = null;

		while (exit) {
			try {
				/* Get the Connection of the database */
				Class.forName(DataBaseConstants.DRIVER);
				dbconnect = DriverManager.getConnection(
						DataBaseConstants.DATABASENAME,
						DataBaseConstants.DATABASEUSERNAME,
						DataBaseConstants.DATABASEPASSWORD);
				/*
				 * Calculate the shipping charge based on weight and
				 * medicinetype
				 */
				shipping_charge = getShippingCharges(temp.getWeight(),
						Character.toString(temp.getMedicinetype()));
				/* PrepareStatement for Updating Batchcode */
				stm = dbconnect
						.prepareStatement(DataBaseConstants.QUERY_UPDATEBATCH);
				LOG.info("In Update Function");
				/* Setting up the parameter into the parameterized query */
				stm.setString(1, temp.getBatchcode());
				stm.setString(2, temp.getMedicinecode());
				stm.setInt(3, temp.getWeight());
				stm.setInt(4, temp.getPrice());
				stm.setString(5, Character.toString(temp.getMedicinetype()));
				stm.setInt(6, temp.getShippingcharge());
				stm.setString(7, temp.getLevel());
				/*
				 * if(temp.getRefregeration().equalsIgnoreCase("yes"))
				 * stm.setInt(6, (int) (shipping_charge*1.05)); else
				 * if(temp.getRefregeration().equalsIgnoreCase("no"))
				 * stm.setInt(6, (int) (shipping_charge));
				 * 
				 * if(temp.getMedicinetype()=='T' ||
				 * temp.getMedicinetype()=='t') stm.setString(7, "High"); else
				 * if(temp.getMedicinetype()=='C' ||
				 * temp.getMedicinetype()=='c') stm.setString(7, "Normal"); else
				 * if(temp.getMedicinetype()=='S' ||
				 * temp.getMedicinetype()=='s') stm.setString(7, "Extr High");
				 */
				stm.setString(8, batchcode);

				x = stm.executeUpdate();
				LOG.info("Update Query Execution");
				exit = false;
			}

			catch (Exception e) {
				// System.out.println(e.getMessage());
				LOG.info("in updateDetails() "
						+ LoggerConstants.ERROR_DAO_EXCEPTION);
				LOG.info("Batchcode Conflict");
				exit = false;
				x = 0;
				continue;
			} finally {
				try {
					res.close();
					stm.close();
					dbconnect.close();
				} catch (Exception e) {
					// LOG.error("in updateDetails() "
					// + LoggerConstants.ERROR_DAO_EXCEPTION);
				}
			}
		}
		if (x != 0) {
			LOG.info("Batch " + batchcode + " updated");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retrieve Shipping Charge from database
	 * */

	public int getShippingCharges(int weight, String medicineType) {
		int shipping_charge = 0;
		Connection dbconnect = null;
		ResultSet res = null;
		java.sql.PreparedStatement stm = null;
		/* Get the Connection of the database */
		try {
			Class.forName(DataBaseConstants.DRIVER);
			dbconnect = DriverManager.getConnection(
					DataBaseConstants.DATABASENAME,
					DataBaseConstants.DATABASEUSERNAME,
					DataBaseConstants.DATABASEPASSWORD);
			/* PrepareStatement for Getting Shipping Charge */
			stm = dbconnect.prepareStatement(DataBaseConstants.QUERY_SHP_CHRG);
			// LOG.info("setting values for getshiiping charge query");
			stm.setInt(1, weight);
			stm.setInt(2, weight);
			stm.setString(3, medicineType);
			ResultSet re = stm.executeQuery();
			LOG.info("Calculating shippingCharges");
			if (re.next()) {
				shipping_charge = re.getInt(1);
			}
		} catch (Exception e) {
			LOG.info("in getShippingCharges() "
					+ LoggerConstants.ERROR_DAO_EXCEPTION);
		} finally {
			try {
				res.close();
				stm.close();
				dbconnect.close();
			} catch (Exception e) {
				// LOG.error("in getShippingCharges() "
				// + LoggerConstants.ERROR_DAO_EXCEPTION);
			}
		}
		return shipping_charge;
	}

	/**
	 * Check if the batch exist in database or not
	 **/

	public boolean checkBatchCode(String batchcode) {
		ResultSet re = null;
		boolean ret = false;
		Connection dbconnect = null;
		ResultSet res = null;
		java.sql.PreparedStatement stm = null;
		/* Get the Connection of the database */
		try {
			Class.forName(DataBaseConstants.DRIVER);
			dbconnect = DriverManager.getConnection(
					DataBaseConstants.DATABASENAME,
					DataBaseConstants.DATABASEUSERNAME,
					DataBaseConstants.DATABASEPASSWORD);
			/* PrepareStatement for Checking Batchcode */
			stm = dbconnect.prepareStatement(DataBaseConstants.QUERY_VBATCODE);

			stm.setString(1, batchcode);
			re = stm.executeQuery();
			LOG.info("validating BatchCode");
			if (re.next()) {
				ret = true;
			} else {
				ret = false;
			}
		} catch (Exception e) {
			LOG.info("in checkBatchCodes() "
					+ LoggerConstants.ERROR_DAO_EXCEPTION);
		} finally {
			try {
				res.close();
				stm.close();
				dbconnect.close();
			} catch (Exception e) {
				// LOG.error("in checkBatchCodes() "
				// + LoggerConstants.ERROR_DAO_EXCEPTION);
			}
		}
		return ret;
	}

	/**
	 * get the list of valid medicine codes
	 **/

	public String[] getMedicineCodes() {
		int size = 0;
		Connection dbconnect = null;
		ResultSet res = null;
		java.sql.PreparedStatement stm = null;
		try {
			/* Get the Connection of the database */
			Class.forName(DataBaseConstants.DRIVER);
			dbconnect = DriverManager.getConnection(
					DataBaseConstants.DATABASENAME,
					DataBaseConstants.DATABASEUSERNAME,
					DataBaseConstants.DATABASEPASSWORD);
			/*
			 * PrepareStatement for getting size of the list of Medicinecodes in
			 * the database
			 */
			stm = dbconnect
					.prepareStatement(DataBaseConstants.QUERY_GETMEDICODE1);
			res = stm.executeQuery();
			if (res.next()) {
				size = res.getInt(1);
				// System.out.println(size);
			} else {

			}
		} catch (Exception e) {
			LOG.info("in getMedicineCodes()"
					+ LoggerConstants.ERROR_DAO_EXCEPTION);
		}

		String medicinecode[] = new String[size];

		try {
			int i = 0;
			/* Get the Connection of the database */
			Class.forName(DataBaseConstants.DRIVER);
			dbconnect = DriverManager.getConnection(
					DataBaseConstants.DATABASENAME,
					DataBaseConstants.DATABASEUSERNAME,
					DataBaseConstants.DATABASEPASSWORD);
			/*
			 * PrepareStatement for getting the list of Medicinecodes in the
			 * database
			 */
			stm = dbconnect
					.prepareStatement(DataBaseConstants.QUERY_GETMEDICODE2);
			res = stm.executeQuery();
			LOG.info("Getting MedicineCode from database");

			while (res.next()) {
				medicinecode[i++] = res.getString("MEDICINECODE").toUpperCase();
				// System.out.println(medicinecode[i++]);
			}
		} catch (Exception e) {
			LOG.info("in getMedicineCodes()"
					+ LoggerConstants.ERROR_DAO_EXCEPTION);
		} finally {
			try {
				res.close();
				stm.close();
				dbconnect.close();
			} catch (Exception e) {
				// LOG.error("in getMedicineCodes()"
				// + LoggerConstants.ERROR_DAO_EXCEPTION);
			}
		}
		Arrays.sort(medicinecode);
		return medicinecode;
	}

	/**
	 * Check if the medicine code is valid or not
	 **/

	public boolean checkMedicineCodes(String medicineCode) {
		ResultSet re = null;
		boolean ret = false;
		Connection dbconnect = null;
		ResultSet res = null;
		java.sql.PreparedStatement stm = null;
		try {
			/* Get the Connection of the database */
			Class.forName(DataBaseConstants.DRIVER);
			dbconnect = DriverManager.getConnection(
					DataBaseConstants.DATABASENAME,
					DataBaseConstants.DATABASEUSERNAME,
					DataBaseConstants.DATABASEPASSWORD);
			/* PrepareStatement for Checking Medicinecode */
			stm = dbconnect.prepareStatement(DataBaseConstants.QUERY_VMEDICODE);
			stm.setString(1, medicineCode);
			re = stm.executeQuery();
			LOG.info("Validating MedicineCode");
			if (re.next()) {
				ret = true;
			} else {
				ret = false;
			}
		} catch (Exception e) {
			LOG.info("in checkMedicineCodes() "
					+ LoggerConstants.ERROR_DAO_EXCEPTION);
		} finally {
			try {
				res.close();
				stm.close();
				dbconnect.close();
			} catch (Exception e) {
				// LOG.error("in checkMedicineCodes() "
				// + LoggerConstants.ERROR_DAO_EXCEPTION);
			}
		}
		return ret;
	}

	/**
	 * get the list of batch codes from database
	 * */

	public String[] getBatchCodes() {
		int size = 0;
		Connection dbconnect = null;
		ResultSet res = null;
		java.sql.PreparedStatement stm = null;
		try {
			/* Get the Connection of the database */
			Class.forName(DataBaseConstants.DRIVER);
			dbconnect = DriverManager.getConnection(
					DataBaseConstants.DATABASENAME,
					DataBaseConstants.DATABASEUSERNAME,
					DataBaseConstants.DATABASEPASSWORD);
			/*
			 * PrepareStatement for getting size of the list of Batchcodes in
			 * the database
			 */
			stm = dbconnect
					.prepareStatement(DataBaseConstants.QUERY_GETBATCODE1);
			res = stm.executeQuery();
			if (res.next()) {
				size = res.getInt(1);

			} else {
			}
		} catch (Exception e) {
			LOG.info("in getBatchCodes() "
					+ LoggerConstants.ERROR_DAO_EXCEPTION);
		}

		String batchcode[] = new String[size];
		// String originalBatchCode="";
		try {
			int i = 0;
			/* Get the Connection of the database */
			Class.forName(DataBaseConstants.DRIVER);
			dbconnect = DriverManager.getConnection(
					DataBaseConstants.DATABASENAME,
					DataBaseConstants.DATABASEUSERNAME,
					DataBaseConstants.DATABASEPASSWORD);
			/*
			 * PrepareStatement for getting the list of Batchcodes in the
			 * database
			 */
			stm = dbconnect
					.prepareStatement(DataBaseConstants.QUERY_GETBATCODE2);
			res = stm.executeQuery();
			LOG.info("Getting BatchCodes from database");
			while (res.next()) {
				batchcode[i++] = res.getString("BATCHCODE").toUpperCase();
			}
		} catch (Exception e) {
			LOG.info("in getBatchCodes() "
					+ LoggerConstants.ERROR_DAO_EXCEPTION);
		} finally {
			try {
				res.close();
				stm.close();
				dbconnect.close();
			} catch (Exception e) {
				// LOG.error("in getBatchCodes() "
				// + LoggerConstants.ERROR_DAO_EXCEPTION);
			}
		}
		Arrays.sort(batchcode);
		return batchcode;
	}

}