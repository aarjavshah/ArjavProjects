package com.cts.dnb.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.dnb.Application2.QMMonitor;
import com.cts.dnb.Application2.QueueBrowser;
import com.cts.dnb.Application2.QueueProperties;
import com.cts.dnb.Application2.QueuePropertiesInternal;

public class GetQueueDetails extends HttpServlet {
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
			String qName = request.getParameter("qName");
			logger.debug("User "+session.getAttribute("username")+" selected "+qName+" queue.");
			session.setAttribute("qName", qName);
			String qmName = (String)session.getAttribute("qmName");
			QueueProperties qProperties = QMMonitor.ParseOutput(qmName, qName);
			session.setAttribute("qProperties", qProperties);
			response.sendRedirect("QueueStatus.jsp");
		}
	}

}
