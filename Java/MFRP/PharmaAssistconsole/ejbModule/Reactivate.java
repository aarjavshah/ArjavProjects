import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
* Reactivate Class to reactivate the user after account is deactivated
**/ 
public class Reactivate {
	int Reactivation(){
		Scanner s=new Scanner(System.in);
		int flag=0,return_check=0,error_input=0;
		String username="",answer="",question="";
		boolean exit=true;
		while(exit){
			if(error_input==1){
				System.out.println("Invalid Input Type");
			}
			else if(error_input==2)
			{
				System.out.println("Invalid Username for reactivation");
			}
			error_input=0;
		try{
		System.out.println("Enter username");
		username=s.next();
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/pharma","root","root");
		PreparedStatement stm=(PreparedStatement) con.prepareStatement("select questions from users_master a,questions_master b where a.question_id=b.question_id and a.activation_bit=0 and a.username=?");
		stm.setString(1,username);
		ResultSet re=stm.executeQuery();
		if(re.next()){
			question=re.getString(1);
			System.out.println("Enter the answer of the following security question to reactivate your account");
			System.out.println(question);
		System.out.println("Enter Secret Answer");
		answer=s.next();
		exit=false;
		}
		else{
			exit=true;
			error_input=2;
		}
		}
		catch(Exception e){
			s.next();
			error_input=1;
			exit=true;
		}}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/pharma","root","root");
			PreparedStatement stm=(PreparedStatement) con.prepareStatement("select * from users_master where username=?  and secret_answer=? and activation_bit=0");
			stm.setString(1, username);
			stm.setString(2, answer);
			ResultSet res=stm.executeQuery();
			if(res.next()){
				flag=1;
				stm=(PreparedStatement) con.prepareStatement("update users_master set activation_bit=3 where username=?");
				stm.setString(1, username);
				stm.executeUpdate();
				return_check=1;
			}
			else{
				return_check=2;
			} 
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return return_check;
	}
	
	void  reactivationafterexit(String username)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/pharma","root","root");
			PreparedStatement stm=(PreparedStatement) con.prepareStatement("update users_master set activation_bit=3 where username=?");
			stm.setString(1, username);
			stm.executeUpdate();
			
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}
	}
