package com.cts.dnb.Controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cts.dnb.Application1.FilePaths;
import com.cts.dnb.Application1.UserAuth;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger = Logger.getLogger(Login.class);
		//LoggerIntializer.init(getServletContext());
		// setting logger properties
		Properties log4jProperties = new Properties();
		log4jProperties.setProperty("log4j.rootLogger", "DEBUG, file");
		log4jProperties.setProperty("log4j.appender.file", "org.apache.log4j.RollingFileAppender");
		log4jProperties.setProperty("log4j.appender.file.File", FilePaths.getLOG());
		log4jProperties.setProperty("log4j.appender.file.MaxFileSize","5MB");
		log4jProperties.setProperty("log4j.appender.file.MaxBackupIndex","10");
		log4jProperties.setProperty("log4j.appender.file.layout", "org.apache.log4j.PatternLayout");
		log4jProperties.setProperty("log4j.appender.file.layout.ConversionPattern", "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");
		//initializing logger
		PropertyConfigurator.configure(log4jProperties);
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(-1);
		//System.out.println(userName);
		//if(userName!=null){
		//	System.out.println("User "+userName+" Logged in");}
		if(passWord == null || passWord.equals("")||passWord.isEmpty()){
			if(userName!=null){
			session.setAttribute("username", userName);
			logger.debug("User "+userName+" Logged in");}
			session.setAttribute("home", "Home.jsp");
			if(UserAuth.AuthenticatePermit(userName)){
				session.setAttribute("isPermit", true);
			}else{
				session.setAttribute("isPermit", false);
			}
			session.setAttribute("isAdmin", false);
			response.sendRedirect("Home.jsp");
		}
		else{
			if(UserAuth.AuthenticateAdmin(userName, passWord)){
				session.setAttribute("username", userName);
				session.setAttribute("AdminLoginFail", false);
				session.setAttribute("isPermit", true);
				session.setAttribute("isAdmin", true);
				logger.debug("admin "+userName+" Logged in");
				session.setAttribute("home", "AdminServices.jsp");
				response.sendRedirect("AdminServices.jsp");
			}
			else{
				session.setAttribute("isAdmin", false);
				logger.debug("User "+userName+" failed login as admin");
				session.setAttribute("AdminLoginFail", true);
				response.sendRedirect("Login.jsp");
			}
			//System.out.println(session.getAttribute("isAdmin"));
		}
	}

}
