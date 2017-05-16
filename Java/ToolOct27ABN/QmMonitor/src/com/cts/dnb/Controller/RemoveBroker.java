package com.cts.dnb.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.dnb.AdminService.UpdateFile;
import com.cts.dnb.AdminService.ValidateBroker;
import com.cts.dnb.Application1.BrokerDetailsVO;
import com.cts.dnb.Application1.BrokerXML;

public class RemoveBroker extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(true);
		if(session.isNew()){
			response.sendRedirect("Login.jsp");
		}else{
			BrokerDetailsVO brokerdetails = new BrokerDetailsVO();
			brokerdetails.setBrokerName(request.getParameter("broker"));
			//brokerdetails = BrokerXML.RetrievebrokerDetails(brokerdetails);
			if(ValidateBroker.DoesBrokerEvenExist(brokerdetails.getBrokerName())){
				if(UpdateFile.RemoveFromFile(brokerdetails)){
					session.setAttribute("success", "Broker Removed Successfully");
					response.sendRedirect("Success.jsp");
				}else{
					session.setAttribute("error", "Unexpected Error Occured");
					response.sendRedirect("Error.jsp");
				}
			}else{
				session.setAttribute("error", "The Broker you Entered does not exist.");
				response.sendRedirect("Error.jsp");
			}
		}
	}
}
