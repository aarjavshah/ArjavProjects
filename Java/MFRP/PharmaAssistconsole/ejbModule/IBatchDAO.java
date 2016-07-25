/**
* IBatchDAO interface contains all the methos present in BatchDAO
**/ 
public interface IBatchDAO {
	boolean addDetails(Bean BatchVO);
	Bean searchDetails(String BatchCode);
	boolean deleteDetails(String BatchCode);
	boolean updateDetails(Bean BatchVO);
	
	int getShippingCharges(int weight,String medicineType);
	boolean checkBatchCode(String batchcode);
	String[] getMedicineCodes();
	boolean checkMedicineCodes(String medicineCode);
}
