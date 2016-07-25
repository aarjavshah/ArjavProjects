

import java.util.Scanner;

public class SearchBatch {
	
public boolean searchbatch()
{
	IBatchDAO search=new BatchDAO();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Batchcode:");
	String batchcode=sc.next();
	UpdateBatch updatebatch=new UpdateBatch();
	boolean x=search.searchDetails(batchcode);
	while(true && x){
	System.out.println("Do you want to update the batch?[yes/no]");
	String choice_update=sc.next();
	if(choice_update.equalsIgnoreCase("yes")){
		return updatebatch.updatebatch(batchcode);
	}
	else if(choice_update.equalsIgnoreCase("no")){
		return x;
	}
	else{
		
	}
	}
	return x;
}
}
