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

public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger = Logger.getLogger(EditUser.class);
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
			String username = request.getParameter("olduser");
			if(ConfigureUser.updateUser(user, username)){
				logger.debug("Admin "+session.getAttribute("username")+" successfully updated "+user.getUserName()+".");
				session.setAttribute("success", "User Updated Successfully");
				response.sendRedirect("Success.jsp");
			}else{
				session.setAttribute("error", "Unexpected Error occured");
				response.sendRedirect("Error.jsp");
			}
		}
	}

}
