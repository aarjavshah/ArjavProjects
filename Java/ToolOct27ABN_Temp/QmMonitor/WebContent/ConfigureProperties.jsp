<%@page import="com.cts.dnb.AdminService.UpdateFile"%>
<%@page import="com.cts.dnb.Application1.FilePaths"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Configure Properties</title>
</head>
<script type="text/javascript">
function reDirect()
{
window.location="AdminServices.jsp";		
}
</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/collapse.css" media="screen">
<body>
<%if(session.getAttribute("isAdmin")==null ){
response.sendRedirect("Login.jsp");}
else if(!(Boolean)session.getAttribute("isAdmin")){
	if(session.getAttribute("username")==null){
		response.sendRedirect("Login.jsp");	
	}else{
		response.sendRedirect("Welcome.jsp");
	}
	
}	%>
<div id="outer"> 
<div id="header"><a href=<%=session.getAttribute("home")!=null?session.getAttribute("home").toString():"" %>><img src="home.png" height="40" width="40" alt="Home"></img>  Queue Messaging Utility</a></div>
<div id="logout"><table><tr><td>Welcome <%=session.getAttribute("username") %></td><td><a href="Logout.jsp"><img src="logg.jpg" height="25" width="25" alt="Log Out"></img></a></td></tr></table></div>
</div>
<div id="left">
<div id="centeredText">
<h1>Change the Application Properties</h1></div>
<form action="UpdateFilePaths" method="post">
<table id="adminbroker1">
<tr>
<td>Broker Details File : </td><td><%=FilePaths.getBrokerDetails()%></td>
</tr>
<tr>
<td>Broker Status File : </td><td><%=FilePaths.getBrokerStatus()%></td>
</tr>
<tr>
<td>Log File : </td><td><%=FilePaths.getLOG()%></td>
</tr>
<tr>
<td>Flow Input Queue : </td><td><%=FilePaths.getCH_INPUT()%></td>
</tr>
<tr>
<td>Flow Output Queue : </td><td><%=FilePaths.getCH_OUTPUT()%></td>
</tr>
<tr>
<td>QM Objects File : </td><td><%=FilePaths.getQM_CONFIG()%></td>
</tr>
<tr>
<td>QM Connection File: </td><td><%=FilePaths.getCON_LIST()%></td>
</tr>
<tr>
<td>User Access List: </td><td><%=FilePaths.getUSER_LIST()%></td>
</tr>
<tr>
<td>XML Utility Sleep Time : </td><td><%=FilePaths.getWAIT_TIME_MIN()%></td>
</tr>
</table>
<table align="center"><tr><td>
<%StringBuffer location=new StringBuffer(FilePaths.CONFIG_PATH);
//location = location.delete(location.length()-23, location.length());
String x = location.toString().replace('\\', '/');
%>
To Update these Properties Refer <a href="file:/<%=x %>" target="_blank">Configuration File</a></td></tr>
</table>
<table align="center">
<tr>
<td><input type="submit" name="UpdateProperties" id="UpdateProperties" value="Update Properties" disabled="disabled"></td>
<td><input type=button name=back value="Go Back" onclick="reDirect()"></td>
</tr>
</table>
</form>
</div>
</body>
</html>