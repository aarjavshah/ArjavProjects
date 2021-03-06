package com.cts.dnb.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.dnb.Application2.ChannelStatus;
import com.cts.dnb.Application2.QMMonitor;
import com.cts.dnb.Application2.TopicProperties;

public class GetTopicDetails extends HttpServlet {
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
		String TpName = request.getParameter("TpName");
		logger.debug("User "+session.getAttribute("username")+" selected "+TpName+" Topic.");
		session.setAttribute("TpName", TpName);
		String qmName = (String)session.getAttribute("qmName");
		TopicProperties tp = QMMonitor.ParseOutput(qmName, TpName,"Topic");
		session.setAttribute("TpProp", tp);
		response.sendRedirect("TpStatus.jsp");
		}
	}

}
