package com.cts.dnb.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.dnb.Application2.ChannelMonitor;
import com.cts.dnb.Application2.ChannelStatus;
import com.cts.dnb.Application2.QMMonitor;

public class GetStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger(GetApplications.class);
		HttpSession session = request.getSession(true);
		if(session.isNew()){
			response.sendRedirect("Login.jsp");
		}else{
			if(session.getAttribute("username") == null){
				response.sendRedirect("Login.jsp");
			}
		String ChName = request.getParameter("ChName");
		logger.debug("User "+session.getAttribute("username")+" selected "+ChName+" channel.");
		session.setAttribute("ChName", ChName);
		String qmName = (String)session.getAttribute("qmName");
		ArrayList<ChannelStatus> chStatus = QMMonitor.getChannelStatus(ChName,qmName);
		boolean flag = false;
		if(chStatus == null){
			chStatus = new ArrayList<ChannelStatus>();
			ChannelStatus ch =new ChannelStatus();
			ch.setChName(ChName);
			ch.setChStatus("Inactive");
			ch.setHost("Not Available");
			ch.setSubState("Unknown");
			ch.setChType("Unknown");
			chStatus.add(ch);
			flag = true;
		}
		int instances = chStatus.size();
		if(flag){
			instances-=1;
		}
		session.setAttribute("ChStatus", chStatus);
		session.setAttribute("InstanceCount", instances);
		response.sendRedirect("ChStatus.jsp");
		}
	}

}
