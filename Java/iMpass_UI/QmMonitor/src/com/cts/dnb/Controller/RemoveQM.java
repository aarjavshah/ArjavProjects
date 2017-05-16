package com.cts.dnb.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.dnb.AdminService.ConfigureQM;
import com.cts.dnb.AdminService.ConfigureUser;
import com.cts.dnb.AdminService.GetConnectionConfigList;
import com.cts.dnb.Application1.QMUtilityVO;
import com.cts.dnb.Application1.UserAuth;
import com.cts.dnb.model4.UserTYP;

public class RemoveQM extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger = Logger.getLogger(RemoveUser.class);
		HttpSession session = request.getSession(true);
		if(session.isNew()||!(boolean)session.getAttribute("isAdmin")){
			response.sendRedirect("Login.jsp");
		}else{
			String qmn = request.getParameter("qmn");
			QMUtilityVO vo = GetConnectionConfigList.getQMConParam(qmn);
			
			if(vo!=null){
				if(ConfigureQM.RemoveQMCon(vo)){
					logger.debug("Admin "+session.getAttribute("username")+" removed "+vo.getCon().getQMname()+"Queue-Manager.");
					response.sendRedirect(request.getContextPath()+"/QMSetup");
				}else{
					session.setAttribute("error", "Unexpected Error Occured");
					response.sendRedirect("Error.jsp");
				}
			}else{
				session.setAttribute("error", "Selected Queue-Manager does not exist anymore!");
				response.sendRedirect("Error.jsp");
				}
		}
	}

}
