package com.cts.dnb.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.apache.log4j.Logger;

import com.cts.dnb.Application2.QueueBrowser;

public class FilterQueues extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FilterQueues() {
        super();
    }

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
		String prefix = request.getParameter("StartsWith");
		logger.debug("User "+session.getAttribute("username")+" filered queues which start with "+prefix+".");
		if((prefix==null || prefix.isEmpty())&& session.getAttribute("prefix")!=null){
			prefix = (String)session.getAttribute("prefix");
		}
		String qmName = (String)session.getAttribute("qmName");
		ArrayList<String>queueList = QueueBrowser.getFilteredQueues(prefix,qmName);
		session.setAttribute("filteredQList", queueList);
		session.setAttribute("prefix", prefix);
		response.sendRedirect("QueueBrowser.jsp");
		}
	}

}
