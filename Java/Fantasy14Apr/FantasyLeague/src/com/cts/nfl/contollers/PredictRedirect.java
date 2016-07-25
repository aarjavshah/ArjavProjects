package com.cts.nfl.contollers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PredictRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		session.setAttribute("venue", "Rajkot");
		session.setAttribute("matchno", 6);
		session.setAttribute("date", "14/04/2016, 8 PM IST");
		session.setAttribute("team1", request.getParameter("team1"));
		session.setAttribute("team2", request.getParameter("team2"));
		response.sendRedirect("Predict.jsp");
	}

}
