package com.cts.dnb.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class MessageQueue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger = Logger.getLogger(MessageQueue.class);
		HttpSession session = request.getSession(true);
		if(session.isNew()){
			response.sendRedirect("Login.jsp");
		}else{
			if(session.getAttribute("username") == null){
				logger.debug("User "+session.getAttribute("username")+" accessed Put Message function.");
				response.sendRedirect("Login.jsp");
			}
			if(request.getParameter("put")!=null){
				response.sendRedirect("PutMessage.jsp");
			}else if(request.getParameter("get")!=null){
//				try{
//					
//				}catch(Exception e){
//					response.sendRedirect("Error.jsp");
//				}
				logger.debug("User "+session.getAttribute("username")+" retrieved first message from queue "+session.getAttribute("qName")+".");
				response.sendRedirect("GetMessage.jsp");
			}
		}
	}
}
