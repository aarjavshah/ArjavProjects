package com.cts.pharma.vo;

/**
 * User Value Object Class
 * 
 * @version 1
 * @author 454591(Dev Gaba)
 * */
public class UserVO {

	private String username;
	private String password;

	/**
	 * non parameterized constructor
	 */
	public UserVO() {

	}

	/**
	 * Parameterized constructor
	 */
	public UserVO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * Gettter method for username property
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Settter method for username property
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gettter method for password property
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * settter method for password property
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
