package com.cts.pharma.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.pharma.delegate.PharmaDelegate;
import com.cts.pharma.vo.BatchVO;

//import Classes.ClassDAO;
/**
 * Search Batch Controller Servlet
 * 
 * @version 1
 * @author 454582(Arjav Shah)
 * */

public class SearchBatchController extends HttpServlet {
	// private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		HttpSession session = request.getSession(true);

		if (session.isNew()) {
			response.sendRedirect("login.jsp");
		} else {
			PharmaDelegate searchDelegate = new PharmaDelegate();
			BatchVO searchDetails = new BatchVO();
			searchDetails = searchDelegate.searchDetails(request
					.getParameter("batchcode"));
			if (searchDetails != null) {
				// forwards the request to updatebatch.jsp to display message
				RequestDispatcher rd = request
						.getRequestDispatcher("updatebatch.jsp");
				request.setAttribute("update", searchDetails);
				request.setAttribute("previous_batchcode",
						searchDetails.getBatchcode());
				rd.forward(request, response);
			} else {
				// forwards the request to welcome.jsp to display message
				response.sendRedirect("welcome.jsp");
			}
		}
	}
}
