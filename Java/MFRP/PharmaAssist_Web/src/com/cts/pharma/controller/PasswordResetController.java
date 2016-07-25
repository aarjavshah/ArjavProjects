package com.cts.pharma.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.pharma.dao.UserDAO;

/**
 * Password Reset Controller Servlet
 * 
 * @version 1
 * @author 454582(Arjav Shah)
 * */
public class PasswordResetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username1");
		String passwordNew = request.getParameter("passwordNew");
		// System.out.println(username+" "+passwordNew);
		UserDAO resetPassword = new UserDAO();
		if (resetPassword.passwordReset(username, passwordNew)) {
			// forwards the request to login.jsp to display message
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("wrong", "2");
			rd.forward(request, response);
		} else {
			// forwards the request to forgotpassword.jsp to display message
			RequestDispatcher rd = request
					.getRequestDispatcher("forgotPassword.jsp");
			request.setAttribute("reset", username);
			rd.forward(request, response);
		}
	}

}
