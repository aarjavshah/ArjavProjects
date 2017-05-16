<%@page import="com.cts.dnb.AdminService.GetConnectionConfigList"%>
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
<title>Browse Queue-Managers</title>
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
logger.debug("admin "+session.getAttribute("username")+" loaded the Queue-Manager Configuration List");
%>
<div id="outer"> 
<div id="header"><a href=<%=session.getAttribute("home")!=null?session.getAttribute("home").toString():"" %>><img src="home.png" height="40" width="40" alt="Home"></img>  Queue Manager Monitor</a></div>
<div id="logout"><table><tr><td>Welcome <%=session.getAttribute("username") %></td><td><a href="Logout.jsp"><img src="logg.jpg" height="25" width="25" alt="Log Out"></img></a></td></tr></table></div>
</div>
<div id="left">
<div id="centeredText">
<h1>Existing Queue-Manager List</h1></div>
<div id="right">
<h1>Brokers</h1>
<ol class="tree">

<%for(QMUtilityVO tmp : GetConnectionConfigList.RetrieveQmConnectList()){%>
	<div id="textbox"><li>
	<label for="<%=tmp.getCon().getQMname() %>"><%=tmp.getCon().getQMname() %></label>
	<input type="checkbox" id="<%=tmp.getCon().getQMname()%>"> 
	<ol>
	<li class="file"><a href="#">Environment Name : <%=tmp.getEnv() %></a></li>
	<li class="file"><a href="#">Server-Connection Channel : <%=tmp.getCon().getQMchannel()%></a></li>
	<li class="file"><a href="#">Host IP : <%=tmp.getCon().getQMhost() %></a></li>
	<li class="file"><a href="#">Port Number : <%=tmp.getCon().getQMport() %></a></li>
	<li class="file"><a href="#"><form action="EditQm" method="post"><input type="hidden" name="qmn" value="<%=tmp.getCon().getQMname()%>"/><input type="submit" id="edit" name="Edit" value="Edit"></form></a></li>
	</ol></li>
<%}%>
</div>
</ol>
<input type=button name=back value="Go Back" onclick="reDirect()">
</div></div>
</body>
</html>