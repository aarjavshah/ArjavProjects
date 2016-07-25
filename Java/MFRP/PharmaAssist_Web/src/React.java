


import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class React extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag=0;
		String username=request.getParameter("username");
		int question_id=Integer.parseInt(request.getParameter("securityquestion"));
		String answer=request.getParameter("secretanswer");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/pharma","root","root");
			PreparedStatement stm=(PreparedStatement) con.prepareStatement("select * from users_master where username=? and question_id=? and secret_answer=? and activation_bit=0");
			stm.setString(1, username);
			stm.setInt(2, question_id);
			stm.setString(3, answer);
			ResultSet res=stm.executeQuery();
			if(res.next()){
				flag=1;
				stm=(PreparedStatement) con.prepareStatement("update users_master set activation_bit=3 where username=?");
				stm.setString(1, username);
				stm.executeUpdate();
			}
			else{
				RequestDispatcher lol=request.getRequestDispatcher("Reactivate.jsp");
				request.setAttribute("wrong_react", "1");
			lol.forward(request, response);
			}
			if(flag==1){
			RequestDispatcher x=request.getRequestDispatcher("login.jsp");
			request.setAttribute("wrong", "2");
			x.forward(request, response);
			//response.sendRedirect("login.jsp");
			} 
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
