package com.cts.pharma.locator;

import com.cts.pharma.facade.PharmaFacade;

/**
 * Locator Class
 * 
 * @version 1
 * @author 454591(Dev Gaba)
 * */
public class Locator {
	/**
	 * Locates Facade class and returns facade object
	 * */

	public Object locateFacade(String locatorName) {
		Object facade = null;
		if (locatorName.equals("facade")) {
			facade = new PharmaFacade();
		}
		return facade;
	}
}
