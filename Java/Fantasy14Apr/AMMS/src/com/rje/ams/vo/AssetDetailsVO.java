package com.rje.ams.vo;

public class AssetDetailsVO {
	private String assetID;
	private String assetName;
	private String model;
	private String manufacturer;
	private String srNo;
	private String location;
	private boolean availibile;
	
	
	
	public AssetDetailsVO(String assetID, String assetName, String model,
			String manufacturer, String srNo, String location,
			boolean availibile) {
		super();
		this.assetID = assetID;
		this.assetName = assetName;
		this.model = model;
		this.manufacturer = manufacturer;
		this.srNo = srNo;
		this.location = location;
		this.availibile = availibile;
	}
	public String getAssetID() {
		return assetID;
	}
	public void setAssetID(String assetID) {
		this.assetID = assetID;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getSrNo() {
		return srNo;
	}
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isAvailibile() {
		return availibile;
	}
	public void setAvailibile(boolean availibile) {
		this.availibile = availibile;
	}

	
	
}
