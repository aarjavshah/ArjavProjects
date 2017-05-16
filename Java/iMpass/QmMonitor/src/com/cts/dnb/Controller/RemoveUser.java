package com.cts.dnb.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.dnb.AdminService.ConfigureUser;
import com.cts.dnb.Application1.UserAuth;
import com.cts.dnb.model4.UserTYP;

public class RemoveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger = Logger.getLogger(RemoveUser.class);
		HttpSession session = request.getSession(true);
		if(session.isNew()||!(boolean)session.getAttribute("isAdmin")){
			response.sendRedirect("Login.jsp");
		}else{
			String username = request.getParameter("user");
			if(UserAuth.AuthenticatePermit(username)){
				UserTYP usr = UserAuth.GetUserTYP(username);
				if(usr!=null){
					if(ConfigureUser.RemoveFromFile(usr)){
						logger.debug("Admin "+session.getAttribute("username")+" removed "+usr.getUserName()+" user of type "+usr.getUserType());
						session.setAttribute("success", "User Removed Successfully");
						response.sendRedirect("Success.jsp");
					}else{
						session.setAttribute("error", "Unexpected Error Occured");
						response.sendRedirect("Error.jsp");
					}
				}else{
					session.setAttribute("error", "Selected user does not exist anymore!");
					response.sendRedirect("Error.jsp");
				}
			}else{
				session.setAttribute("error", "User does not exist!");
				response.sendRedirect("Error.jsp");	
			}
		}
	}

}
