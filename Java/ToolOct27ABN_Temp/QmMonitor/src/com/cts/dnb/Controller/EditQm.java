package com.cts.dnb.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.dnb.AdminService.GetConnectionConfigList;
import com.cts.dnb.Application1.BrokerDetailsVO;
import com.cts.dnb.Application1.BrokerXML;
import com.cts.dnb.Application1.QMUtilityVO;

public class EditQm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger = Logger.getLogger(EditBroker.class);
		HttpSession session = request.getSession(true);
		if(session.isNew()){
			response.sendRedirect("Login.jsp");
		}else{		
			String qmName = request.getParameter("qmn");
			QMUtilityVO vo = GetConnectionConfigList.getQMConParam(qmName);
			if(vo!=null){
				session.setAttribute("oldqmName", qmName);
				session.setAttribute("currentQMcon", vo);
				logger.debug("Admin "+session.getAttribute("username")+" edited "+vo.getCon().getQMname()+" Queue-Manager.(Update Pending)");
				response.sendRedirect("UpdateQM.jsp");
			}else{
				session.setAttribute("error", "Queue-Manager does not Exist.");
				response.sendRedirect("Error.jsp");
			}
		}
	}

}
