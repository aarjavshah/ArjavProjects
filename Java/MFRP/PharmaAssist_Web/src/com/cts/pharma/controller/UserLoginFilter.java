package com.cts.pharma.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.cts.pharma.dao.UserDAO;
import com.cts.pharma.vo.UserVO;

/**
 * UserLoginFilter Filter connected to UserLoginController
 * 
 * @version 1
 * @author 454579(Fenil Tailor)
 * */
public class UserLoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public UserLoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		int flag = 1;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserVO userVO = new UserVO(username, password);
		UserDAO validateUser = new UserDAO();
		int isvalid = validateUser.UserValidation(userVO);
		switch (isvalid) {
		case 0: {
			// forwards the request to login.jsp to display message
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("wrong", "1");
			rd.forward(request, response);
			break;
		}
		case 1: {
			// forwards the request to UserLoginController Servlet
			chain.doFilter(request, response);
			break;
		}
		case 2: {
			// forwards the request to login.jsp to display message
			RequestDispatcher deactivation = request
					.getRequestDispatcher("login.jsp");
			request.setAttribute("wrong", "3");
			deactivation.forward(request, response);
			break;
		}

		case 4:
		case 3: {
			// forwards the request to Reactivate.jsp
			RequestDispatcher deactivation = request
					.getRequestDispatcher("Reactivate.jsp");
			// request.setAttribute("user", username);
			deactivation.forward(request, response);
			break;
		}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
