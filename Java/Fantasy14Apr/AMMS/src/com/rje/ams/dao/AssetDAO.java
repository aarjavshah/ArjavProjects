package com.rje.ams.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import com.rje.ams.constants.DatabaseConstants;
import com.rje.ams.vo.AssetDetailsVO;

public class AssetDAO {
	public static int AddAsset(AssetDetailsVO asset){
		int added = 0;
		Connection con = null;
		PreparedStatement addAsset = null;
		try {
			con = DBConnection.GetDBConnection();
			addAsset = (PreparedStatement) con.prepareStatement(DatabaseConstants.INSERT_INTO_ASSET_REGISTER);
			addAsset.setString(1, asset.getAssetID());
			addAsset.setString(2, asset.getAssetName());
			addAsset.setString(3, asset.getModel());
			addAsset.setString(4, asset.getManufacturer());
			addAsset.setString(5, asset.getSrNo());
			addAsset.setString(6, asset.getLocation());
			addAsset.setInt(7, asset.isAvailibile()?1:0);
			added = addAsset.executeUpdate();
			DBConnection.TerminateConnection(con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return added;
	}
	
	public static int RemoveAsset(String assetID){
		int removed = 0;
		PreparedStatement removeAsset = null;
		try {
			Connection con = DBConnection.GetDBConnection();
			removeAsset = (PreparedStatement) con.prepareStatement(DatabaseConstants.DELETE_FROM_ASSET_REGISTER);
			removeAsset.setString(1, assetID);
			removed = removeAsset.executeUpdate();
			DBConnection.TerminateConnection(con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return removed;
	}
	
	public static int EditAsset(AssetDetailsVO asset,String oldAssetID){
		int updated = 0;
		Connection con = null;
		PreparedStatement editAsset = null;
		try {
			con = DBConnection.GetDBConnection();
			editAsset = (PreparedStatement) con.prepareStatement(DatabaseConstants.UPDATE_ASSET_REGISTER);
			editAsset.setString(1, asset.getAssetID());
			editAsset.setString(2, asset.getAssetName());
			editAsset.setString(3, asset.getModel());
			editAsset.setString(4, asset.getManufacturer());
			editAsset.setString(5, asset.getSrNo());
			editAsset.setString(6, asset.getLocation());
			editAsset.setInt(7, asset.isAvailibile()?1:0);
			editAsset.setString(8, oldAssetID);
			updated = editAsset.executeUpdate();
			DBConnection.TerminateConnection(con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updated;
	}
	
	public static int ChangeAvailability(String assetID,int operation){
		int updated = 0;
		Connection con = null;
		PreparedStatement toggleAvailability = null;
		try {
			con = DBConnection.GetDBConnection();
			toggleAvailability = (PreparedStatement) con.prepareStatement(DatabaseConstants.UPDATE_ASSSET_REGISTER_UNAVAILABLE);
			toggleAvailability.setInt(1, operation);
			toggleAvailability.setString(2, assetID);
			updated = toggleAvailability.executeUpdate();
			DBConnection.TerminateConnection(con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updated;
	}
	
	public static int CountAssets(){
		int count = 0;
		Connection con = null;
		PreparedStatement counter = null;
		try {
			con = DBConnection.GetDBConnection();
			counter = (PreparedStatement) con.prepareStatement(DatabaseConstants.COUNT_RECORDS);
			ResultSet res = counter.executeQuery();
			if(res.next()){
				count = res.getInt(1);
			}
			DBConnection.TerminateConnection(con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
