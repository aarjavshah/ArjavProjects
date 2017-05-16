package com.cts.dnb.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.dnb.AdminService.ManageRequests;
import com.cts.dnb.model5.RequestTYP;

public class GetReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger = Logger.getLogger(AddBroker.class);
		HttpSession session = request.getSession(true);
		if(session.isNew()||!(boolean)session.getAttribute("isAdmin")){
			response.sendRedirect("Login.jsp");
		}else{
			String reqID = request.getParameter("reqID");
			RequestTYP req = ManageRequests.getReqObj(reqID);
			if(req!=null){
				logger.debug("Admin "+session.getAttribute("username")+" loaded "+req.getRequestID() +" request.");
				session.setAttribute("reqTrk", req);
				response.sendRedirect("RequestStatus.jsp");
			}else{
				session.setAttribute("error", "Invalid Request ID");
				response.sendRedirect("Error.jsp");
			}
		}
	}

}
