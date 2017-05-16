package com.cts.dnb.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.dnb.Application1.ApplicationUnderBroker;
import com.cts.dnb.Application1.ApplicationVOComparator;
import com.cts.dnb.Application1.jaxB;
import com.cts.dnb.model1.BrokerTYP;
import com.cts.dnb.model1.BrokersTYP;
import com.cts.dnb.model1.ExecutionGroupTYP;
import com.cts.dnb.model1.ExecutionGroupsTYP;
import com.cts.dnb.model2.ApplicationVO;

public class GetApplications extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger = Logger.getLogger(GetApplications.class);
		HttpSession session = request.getSession(true);
		if(session.isNew()){
			response.sendRedirect("Login.jsp");
		}else{
			if(session.getAttribute("username") == null){
				response.sendRedirect("Login.jsp");
			}
		ArrayList<ApplicationVO> applicationVo = new ArrayList <ApplicationVO>();
		Boolean brokerStatus = false;
		String brokerName = request.getParameter("broker");
		BrokersTYP brokers = jaxB.getjaxbObject();
		for(BrokerTYP broker: brokers.getBroker()){
			if(broker.getBrokerName().equals(brokerName)){
				brokerStatus = broker.isIsBrokerRunning();
			}
		}
		applicationVo = ApplicationUnderBroker.GetApplicationsForBroker(brokerName);
		Collections.sort(applicationVo,new ApplicationVOComparator());
		session.setAttribute("broker",brokerName);
		logger.debug("user "+session.getAttribute("username")+" selected "+brokerName+" broker.");
		//System.out.println(session.getAttribute("broker"));
		session.setAttribute("brokerStatus",brokerStatus);
		session.setAttribute("appList",applicationVo );
		response.sendRedirect("ResultNoRefresh.jsp");
		}
	}

}
