<%@page import="com.cts.dnb.Controller.Login"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cts.dnb.Application1.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
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
		response.sendRedirect("Home.jsp");
	}
	
}	
Logger logger = Logger.getLogger(Login.class);
logger.debug("admin "+session.getAttribute("username")+" loaded the User List");
%>
<div id="outer"> 
<div id="header"><a href=<%=session.getAttribute("home")!=null?session.getAttribute("home").toString():"" %>><img src="home.png" height="40" width="40" alt="Home"></img>  iMPAS</a></div>
<div id="logout"><table><tr><td>Welcome <%=session.getAttribute("username") %></td><td><a href="Logout.jsp"><img src="logg.jpg" height="25" width="25" alt="Log Out"></img></a></td></tr></table></div>
</div>
<div id="left">
<div id="centeredText">
<h1>Search an Existing User</h1></div>
<form action="UserDetails.jsp" method="post" onsubmit="return ValidateRemoveBroker()">
<table id="adminbroker">
<tr>
<td>User Name<font color="Red">*</font>:</td>
<td><select name="user" id="broker">
<option value="Broker">--User Name--</option>
<%
for(String usr:UserJaxB.GetUserList()){%>
	<option value=<%=usr %>><%=usr %></option>
<%}
%>
</select>
<td><font color=red><span id="span_broker"></span></font></td>
</tr>
</table>
<table align="center">
<tr>
<td><input type="submit" name="removeUser" id="removeUser" value="Search User"></td>
<td><input type=button name=back value="Go Back" onclick="reDirect()"></td>
</tr>
</table>
</form>
</div>
</body>
</html>