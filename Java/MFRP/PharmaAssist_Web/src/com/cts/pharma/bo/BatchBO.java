package com.cts.pharma.bo;

import com.cts.pharma.dao.IBatchDAO;
import com.cts.pharma.dao.factory.AbstractFactoryDAO;
import com.cts.pharma.vo.BatchVO;

/**
 * Batch Database Business Operation Class
 * 
 * @version 1
 * @author 454582(Arjav Shah)
 * */
public class BatchBO {
	/** Setting values in BatchVO */
	public boolean addDetails(BatchVO batchVO) {

		boolean isAdded = false;
		/* Initialization of FactoryDAO */
		AbstractFactoryDAO absFactoryDAO = AbstractFactoryDAO
				.getAbstractFactoryDAO("abstract");
		IBatchDAO addBatch = absFactoryDAO.getBatchDAO();
		/* Getting the Shipping Charge */
		int shippingCharge = addBatch.getShippingCharges(batchVO.getWeight(),
				String.valueOf(batchVO.getMedicinetype()));

		/* Calculations Of shipping charge according to refregeration */
		if (batchVO.getRefregeration().equalsIgnoreCase("yes")) {
			batchVO.setShippingcharge((int) (shippingCharge * 1.05));
		} else if (batchVO.getRefregeration().equalsIgnoreCase("no")) {
			batchVO.setShippingcharge((int) shippingCharge);
		}

		if (batchVO.getMedicinetype() == 'T'
				|| batchVO.getMedicinetype() == 't') {
			batchVO.setLevel("High");
		} else if (batchVO.getMedicinetype() == 'C'
				|| batchVO.getMedicinetype() == 'c') {
			batchVO.setLevel("Normal");
		} else if (batchVO.getMedicinetype() == 'S'
				|| batchVO.getMedicinetype() == 's') {
			batchVO.setLevel("Extr High");
		}

		isAdded = addBatch.addDetails(batchVO);
		return isAdded;
	}

	/**
	 * Deleting data from database and returns boolean
	 **/
	public boolean deleteDetails(String batchCode) {
		boolean isDeleted = false;
		AbstractFactoryDAO absFactoryDAO = AbstractFactoryDAO
				.getAbstractFactoryDAO("abstract");
		IBatchDAO deleteBatch = absFactoryDAO.getBatchDAO();

		isDeleted = deleteBatch.deleteDetails(batchCode);
		return isDeleted;
	}

	/**
	 * Searching data from database and returns BatchVO
	 * */
	public BatchVO searchDetails(String batchCode) {
		BatchVO batchDetails = null;
		AbstractFactoryDAO absFactoryDAO = AbstractFactoryDAO
				.getAbstractFactoryDAO("abstract");
		IBatchDAO searchBatch = absFactoryDAO.getBatchDAO();

		batchDetails = searchBatch.searchDetails(batchCode);
		return batchDetails;
	}

	/** Updating values in BatchVO */
	public boolean updateDetails(BatchVO batchVO, String batchcode) {
		boolean isUpdated = false;
		/* Initialization of FactoryDAO */
		AbstractFactoryDAO absFactoryDAO = AbstractFactoryDAO
				.getAbstractFactoryDAO("abstract");
		IBatchDAO updateBatch = absFactoryDAO.getBatchDAO();
		/* Getting the Shipping Charge */
		int shippingCharge = updateBatch.getShippingCharges(
				batchVO.getWeight(), String.valueOf(batchVO.getMedicinetype()));
		/* Calculations Of shipping charge according to refregeration */
		if (batchVO.getRefregeration().equalsIgnoreCase("yes")) {
			batchVO.setShippingcharge((int) (shippingCharge * 1.05));
		} else if (batchVO.getRefregeration().equalsIgnoreCase("no")) {
			batchVO.setShippingcharge((int) shippingCharge);
		}

		if (batchVO.getMedicinetype() == 'T'
				|| batchVO.getMedicinetype() == 't') {
			batchVO.setLevel("High");
		} else if (batchVO.getMedicinetype() == 'C'
				|| batchVO.getMedicinetype() == 'c') {
			batchVO.setLevel("Normal");
		} else if (batchVO.getMedicinetype() == 'S'
				|| batchVO.getMedicinetype() == 's') {
			batchVO.setLevel("Extr High");
		}
		isUpdated = updateBatch.updateDetails(batchVO, batchcode);
		return isUpdated;
	}

	/**
	 * Setting batchcode,medicinecode,weight,price,medicinetypecode and
	 * refregeration and returning BatchVO object
	 */
	public BatchVO setBatchVO(String batchcode, String medicinecode,
			int weight, int price, char medicinetypecode, String refregeration) {
		BatchVO batchVO = new BatchVO();
		batchVO.setBatchcode(batchcode);
		batchVO.setMedicinecode(medicinecode);
		batchVO.setMedicinetype(medicinetypecode);
		batchVO.setPrice(price);
		batchVO.setRefregeration(refregeration);
		batchVO.setWeight(weight);
		return batchVO;
	}
}
