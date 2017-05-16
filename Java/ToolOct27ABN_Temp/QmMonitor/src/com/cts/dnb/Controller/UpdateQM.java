package com.cts.dnb.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.dnb.AdminService.ConfigureQM;
import com.cts.dnb.AdminService.GetConnectionConfigList;
import com.cts.dnb.AdminService.ValidateQM;
import com.cts.dnb.Application1.QMUtilityVO;
import com.cts.dnb.model3.ConnectConfig;

public class UpdateQM extends HttpServlet {
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
			String oldqmName = request.getParameter("oldqmn");
			config.setQMhost(request.getParameter("host"));
			config.setQMport(request.getParameter("port"));
			config.setQMname(request.getParameter("qm"));
			config.setQMchannel(request.getParameter("chaName"));
			boolean available = false;
			available = ValidateQM.CheckAvailability(config);
			session.setAttribute("QMAvailU",available);
			QMUtilityVO vo1 = GetConnectionConfigList.getQMConParam(config.getQMname());
			if(vo1!=null){
				session.setAttribute("error", "Selected Queue-Manager already exists!");
				response.sendRedirect("Error.jsp");
			}else{
				if(!available){
					response.sendRedirect("UpdateQM.jsp");
				}else{
					QMUtilityVO vo = new QMUtilityVO();
					vo.setCon(config);
					vo.setEnv(env);
					if(ConfigureQM.UpdateQMCon(vo, oldqmName)){
						logger.debug("Admin "+session.getAttribute("username")+" updated "+vo.getCon().getQMname()+"Queue-Manager.");
						response.sendRedirect(request.getContextPath()+"/QMSetup");
					}else{
						session.setAttribute("error", "Unexpected Error Occured!");
						response.sendRedirect("Error.jsp");
					}
				}
			}
		}
	}

}
