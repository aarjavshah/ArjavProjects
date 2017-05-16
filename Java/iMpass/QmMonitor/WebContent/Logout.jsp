<%@page import="com.cts.dnb.Controller.Login"%>
<%@page import="org.apache.log4j.Logger"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
</head>
<body>
<%
Logger logger =Logger.getLogger(Login.class);
if(session.getAttribute("username")==null){
	response.sendRedirect("Login.jsp");
}else{
if((Boolean)session.getAttribute("isAdmin")){
	logger.debug("admin "+session.getAttribute("username")+" logged out.");
}else{
logger.debug("user "+session.getAttribute("username")+" logged out.");
}}
session.invalidate();
response.sendRedirect("Login.jsp");
%>
</body>
</html>