
import java.util.InputMismatchException;
import java.util.Scanner;
public class UpdateBatch {
 boolean updatebatch(String batchcode)
	  {
		  boolean exit=true;
			 Scanner sc=new Scanner(System.in);
			 BOClass setbean=new BOClass();
			 IBatchDAO setdatabase=new BatchDAO();
			 String medicinecode="",refregeration="";
			 int weight=0,price=0,flag=0;
			 char medicinetypecode='\0';
		  while(exit)
		  {
			  if(flag==1)
				System.out.println("Invalid Input");
			  try{
				  System.out.println("Enter MEDICINECODE");
				  medicinecode=sc.nextLine();
				  
				  System.out.println("Enter WEIGHT");
				  weight=sc.nextInt();
				  
				  System.out.println("Enter PRICE");
				  price=sc.nextInt();
				  sc.nextLine();
				  
				  System.out.println("Enter MEDICINETYPECODE");
				  medicinetypecode=sc.nextLine().charAt(0);
				  
				  System.out.println("Enter Refrigeration[yes/no]");
				  refregeration=sc.nextLine();
				  
				  exit=false;
			  }
			  catch(InputMismatchException e)
			  {
				  sc.nextLine();
				  flag=1;
				  continue;
			  }
			  catch(Exception e)
			  {
				  sc.nextLine();
				  flag=1;
				  continue;
			  }
		  }
		  return(setdatabase.updateDetails(setbean.addDetails(batchcode,medicinecode,weight,price,medicinetypecode,refregeration)));
     
	  
	  }
}