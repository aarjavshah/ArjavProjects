package com.cts.pharma.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.pharma.bo.BatchBO;
import com.cts.pharma.delegate.PharmaDelegate;

//import Classes.ClassDAO;
/**
 * Update Batch Controller Servlet
 * 
 * @version 1
 * @author 454582(Arjav Shah)
 * */

public class UpdateBatchController extends HttpServlet {
	// private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Cache-Control", "no-cache,no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter out = response.getWriter();
		BatchBO setbean = new BatchBO();
		PharmaDelegate updateDelegate = new PharmaDelegate();
		boolean responsecheck = false;
		responsecheck = updateDelegate.updateDetails(setbean.setBatchVO(request
				.getParameter("batchcode"), request
				.getParameter("medicinecode"), Integer.parseInt(request
				.getParameter("weight")), Integer.parseInt(request
				.getParameter("price")), request.getParameter("medicinetype")
				.charAt(0), request.getParameter("refregeration")), request
				.getParameter("previousbatchcode"));
		if (responsecheck) {
			// forwards the request to welcome.jsp to display message
			RequestDispatcher deact = request
					.getRequestDispatcher("welcome.jsp");
			request.setAttribute("welcome", "updateTrue");
			deact.forward(request, response);
		} else {
			// forwards the request to welcome.jsp to display message
			RequestDispatcher deact = request
					.getRequestDispatcher("welcome.jsp");
			request.setAttribute("welcome", "updateFalse");
			deact.forward(request, response);
		}
	}
}
