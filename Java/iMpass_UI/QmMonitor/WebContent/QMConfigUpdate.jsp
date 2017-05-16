<%@page import="java.io.File"%>
<%@page import="com.cts.dnb.Application1.FilePaths"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Queue Manager Configuration</title>
</head>
<body>
<%

Date d1= new Date();
 long x = (d1.getTime() - new File(FilePaths.getQM_CONFIG()).lastModified());
 if((x/1000)<=180){
	 session.setAttribute("success", "Queue-Manager configuration updated Successfully");
		response.sendRedirect("Success.jsp");
 }else{
	 session.setAttribute("success", "Error Updating Queue-Manager configuration. Try after a while.");
		response.sendRedirect("Error.jsp");
 }
%>
</body>
</html>