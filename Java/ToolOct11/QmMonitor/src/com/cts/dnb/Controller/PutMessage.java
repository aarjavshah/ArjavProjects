package com.cts.dnb.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;

import com.cts.dnb.Application2.QueueMessenger;

public class PutMessage extends HttpServlet {
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
			String inMsg = request.getParameter("inMsg");
			inMsg = inMsg.replaceAll("<div>", "").replaceAll("</div>","");
			inMsg = StringEscapeUtils.unescapeHtml4(inMsg);
			//System.out.println(inMsg);
			inMsg = inMsg.trim();
			try{
				if(QueueMessenger.PutMessage((String)session.getAttribute("qmName"), (String)session.getAttribute("qName"), inMsg)){
					logger.debug("User "+session.getAttribute("username")+" successfully pushed a message to queue "+session.getAttribute("qName")+".");
					session.setAttribute("success", "Message was successfully sent to "+(String)session.getAttribute("qName")+" queue of "+ (String)session.getAttribute("qmName"));
					response.sendRedirect("Success.jsp");
				}else{
					session.setAttribute("error","Unexpected Error Occured");
					response.sendRedirect("Error.jsp");
				}
			}catch(Exception e){
				session.setAttribute("error", "MQException while put message operation");
				response.sendRedirect("Error.jsp");
			}
		}
	}

}
