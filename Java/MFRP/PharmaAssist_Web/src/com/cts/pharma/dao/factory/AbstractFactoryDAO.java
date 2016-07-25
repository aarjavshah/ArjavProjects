package com.cts.pharma.dao.factory;

import com.cts.pharma.dao.IBatchDAO;

/**
 * AbstractFactoryDAO Class
 * 
 * @version 1
 * @author 454582(Arjav Shah)
 * */
public abstract class AbstractFactoryDAO {
	/**
	 * getter function returning DaoFactoryImpl object
	 */
	public static AbstractFactoryDAO getAbstractFactoryDAO(String factorySelect) {
		AbstractFactoryDAO returnObject = null;
		if (factorySelect.equals("abstract")) {
			returnObject = new DaoFactoryImpl();
		}
		return returnObject;
	}

	public abstract IBatchDAO getBatchDAO();
}
