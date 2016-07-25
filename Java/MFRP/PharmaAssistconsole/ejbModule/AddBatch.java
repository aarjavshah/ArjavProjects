

//import java.util.InputMismatchException;
import java.util.Scanner;

/**
* Add Batch Class to get the data from user which batch he/she wants to adds
* and it contains validation for invalid data
**/  

public class AddBatch {

	 
	  boolean Addbatch()
	  {
		  boolean exit=true,exit1=true,exit2=true,exit3=true,exit4=true,exit5=true;
			 Scanner sc=new Scanner(System.in);
			 BOClass setbean=new BOClass();
			 IBatchDAO setdatabase=new BatchDAO();
			 String batchcode="",medicinecode="",refregeration="";
			 int weight=0,price=0,flag=0;
			 char medicinetypecode='\0';
			 System.out.println("\nEnter details of new batch:");
		  while(exit)
		  {
			  if(flag==1)
				System.out.println("Invalid Batch Code");
			  flag=0;
			  try{
		
				  System.out.println("Enter BATCHCODE[8-16 Characters]");
				  batchcode=sc.nextLine().trim();
				//  System.out.println(batchcode.length()>=8 && batchcode.length()<=16);
				if(batchcode.length()>=8 && batchcode.length()<=16){
					int flag1=0;
					
					for(int i=0;i<batchcode.length();i++){
						if(Character.isAlphabetic(batchcode.charAt(i))){
							flag1=1;
							break;
						}
					}
					if(flag1==1){
					exit=false;}
					else{
						flag=1;
					}
				}
				else{
					flag=1;
					exit=true;
				}
			  }
			  catch(Exception e)
			  {
				  flag=1;
				  exit=true;
				  continue;
			  }
			}
			  while(exit1){
				  if(flag==1)
						System.out.println("Invalid Medicine Code");
				  flag=0;
				  try{
					  int flag1=0;
					  System.out.println("Enter MEDICINECODE[Enter one from the list given below]");
					  IBatchDAO getmedicine=new BatchDAO();
					  String medicinecodes[]=getmedicine.getMedicineCodes();
					  for(String printmedicinecode:medicinecodes){
					  System.out.format("%15s\n",printmedicinecode );}
					  medicinecode=sc.nextLine().trim();
					  for(int i=0;i<medicinecodes.length;i++){
						  if(medicinecode.equals(medicinecodes[i])){
							  flag1=1;
							  break;
						  }
					  }
					  if(flag1==1){
					  exit1=false;}
					  else{
						  flag=1;
					  }
				  	}
				  catch(Exception e){
					  	flag=1;
					  	exit1=true;
						continue;
				  	}
				}
			  while(exit2){
				  if(flag==1)
						System.out.println("Invalid Weight value");
				  flag=0;
				  try{
					  	System.out.println("Enter WEIGHT[0-1500]");
					  	weight=sc.nextInt();
					  	if(weight>0 && weight<=1500){
					  		exit2=false;
					  	}else{
					  		sc.nextLine();
					  		flag=1;
					  	}
				  	}
				  catch(Exception e){
					  sc.nextLine();
					  flag=1;
					  continue;
				  	}}
			while(exit3){
					  if(flag==1)
							System.out.println("Invalid Price value");
					  flag=0;
				try{
					  System.out.println("Enter PRICE[Integer value]");
					  price=sc.nextInt();
					  if(price>0){
						  exit3=false;
					  	}
					  else{
						  sc.nextLine();
						  flag=1;
					  }
					}
				catch(Exception e){
						sc.nextLine();
						flag=1;
						continue;
					  }}
			sc.nextLine();
			while(exit4){
					  if(flag==1)
							System.out.println("Invalid medicine type");
					  flag=0;
					  try{
						  System.out.println("Enter MEDICINETYPECODE[T/C/S]");
						  
						  medicinetypecode=sc.nextLine().charAt(0);
							if(medicinetypecode=='T'||medicinetypecode=='t'||medicinetypecode=='C'||medicinetypecode=='c'||medicinetypecode=='S'||medicinetypecode=='s'){
								exit4=false;
							}
							else{
								flag=1;
							}
						  }
					  catch(Exception e){
						  flag=1;
						  continue;
					  }}
			while(exit5){
				if(flag==1)
						System.out.println("Invalid Refrigeneration");
				flag=0;
				try{
				System.out.println("Enter Refrigeration[yes/no]");
				refregeration=sc.nextLine().trim();
				if(refregeration.equalsIgnoreCase("yes")||refregeration.equalsIgnoreCase("no")){
					exit5=false;
					}
				else{
					flag=1;
					exit5=true;
				}
			  }
				catch(Exception e){
					flag=1;
					exit5=true;
				}
				}
			 
		//if(responsecheck){
		//	System.out.println("SuccessFul");
		//}
		//else{
			//System.out.println("Failure");
		//}
		  return(setdatabase.addDetails(setbean.addDetails(batchcode,medicinecode,weight,price,medicinetypecode,refregeration)));
     
	  
	  }
}