package com.cts.dnb.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.testing.TestRun;

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
			ArrayList<String> msgs = new ArrayList<String>();
			if(request.getParameter("put")!=null){
				response.sendRedirect("PutMessage.jsp");
			}else if(request.getParameter("get")!=null){
				logger.debug("User "+session.getAttribute("username")+" browsed messages from queue "+session.getAttribute("qName")+".");
				session.setAttribute("BrCount",0);
				try {
					msgs = TestRun.BrowseMessage((String)session.getAttribute("qmName"),(String)session.getAttribute("qName"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(msgs!=null){
					session.setAttribute("BrMsgs",msgs);
					response.sendRedirect("GetMessage.jsp");
				}else{
					session.setAttribute("error", "MQRC 2033: Queue is empty");
					response.sendRedirect("Error.jsp");
				}
			}
		}
	}
}
