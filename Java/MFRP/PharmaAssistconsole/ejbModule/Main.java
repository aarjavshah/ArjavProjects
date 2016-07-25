//import java.io.Console;
import java.io.IOException;
/**
 * User will run this class
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		String username="";
	while(true){
		login userLogin=new login();
		login1:
		while(true){
		username=userLogin.CheckLogin();
	//	System.out.println(username);
		if(Integer.parseInt(username)!=2 && Integer.parseInt(username)!=3 && Integer.parseInt(username)!=4){
			System.out.println("Login successful!");
			//System.out.println();
			break;
		}
		else if(Integer.parseInt(username)==2){
			System.out.println("Invalid Userid or Password");
		}
		else if(Integer.parseInt(username)==4){
			System.out.println("Last attempt remaining before account deactivation");
		}
		else if(Integer.parseInt(username)==3){
			react:
			while(true){
			System.out.println("Your account is deactivated.Please, reactivate your account by answering the secret question!");
			Reactivate r1=new Reactivate();
			
			int y=r1.Reactivation();
			//System.out.println(y);
			if(y==1){
				System.out.println("Account Reactivated!Continue with Login.");
			continue login1;	
			}
			else{
				System.out.println("Security answer does not match.Try Again!");
				continue react;
			}
		}
		}
	}
		
		int flag=0;
		boolean exit=true;
		while(exit){
          
			if(flag==1){
				System.out.println("Batch Code not found.Try Again!");
			}
			else if(flag==2){
				System.out.println("Operation was not successful");
			}
			else if(flag==3)
			{
				System.out.println("Operation Successful!");
				
			}
			flag=0;
		System.out.println();	
		Welcome w1=new Welcome();
		int operation=w1.WelcomePageChoice();
		AddBatch addbatch1=new AddBatch();
		DeleteBatch deletebatch1=new DeleteBatch();
		SearchBatch searchbatch=new SearchBatch();
		Reactivate reafterexit=new Reactivate();
		switch(operation){
		case 1:
			if(addbatch1.Addbatch()){
				flag=3;
			}
			else{
				flag=2;
			}
			break;
		case 2:
			if(searchbatch.searchbatch())
			{
				flag=3;
			}
			
			else
			{
				flag=1;
				
			}
			break;
		case 3:
			if(deletebatch1.deletebatch())
			{
				flag=3;
			}
			else
			{
				flag=1;
			}
			break;
		case 4:
			exit=false;
			System.out.println("Thank you for using Pharma Assistant");
			System.out.println();
			System.out.println();
			reafterexit.reactivationafterexit(username);
			break;
		}
	}
	}	
}
}
