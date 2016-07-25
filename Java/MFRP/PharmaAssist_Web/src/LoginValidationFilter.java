


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet Filter implementation class Userlogin
 */
public class LoginValidationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginValidationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		int flag=1;
		// pass the request along the filter chain
		//System.out.println("1232321");
		PrintWriter po=response.getWriter();
		try {
			
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/pharma","root","root");
			PreparedStatement stm=(PreparedStatement) con.prepareStatement("select * from users_master where username=? and password=? and activation_bit!=0");
			stm.setString(1, username);
			stm.setString(2, password);
			
			ResultSet res=stm.executeQuery();
			
			if(res.next())
			{
				chain.doFilter(request, response);
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
				}
				else{
					stm=(PreparedStatement) con.prepareStatement("select * from users_master where username=? and activation_bit=0");
					stm.setString(1, username);
					res=stm.executeQuery();
					if(res.next()){
						flag=0;
						//HttpServletResponse httpResponse = (HttpServletResponse) response;
						//httpResponse.sendRedirect("Reactivate.jsp");
						RequestDispatcher deact=request.getRequestDispatcher("Reactivate.jsp");
						deact.forward(request, response);
					}
					else{
						flag=1;
					}
				}
				if(flag==1){
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				request.setAttribute("wrong", "1");
				rd.forward(request, response);}
				//HttpServletResponse httpResponse = (HttpServletResponse) response;
				//httpResponse.sendRedirect("Login.jsp");
			}
		} 
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException e)
		{
	           e.getMessage();
		}
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
