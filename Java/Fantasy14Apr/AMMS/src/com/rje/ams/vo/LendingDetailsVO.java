package com.rje.ams.vo;

public class LendingDetailsVO {
	private String transactionID;
	private String assetID;
	private String userID;
	private String chkOutDt;
	private String chkOutTm;
	private String chkInDt;
	private String chkInTm;
	private int returnStatus;
	
	
	
	public LendingDetailsVO(String transactionID, String assetID,
			String userID, String chkOutDt, String chkOutTm, String chkInDt,
			String chkInTm, int returnStatus) {
		super();
		this.transactionID = transactionID;
		this.assetID = assetID;
		this.userID = userID;
		this.chkOutDt = chkOutDt;
		this.chkOutTm = chkOutTm;
		this.chkInDt = chkInDt;
		this.chkInTm = chkInTm;
		this.returnStatus = returnStatus;
	}
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getAssetID() {
		return assetID;
	}
	public void setAssetID(String assetID) {
		this.assetID = assetID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getChkOutDt() {
		return chkOutDt;
	}
	public void setChkOutDt(String chkOutDt) {
		this.chkOutDt = chkOutDt;
	}
	public String getChkOutTm() {
		return chkOutTm;
	}
	public void setChkOutTm(String chkOutTm) {
		this.chkOutTm = chkOutTm;
	}
	public String getChkInDt() {
		return chkInDt;
	}
	public void setChkInDt(String chkInDt) {
		this.chkInDt = chkInDt;
	}
	public String getChkInTm() {
		return chkInTm;
	}
	public void setChkInTm(String chkInTm) {
		this.chkInTm = chkInTm;
	}
	public int getReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(int returnStatus) {
		this.returnStatus = returnStatus;
	}
	
	
}
