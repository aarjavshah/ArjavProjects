<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="/PharmaAssist/img/rx-logo-hi.ico"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <!--  
 * Logout JSP page Business Logic
 * 
 * @version 1
 * @author 454582(Arjav Shah)
 * */ -->
 <% response.setHeader("Cache-Control","no-cache,no-store");  
 response.setHeader("Pragma","no-cache");
 response.setDateHeader ("Expires", 0);  
%>

<%if(session.getAttribute("session_username")!=null){
//UserDAO ResetLoginCount=new UserDAO();
//ResetLoginCount.reactivationafterexit(session.getAttribute("session_username").toString());
session.invalidate();
//System.out.println(session.getAttribute("session_username").toString());
}%>
<%
response.sendRedirect("login.jsp");
//RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
//request.setAttribute("wrong", "1");
//rd.forward(request, response);
%>
</body>
</html>