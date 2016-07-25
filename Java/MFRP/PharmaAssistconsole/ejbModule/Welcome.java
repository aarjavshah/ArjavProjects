import java.util.Scanner;

/**
* Welcome Class contains the list of all the functionalities of our project
**/ 
public class Welcome {
	int WelcomePageChoice(){
		int return_check,flag=0;
		Scanner s=new Scanner(System.in);
		
		//invalid_input:
		while(true){
			try{
				//System.out.println(flag);
			if(flag==1){
				System.out.println("Invalid Choice");
			}
			flag=0;
		System.out.println("Select the Operation");
		System.out.println("1.Add the new Batch");
		System.out.println("2.Search the Batch");
		System.out.println("3.Delete the Batch");
		System.out.println("4.Logout");
		//s.next();
		return_check=s.nextInt();
		if(return_check==1||return_check==2||return_check==3||return_check==4){
			return return_check;
		}
		else{
			flag=1;
			continue;
		}
		}
		catch(Exception e){
			
			s.next();
			flag=1;
			continue;
		}
			finally{
			}
		}
	}
}
