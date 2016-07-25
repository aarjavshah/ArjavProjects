package com.rje.ams.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.rje.ams.constants.DatabaseConstants;
import com.rje.ams.vo.LendingDetailsVO;

public class LendingDAO {
	public static int CheckOut(LendingDetailsVO vo){
		int checkedOut = 0;
		PreparedStatement chkOut = null;
		try {
			Connection con = DBConnection.GetDBConnection();
			chkOut = (PreparedStatement) con.prepareStatement(DatabaseConstants.INSERT_INTO_LENDING_REGISTER);
			chkOut.setString(1, vo.getTransactionID());
			chkOut.setString(2, vo.getAssetID());
			chkOut.setString(3, vo.getUserID());
			chkOut.setString(4, vo.getChkOutDt());
			chkOut.setString(5, vo.getChkOutTm());
			chkOut.setString(6, vo.getChkInDt());
			chkOut.setString(7, vo.getChkInTm());
			chkOut.setInt(8, vo.getReturnStatus());
			checkedOut = chkOut.executeUpdate();
			DBConnection.TerminateConnection(con);
			AssetDAO.ChangeAvailability(vo.getAssetID(), 0);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkedOut;		
	}
	public static int CheckIn(LendingDetailsVO vo){
		int checkedIn = 0;
		PreparedStatement chkIn = null;
		try {
			Connection con = DBConnection.GetDBConnection();
			chkIn = (PreparedStatement) con.prepareStatement(DatabaseConstants.UPDATE_LENDING_REGISTER);
			chkIn.setString(1, vo.getChkInDt());
			chkIn.setString(2, vo.getChkInTm());
			chkIn.setInt(3, vo.getReturnStatus());
			chkIn.setString(4, vo.getTransactionID());
			checkedIn = chkIn.executeUpdate();
			DBConnection.TerminateConnection(con);
			AssetDAO.ChangeAvailability(vo.getAssetID(), 1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkedIn;		
	}
}
