package com.cts.dnb.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.dnb.AdminService.ConfigureUser;
import com.cts.dnb.model4.UserTYP;

public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger = Logger.getLogger(AddUser.class);
		HttpSession session = request.getSession(true);
		if(session.isNew()||!(boolean)session.getAttribute("isAdmin")){
			response.sendRedirect("Login.jsp");
		}else{		
			UserTYP user = new UserTYP();
			user.setUserName(request.getParameter("user"));
			user.setUserType(request.getParameter("type"));
			if(request.getParameter("type")!=null && request.getParameter("type").equals("admin"));{
				user.setPassword(request.getParameter("password"));
			}
			int res = ConfigureUser.addUser(user);
			switch(res){
			case 0:
				logger.debug("Admin "+session.getAttribute("username")+" added "+user.getUserName()+" user of type "+user.getUserType());
				session.setAttribute("success", "User Added Successfully");
				response.sendRedirect("Success.jsp");
				break;
			case 1:
				session.setAttribute("error", "User already Exists");
				response.sendRedirect("Error.jsp");
				break;
			case 2:
				session.setAttribute("error", "Unexpected Error occured");
				response.sendRedirect("Error.jsp");
				break;
			case 3:
				session.setAttribute("error", "Invalid User Type");
				response.sendRedirect("Error.jsp");
				break;
			}
		}
	}

}
