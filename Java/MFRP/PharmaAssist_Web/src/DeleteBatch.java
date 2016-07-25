

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class DeleteBatch {
	
	boolean deletebatch()
	{
		IBatchDAO dao_delete=new BatchDAO();
		System.out.println("Enter the Batchcode:");
		Scanner sc=new Scanner(System.in);
		String deletebatchcode=sc.next();
		return(dao_delete.deleteDetails(deletebatchcode));
	}
	
	
}
