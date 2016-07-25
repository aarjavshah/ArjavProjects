package com.cts.pharma.logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cts.pharma.constants.LoggerConstants;

/**
 * LoggerIntializer Class
 * 
 * @version 1
 * @author 454582(Arjav Shah)
 * */
public class LoggerInitializer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(LoggerInitializer.class);

	/**
	 * ServletConfig - servlet config object
	 */
	public void init(final ServletConfig config) throws ServletException {
		final String realPath = config.getServletContext().getRealPath("/");
		final String log4jFile = realPath + LoggerConstants.LOG4J_FILE;
		PropertyConfigurator.configure(log4jFile);
		LOG.info("Application Initialized");
	}

}