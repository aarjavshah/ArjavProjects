package com.cts.pharma.facade;

import com.cts.pharma.bo.BatchBO;
import com.cts.pharma.vo.BatchVO;

/**
 * PharmaFacade Class
 * 
 * @version 1
 * @author 454582(Arjav Shah)
 * */
public class PharmaFacade {
	/**
	 * calls the addDetails function of BatchBO class
	 * */
	public boolean addDetails(BatchVO batchVO) {
		boolean isAdded = false;

		BatchBO addBatch = new BatchBO();
		isAdded = addBatch.addDetails(batchVO);
		return isAdded;
	}

	/**
	 * calls the deleteDetails function of BatchBO class
	 * */
	public boolean deleteDetails(String batchVO) {
		boolean isDeleted = false;

		BatchBO deleteBatch = new BatchBO();
		isDeleted = deleteBatch.deleteDetails(batchVO);
		return isDeleted;
	}

	/**
	 * calls the searchDetails function of BatchBO class
	 * */
	public BatchVO searchDetails(String batchVO) {
		BatchVO batchDetails = null;

		BatchBO searchBatch = new BatchBO();
		batchDetails = searchBatch.searchDetails(batchVO);
		return batchDetails;
	}

	/**
	 * calls the updateDetails function of BatchBO class
	 * */
	public boolean updateDetails(BatchVO batchVO, String batchcode) {
		boolean isUpdated = false;
		BatchBO updateBatch = new BatchBO();
		isUpdated = updateBatch.updateDetails(batchVO, batchcode);
		return isUpdated;
	}
}
