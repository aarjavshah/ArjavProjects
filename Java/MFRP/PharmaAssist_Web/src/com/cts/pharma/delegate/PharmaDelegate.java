package com.cts.pharma.delegate;

import com.cts.pharma.facade.PharmaFacade;
import com.cts.pharma.locator.Locator;
import com.cts.pharma.vo.BatchVO;

/**
 * PharmaDelegate Class
 * 
 * @version 1
 * @author 454582(Arjav Shah)
 * */
public class PharmaDelegate {

	/**
	 * Locates Facade class and calls the addDetails function of Facade class
	 * */
	public boolean addDetails(BatchVO batchVO) {
		boolean isAdded = false;

		Locator locateFacade = new Locator();
		PharmaFacade facade = (PharmaFacade) locateFacade
				.locateFacade("facade");
		isAdded = facade.addDetails(batchVO);

		return isAdded;
	}

	/**
	 * Locates Facade class and calls the searchDetails function of Facade class
	 * */
	public BatchVO searchDetails(String batchVO) {
		BatchVO batchDetails = null;

		Locator locateFacade = new Locator();
		PharmaFacade facade = (PharmaFacade) locateFacade
				.locateFacade("facade");
		batchDetails = facade.searchDetails(batchVO);

		return batchDetails;
	}

	/**
	 * Locates Facade class and calls the deleteDetails function of Facade class
	 */
	public boolean deleteDetails(String batchVO) {
		boolean isAdded = false;

		Locator locateFacade = new Locator();
		PharmaFacade facade = (PharmaFacade) locateFacade
				.locateFacade("facade");
		isAdded = facade.deleteDetails(batchVO);

		return isAdded;
	}

	/**
	 * Locates Facade class and calls the updateDetails function of Facade class
	 * */
	public boolean updateDetails(BatchVO batchVO, String batchcode) {
		boolean isUpdated = false;

		Locator locateFacade = new Locator();
		PharmaFacade facade = (PharmaFacade) locateFacade
				.locateFacade("facade");
		isUpdated = facade.updateDetails(batchVO, batchcode);

		return isUpdated;
	}

}
