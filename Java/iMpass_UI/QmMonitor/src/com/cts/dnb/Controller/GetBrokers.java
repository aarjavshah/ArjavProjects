package com.cts.dnb.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.dnb.Application1.jaxB;
import com.cts.dnb.model1.BrokersTYP;

/**
 * Servlet implementation class GetBrokers
 */
public class GetBrokers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBrokers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		Logger logger = Logger.getLogger(GetBrokers.class);
		if(session.isNew()){
			response.sendRedirect("Login.jsp");
		}else{
			if(session.getAttribute("username") == null){
				response.sendRedirect("Login.jsp");
			}
		ArrayList<String> brokerList = new ArrayList<String>();
		String aliasName = request.getParameter("alias");
		brokerList = jaxB.getBrokerList(aliasName);
		logger.debug("user "+session.getAttribute("username")+" selected "+aliasName+" environment");
		//System.out.println(brokerList);
		session.setAttribute("alias", aliasName);
		session.setAttribute("brokerList", brokerList);
		response.sendRedirect("Welcome.jsp");
		}
	}
}
