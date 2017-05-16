<%@page import="com.cts.dnb.Controller.Login"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="com.cts.dnb.Application2.QueueBrowser"%>
<%@page import="com.cts.dnb.model3.QueueManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cts.dnb.Application1.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Queue Manager Info</title>
</head>
<script type="text/javascript">
function reDirect()
{
window.location="Home.jsp";		
}
</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/collapse.css" media="screen">
<body>

<%
if(session.getAttribute("username") == null){response.sendRedirect("Login.jsp");}
Logger logger = Logger.getLogger(Login.class);
logger.debug("user "+session.getAttribute("username")+" loaded the Queue Manager Configuration List");
%>
<div id="outer"> 
<div id="header"><a href=<%=session.getAttribute("home")!=null?session.getAttribute("home").toString():"" %>><img src="home.png" height="40" width="40" alt="Home"></img>  iMPAS</a></div>
<div id="logout"><table><tr><td>Welcome <%=session.getAttribute("username") %></td><td><a href="Logout.jsp"><img src="logg.jpg" height="25" width="25" alt="Log Out"></img></a></td></tr></table></div>
</div>
<div id="left">
<div id="centeredText">
<h1>Existing Queue Manager List</h1></div>
<div id="right">
<h1>Queue Managers</h1>
<ol class="tree">

<%for(QueueManager qm :QueueBrowser.getQMRoot().getQueueManager()){%>
	<div id="textbox"><li>
	<label for="<%=qm.getConnectConfig().getQMname() %>"><%=qm.getConnectConfig().getQMname() %></label>
	<input type="checkbox" id="<%=qm.getConnectConfig().getQMname()%>"> 
	<ol>
	<li class="file"><a href="#">Environment Name : <%=qm.getEnvironment() %></a></li>
	<li class="file"><a href="#">Host IP : <%=qm.getConnectConfig().getQMhost() %></a></li>
	<li class="file"><a href="#">Port Number : <%=qm.getConnectConfig().getQMport()%></a></li>
	
	</ol></li>
<%}%>
</div>
</ol>
<input type=button name=back value="Go Back" onclick="reDirect()">
</div></div>
</body>
</html>