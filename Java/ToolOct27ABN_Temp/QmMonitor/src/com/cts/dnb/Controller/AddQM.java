package com.cts.dnb.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.dnb.AdminService.ConfigureQM;
import com.cts.dnb.AdminService.ValidateQM;
import com.cts.dnb.model3.ConnectConfig;


public class AddQM extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger = Logger.getLogger(AddQM.class);
		HttpSession session = request.getSession(true);
		if(session.isNew()||!(boolean)session.getAttribute("isAdmin")){
			response.sendRedirect("Login.jsp");
		}else{
			ConnectConfig config = new ConnectConfig();
			String env= request.getParameter("alias");
			config.setQMhost(request.getParameter("host"));
			config.setQMport(request.getParameter("port"));
			config.setQMname(request.getParameter("qm"));
			config.setQMchannel(request.getParameter("chaName"));
			boolean available = false;
			available = ValidateQM.CheckAvailability(config);
			session.setAttribute("QMAvail",available);
			if(!available){
				response.sendRedirect("AddQManager.jsp");
			}else{
				int res = ConfigureQM.AddNewQueueManager(config, env);
					/*
					 * 0=success
					 * 1=QNamesFail
					 * 2=ChNamesFail
					 * 3=fileChangefail
					 * 4=QMExistsFail
					 * 5=UnknownFail
					 * */
				if(res == 0){
					logger.debug("Admin "+session.getAttribute("username")+" added "+config.getQMname()+" Queue-Manager.");
					session.setAttribute("success", "Queue-Manager Added Successfully");
					response.sendRedirect("Success.jsp");
				}else if(res == 1){
					session.setAttribute("error", "Unable to load Queue Names");
					response.sendRedirect("Error.jsp");
				}else if(res == 2){
					session.setAttribute("error", "Unable to load Channel Names");
					response.sendRedirect("Error.jsp");
				}else if(res == 3){
					session.setAttribute("error", "Unable to update configuration file");
					response.sendRedirect("Error.jsp");
				}else if(res == 4){
					session.setAttribute("error", "Queue-Manager Already Exists");
					response.sendRedirect("Error.jsp");
				}else if(res == 5){
					session.setAttribute("error", "Unexpected Error Occured");
					response.sendRedirect("Error.jsp");
				}
			}
		}
	}
}
