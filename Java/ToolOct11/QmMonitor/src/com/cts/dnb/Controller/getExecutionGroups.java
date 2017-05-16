package com.cts.dnb.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.dnb.Application1.jaxB;
import com.cts.dnb.model1.ApplicationTYP;
import com.cts.dnb.model1.BrokerTYP;
import com.cts.dnb.model1.BrokersTYP;
import com.cts.dnb.model1.ExecutionGroupTYP;
import com.cts.dnb.model1.ExecutionGroupsTYP;


public class getExecutionGroups extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public getExecutionGroups() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		if(session.isNew()){
			response.sendRedirect("Login.jsp");
		}else{
			if(session.getAttribute("username") == null){
				response.sendRedirect("Login.jsp");
			}
		ArrayList<String> executionGroupList = new ArrayList<String>();
		Boolean brokerStatus = false;
		String brokerName = request.getParameter("broker");
		BrokersTYP brokers = jaxB.getjaxbObject();
		for(BrokerTYP broker: brokers.getBroker()){
			if(broker.getBrokerName().equals(brokerName)){
				brokerStatus = broker.isIsBrokerRunning();
				ExecutionGroupsTYP executionGroups =  broker.getExecutionGroups();
				//ArrayList<String> egList = new ArrayList<String>();
				for(ExecutionGroupTYP executionGroup : executionGroups.getExecutionGroup()){
					executionGroupList.add(executionGroup.getExecutionGroupName());
				}
			}
		}
		session.setAttribute("broker",brokerName);
		//System.out.println(session.getAttribute("broker"));
		session.setAttribute("brokerStatus",brokerStatus);
		session.setAttribute("egList", executionGroupList);
		response.sendRedirect("Welcome.jsp");
		}
	}

}
