package com.cts.pharma.dao.factory;

import com.cts.pharma.dao.BatchDAO;
import com.cts.pharma.dao.IBatchDAO;

/**
 * DaoFactoryImpl Class
 * 
 * @version 1
 * @author 454582(Arjav Shah)
 * */
public class DaoFactoryImpl extends AbstractFactoryDAO {

	/**
	 * getter function returning IBatchDAO object
	 * */
	public IBatchDAO getBatchDAO() {
		IBatchDAO returnObject = null;
		returnObject = new BatchDAO();
		System.out.println(returnObject);
		return returnObject;
	}
}
