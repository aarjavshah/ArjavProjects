package com.cts.pharma.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cts.pharma.logger.LoggerInitializer;
import com.mysql.jdbc.util.PropertiesDocGenerator;

/**
 * User Login Controller Servlet
 * 
 * @version 1
 * @author 454579(Fenil Tailor)
 * */
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// RequestDispatcher Welcome
		// =request.getRequestDispatcher("welcome.jsp");
		// Welcome.forward(request, response);

		ServletConfig config = getServletConfig();
		Properties pro = new Properties();
		pro.setProperty("log4j.rootlogger", "INFO,file");
		
		//LoggerInitializer li = new LoggerInitializer();
		//li.init(config);
		PropertyConfigurator.configure(pro);
		final Logger LOG = Logger.getLogger(UserLoginController.class);

		String username = request.getParameter("username");

		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(180);
		session.setAttribute("session_username", username);
		LOG.info("User " + username + " logged in");
		// redirect the request to welcome.jsp
		response.sendRedirect("welcome.jsp");
	}
}
