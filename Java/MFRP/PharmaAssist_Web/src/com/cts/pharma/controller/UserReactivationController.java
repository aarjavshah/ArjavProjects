package com.cts.pharma.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.pharma.dao.UserDAO;

/**
 * UserReactivationController servlet
 * 
 * @version 1
 * @author 454591(Dev Gaba)
 * */
public class UserReactivationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int flag = 0;
		String username = request.getParameter("username");
		String answer = request.getParameter("secretanswer");
		UserDAO reactivateUserValidation = new UserDAO();

		if (reactivateUserValidation.AnswerCheck(answer, username)) {
			flag = 1;

		} else {
			// forwards the request to Reactivate.jsp to display message
			RequestDispatcher lol = request
					.getRequestDispatcher("Reactivate.jsp");
			request.setAttribute("wrong_react", "1");
			lol.forward(request, response);
		}
		if (flag == 1) {/* send to password Reset page */
			// forwards the request to forgotpassword.jsp to display message
			RequestDispatcher x = request
					.getRequestDispatcher("forgotPassword.jsp");
			request.setAttribute("username_react", username);
			x.forward(request, response);
		}
	}

}
