package com.cts.dnb.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.dnb.Application1.jaxB;
import com.cts.dnb.model1.ApplicationTYP;
import com.cts.dnb.model1.ApplicationsTYP;
import com.cts.dnb.model1.BrokerTYP;
import com.cts.dnb.model1.BrokersTYP;
import com.cts.dnb.model1.ExecutionGroupTYP;
import com.cts.dnb.model1.ExecutionGroupsTYP;

/**
 * Servlet implementation class EgLoadController
 */
public class EgLoadController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EgLoadController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		if(session.isNew()){
			response.sendRedirect("Login.jsp");
		}else{
			if(session.getAttribute("username") == null){
				response.sendRedirect("Login.jsp");
			}
			else if(session.getAttribute("broker") == null){
				response.sendRedirect("Welcome.jsp");
			}
		//ArrayList<String> executionGroupList = new ArrayList<String>();
		ArrayList<ApplicationTYP> applicationList = new ArrayList<ApplicationTYP>();
		String brokerName = (String) session.getAttribute("broker");
		String egName = request.getParameter("eg");
		Boolean egStatus = false;
		BrokersTYP brokers = jaxB.getjaxbObject();
		for(BrokerTYP broker: brokers.getBroker()){
			if(broker.getBrokerName().equals(brokerName)){
				ExecutionGroupsTYP executionGroups =  broker.getExecutionGroups();
				for(ExecutionGroupTYP executionGroup : executionGroups.getExecutionGroup()){
					if(executionGroup.getExecutionGroupName().equals(egName)){
						egStatus = executionGroup.isIsExecutionGroupRunning();
					}
				}
			}
		}
		session.setAttribute("eg", egName);
		session.setAttribute("egStatus", egStatus);
		response.sendRedirect("ResultNoRefresh.jsp");
		}
	}
}
