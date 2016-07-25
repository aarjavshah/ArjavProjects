package com.cts.pharma.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.pharma.bo.BatchBO;
import com.cts.pharma.delegate.PharmaDelegate;

//import Classes.ClassDAO;

/**
 * Add Batch Controller Servlet
 * 
 * @version 1
 * @author 454579(Fenil Tailor)
 * */
public class AddBatchController extends HttpServlet {
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

		BatchBO setbean = new BatchBO();
		PharmaDelegate addDelegate = new PharmaDelegate();
		boolean responsecheck = false;
		responsecheck = addDelegate.addDetails(setbean.setBatchVO(request
				.getParameter("batchcode"), request
				.getParameter("medicinecode"), Integer.parseInt(request
				.getParameter("weight")), Integer.parseInt(request
				.getParameter("price")), request.getParameter("medicinetype")
				.charAt(0), request.getParameter("refregeration")));

		if (responsecheck) {
			RequestDispatcher deact = request
					.getRequestDispatcher("welcome.jsp");
			request.setAttribute("welcome", "addTrue");
			// forwards the request to addbatch.jsp to display message
			deact.forward(request, response);
		} else {
			RequestDispatcher deact = request
					.getRequestDispatcher("welcome.jsp");
			request.setAttribute("welcome", "addFalse");
			// forwards the request to welcome.jsp to display message
			deact.forward(request, response);
		}
	}
}
