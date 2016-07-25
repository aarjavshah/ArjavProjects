
import java.util.Scanner;

/**
* Search Batch Class to get the data from user which batch he/she wants to search
* and it contains validation for invalid data 
**/ 
public class SearchBatch {
	
public boolean searchbatch()
{
	IBatchDAO search=new BatchDAO();
	Scanner sc=new Scanner(System.in);
	boolean exit=true;
	int flag=0;
	String batchcode="";
	
	System.out.println();
	while(exit){
		if(flag==1){
			System.out.println("Invalid Batch Code");
		}
		flag=0;
	System.out.println("Enter BATCHCODE[8-16 Characters]");
	batchcode=sc.next().trim();
	if(batchcode.length()<8||batchcode.length()>16){
		flag=1;
		}
	else{
		exit=false;
		}
	}
	UpdateBatch updatebatch=new UpdateBatch();
	boolean x=search.checkBatchCode(batchcode);
	if(x){
		Bean output=search.searchDetails(batchcode);
		new BOClass().RetrieveDetails(output);
	while(true){
		System.out.println();
	System.out.println("Do you want to update the batch?[yes/no]");
	String choice_update=sc.next().trim();
	if(choice_update.equalsIgnoreCase("yes")){
		return updatebatch.updatebatch(batchcode);
	}
	else if(choice_update.equalsIgnoreCase("no")){
		return x;
	}
	else{
		System.out.println("Invalid Choice!");
	}
	}
	}
	return x;
}
}
