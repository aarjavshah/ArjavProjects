package com.cts.dnb.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.dnb.Application2.QueueMessenger;
import com.ibm.mq.MQException;

public class PutMessages extends HttpServlet {
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
			int cnt = Integer.parseInt(request.getParameter("msgCount"));
			ArrayList<String> msgs = new ArrayList<String>(); 
			for(int i=1;i<=cnt;i++){
				msgs.add(request.getParameter("msg"+i));
			}
			String replyTo = request.getParameter("replyTo");
			try {
				QueueMessenger.PutMessages((String)session.getAttribute("qmName"), (String)session.getAttribute("qName"),msgs,replyTo);
				session.setAttribute("success", "All Messages were successfully sent to "+(String)session.getAttribute("qName")+" queue of "+ (String)session.getAttribute("qmName"));
				session.setAttribute("reDirTo", "PutMessages.jsp");
				response.sendRedirect("Success.jsp");
			} catch (Exception e) {
				session.setAttribute("error", "MQException while put message operation");
				response.sendRedirect("Error.jsp");
			}
		}
	}

}
