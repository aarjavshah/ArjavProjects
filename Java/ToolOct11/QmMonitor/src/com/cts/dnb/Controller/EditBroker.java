package com.cts.dnb.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.dnb.Application1.BrokerDetailsVO;
import com.cts.dnb.Application1.BrokerXML;

public class EditBroker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger = Logger.getLogger(EditBroker.class);
		HttpSession session = request.getSession(true);
		if(session.isNew()){
			response.sendRedirect("Login.jsp");
		}else{		
			BrokerDetailsVO brokerdetails = new BrokerDetailsVO();
			brokerdetails.setBrokerName(request.getParameter("brokerName"));
			brokerdetails = BrokerXML.RetrievebrokerDetails(brokerdetails);
			session.setAttribute("oldName", brokerdetails.getBrokerName());
			session.setAttribute("currentBroker", brokerdetails);
			logger.debug("Admin "+session.getAttribute("username")+" edited "+brokerdetails.getBrokerName()+" Broker.(Update Pending)");
			response.sendRedirect("UpdateBroker.jsp");
		}
	}

}
