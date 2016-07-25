
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
/**
* Delete Batch Class to get the data from user which batch he/she wants to delete
* and it contains validation for invalid data
**/ 
public class DeleteBatch {
	
	boolean deletebatch()
	{
		IBatchDAO dao_delete=new BatchDAO();
		boolean exit=true;
		int flag=0;
		String batchcode="";
		Scanner sc=new Scanner(System.in);
		
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
		return(dao_delete.deleteDetails(batchcode));
	}
	
	
}
