package com.cts.dnb.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.dnb.AdminService.LoadQMObjectsUtility;
import com.cts.dnb.Application1.MyRunnableQMSetup;

public class QMSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger = Logger.getLogger(QMSetup.class);
		HttpSession session = request.getSession(true);
		if(session.isNew()||!(boolean)session.getAttribute("isAdmin")){
			response.sendRedirect("Login.jsp");
		}else{		
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String reqID = "QMC"+sdf.format(new Date());
	//		Runnable myrunnable = new Runnable() {
	//		    public void run() {
	//		        LoadQMObjectsUtility.startQMUpdate(null);//Call your function
	//		    }
	//		};
			new Thread(new MyRunnableQMSetup(reqID)).start();
			logger.debug("Admin "+session.getAttribute("username")+" initiated the cycle to reload QM Objects. Refer Request ID: "+reqID);
			session.setAttribute("success", "Queue-Manager configuration update initiated Successfully.\nRefer ReqID "+reqID+" for the Status");
			response.sendRedirect("Success.jsp");
		}
	}

}
