import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
* Login class validates the user
**/ 
public class login {

	String CheckLogin(){
		Scanner s=new Scanner(System.in);
		System.out.println("Enter username");
		String username=s.next();
		System.out.println("Enter Password");
		String password=s.next();
		int flag=1,return_check=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/pharma","root","root");
			PreparedStatement stm=(PreparedStatement) con.prepareStatement("select * from users_master where username=? and password=? and activation_bit!=0");
			stm.setString(1, username);
			stm.setString(2, password);
			
			ResultSet res=stm.executeQuery();
			
			if(res.next())
			{
				return_check=1;
			}
			
			else
			{
				stm=(PreparedStatement) con.prepareStatement("select * from users_master where username=? and activation_bit!=0");
				stm.setString(1, username);
				res=stm.executeQuery();
				if(res.next()){
					stm=(PreparedStatement) con.prepareStatement("update users_master set activation_bit=activation_bit-1 where username=?");
					stm.setString(1, username);
					stm.executeUpdate();
					
					stm=(PreparedStatement) con.prepareStatement("select * from users_master where username=? and activation_bit=0");
					stm.setString(1, username);
					res=stm.executeQuery();
					if(res.next()){
						flag=0;
						return_check=3;
					}
					
					stm=(PreparedStatement) con.prepareStatement("select * from users_master where username=? and activation_bit=1");
					stm.setString(1, username);
					res=stm.executeQuery();
					if(res.next()){
						flag=0;
						return_check=4;
					}
				}
				else{
					stm=(PreparedStatement) con.prepareStatement("select * from users_master where username=? and activation_bit=0");
					stm.setString(1, username);
					res=stm.executeQuery();
					if(res.next()){
						flag=0;
						return_check=3;
					}
					else{
						flag=1;
					}
				}
				if(flag==1){
				//CALL LOGIN AGAIN	
					return_check=2;
				}
				//HttpServletResponse httpResponse = (HttpServletResponse) response;
				//httpResponse.sendRedirect("Login.jsp");
			}
			res.close();
			stm.close();
			con.close();
		} 
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		catch(SQLException e)
		{
	          // e.getMessage();
		}
		
		if(return_check==1){
			return username;
		}
		else{
			return String.valueOf(return_check); 
		}
	}

}
