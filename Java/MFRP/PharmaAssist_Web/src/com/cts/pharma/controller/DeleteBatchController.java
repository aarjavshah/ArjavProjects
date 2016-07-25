package com.cts.pharma.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.pharma.delegate.PharmaDelegate;

//import Classes.ClassDAO;
/**
 * Delete Batch Controller Servlet
 * 
 * @version 1
 * @author 454591(Dev Gaba)
 * */
public class DeleteBatchController extends HttpServlet {
	// private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// PrintWriter out=response.getWriter();
		// BOClass setbean=new BOClass();
		response.setHeader("Cache-Control", "no-cache,no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		PharmaDelegate deleteDelegate = new PharmaDelegate();
		boolean x = false;
		x = deleteDelegate.deleteDetails(request.getParameter("batchcode"));
		if (x) {
			// forwards the request to welcome.jsp to display message
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			request.setAttribute("welcome", "deleteTrue");
			rd.forward(request, response);
		} else {
			// forwards the request to deletebatch.jsp to display message
			RequestDispatcher rd = request
					.getRequestDispatcher("deletebatch.jsp");
			request.setAttribute("welcome", "deleteFalse");
			rd.forward(request, response);
		}
	}
}
