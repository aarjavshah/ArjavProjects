package com.cts.pharma.dao;

import com.cts.pharma.vo.BatchVO;

/**
 * IBatchDAO interface
 * 
 * @version 1
 * @author 454579(Fenil Tailor)
 * @this Interface IBatchDao which contains all the methods in BatchDAO
 * */

public interface IBatchDAO {
	boolean addDetails(BatchVO batchVO);

	BatchVO searchDetails(String batchCode);

	boolean deleteDetails(String batchCode);

	boolean updateDetails(BatchVO batchVO, String batchcode);

	int getShippingCharges(int weight, String medicineType);

	boolean checkBatchCode(String batchcode);

	public String[] getMedicineCodes();

	public String[] getBatchCodes();

	boolean checkMedicineCodes(String medicineCode);
}
