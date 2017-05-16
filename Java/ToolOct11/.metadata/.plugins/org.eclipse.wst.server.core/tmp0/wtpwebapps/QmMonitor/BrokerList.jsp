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
<title>Browse Brokers</title>
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
logger.debug("admin "+session.getAttribute("username")+" loaded the Broker Configuration List");
%>
<div id="outer"> 
<div id="header"><a href=<%=session.getAttribute("home")!=null?session.getAttribute("home").toString():"" %>><img src="home.png" height="40" width="40" alt="Home"></img>  Queue Manager Monitor</a></div>
<div id="logout"><table><tr><td>Welcome <%=session.getAttribute("username") %></td><td><a href="Logout.jsp"><img src="logg.jpg" height="25" width="25" alt="Log Out"></img></a></td></tr></table></div>
</div>
<div id="left">
<div id="centeredText">
<h1>Existing Broker List</h1></div>
<div id="right">
<h1>Brokers</h1>
<ol class="tree">

<%for(BrokerDetailsVO b :BrokerXML.RetrieveDetailedbrokerList()){%>
	<div id="textbox"><li>
	<label for="<%=b.getBrokerName() %>"><%=b.getBrokerName() %></label>
	<input type="checkbox" id="<%=b.getBrokerName()%>"> 
	<ol>
	<li class="file"><a href="#">Environment Name : <%=b.getAlias() %></a></li>
	<li class="file"><a href="#">Queue Manager Name : <%=b.getQueueManagerName()%></a></li>
	<li class="file"><a href="#">Host IP : <%=b.getHost() %></a></li>
	<li class="file"><a href="#">Port Number : <%=b.getPort() %></a></li>
	<li class="file"><a href="#"><form action="EditBroker" method="post"><input type="hidden" name="brokerName" value="<%=b.getBrokerName()%>"/><input type="submit" id="edit" name="Edit" value="Edit"></form></a></li>
	</ol></li>
<%}%>
</div>
</ol>
<input type=button name=back value="Go Back" onclick="reDirect()">
</div></div>
</body>
</html>