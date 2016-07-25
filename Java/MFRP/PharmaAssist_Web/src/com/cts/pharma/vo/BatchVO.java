package com.cts.pharma.vo;

/**
 * Batch Value Object Class
 * 
 * @version 1
 * @author 454579(Fenil Tailor)
 * */
public class BatchVO {
	private String batchcode; // unique batch code
	private String medicinecode; // Medicine code for the particular batch
	private int weight; // weight of the shipment
	private int price; // price of the shipment
	private char medicinetype; // medicine type for the particular batch
	private String refregeration; // refregeration requirement
	private int shippingcharge; // Shipping Charge
	private String level; // level of the medicine in the shipment

	/*
	 * Non parameterized constructor
	 */
	public BatchVO() {

	}

	/**
	 * Parameterized constructor
	 */
	public BatchVO(String batchcode, String medicinecode, int weight,
			int price, char medicinetype, String refregeration,
			int shippingcharge, String level) {
		super();
		this.batchcode = batchcode;
		this.medicinecode = medicinecode;
		this.weight = weight;
		this.price = price;
		this.medicinetype = medicinetype;
		this.refregeration = refregeration;
		this.shippingcharge = shippingcharge;
		this.level = level;
	}

	/**
	 * Gettter method for batch code property
	 */
	public String getBatchcode() {
		return batchcode;
	}

	/**
	 * settter method for batch code property
	 */
	public void setBatchcode(String batchcode) {
		this.batchcode = batchcode;
	}

	/**
	 * Gettter method for medicine code property
	 */
	public String getMedicinecode() {
		return medicinecode;
	}

	/**
	 * settter method for medicine code property
	 */
	public void setMedicinecode(String medicinecode) {
		this.medicinecode = medicinecode;
	}

	/**
	 * Gettter method for weight property
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * settter method for weight property
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * Gettter method for price property
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * settter method for price property
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Gettter method for medicine type property
	 */
	public char getMedicinetype() {
		return medicinetype;
	}

	/**
	 * settter method for medicine type property
	 */
	public void setMedicinetype(char medicinetype) {
		this.medicinetype = medicinetype;
	}

	/**
	 * Gettter method for Refregeration property
	 */
	public String getRefregeration() {
		return refregeration;
	}

	/**
	 * settter method for Refregeration property
	 */
	public void setRefregeration(String refregeration) {
		this.refregeration = refregeration;
	}

	/**
	 * Gettter method for shipping Charge property
	 */
	public int getShippingcharge() {
		return shippingcharge;
	}

	/**
	 * settter method for shipping charge property
	 */
	public void setShippingcharge(int shippingcharge) {
		this.shippingcharge = shippingcharge;
	}

	/**
	 * Gettter method for care level property
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * Gettter method for care level property
	 */
	public void setLevel(String level) {
		this.level = level;
	}

}
