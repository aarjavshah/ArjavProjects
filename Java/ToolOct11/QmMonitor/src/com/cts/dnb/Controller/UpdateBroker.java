package com.cts.dnb.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.dnb.AdminService.UpdateFile;
import com.cts.dnb.Application1.BrokerDetailsVO;

/**
 * Servlet implementation class AddBroker
 */
public class UpdateBroker extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger = Logger.getLogger(UpdateBroker.class);
		HttpSession session = request.getSession(true);
		if(session.isNew()){
			response.sendRedirect("Login.jsp");
		}else{		
		BrokerDetailsVO brokerdetails = new BrokerDetailsVO();
		String oldName = request.getParameter("oldName");
		brokerdetails.setBrokerName(request.getParameter("broker"));
		brokerdetails.setAlias(request.getParameter("alias"));
		brokerdetails.setHost(request.getParameter("host"));
		brokerdetails.setPort(Integer.parseInt(request.getParameter("port")));
		brokerdetails.setQueueManagerName(request.getParameter("qm"));
		
		//System.out.println(brokerdetails.getHost());
		int flag=UpdateFile.UpdateintoFile(brokerdetails,oldName);
		if(flag==0){
			logger.debug("Admin "+session.getAttribute("username")+" successfully updated "+oldName+" Broker.");
			session.setAttribute("success", "Broker Details Updated Successfully");
			response.sendRedirect("Success.jsp");
		}else if(flag==1){
			session.setAttribute("error", "Broker with given details already exists");
			response.sendRedirect("Error.jsp");
		}
		else if(flag==2){
			session.setAttribute("error", "Unexpected Error Occured");
			response.sendRedirect("Error.jsp");
			}
		else{
			session.setAttribute("error", "Unexpected Error Occured");
			response.sendRedirect("Error.jsp");
		}
	}
	}
}
