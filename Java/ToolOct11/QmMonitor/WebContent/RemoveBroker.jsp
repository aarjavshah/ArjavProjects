<%@page import="com.cts.dnb.Application1.BrokerXML"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Broker</title>
</head>
<script type="text/javascript">
function ValidateRemoveBroker(){
	var broker=document.getElementById("broker").value;
	var flag=0;
	if(broker=="Broker")
	{	document.getElementById("span_broker").innerHTML="Enter BrokerName";
		flag=1;
	}
	if(flag==0)
		{
		document.getElementById("removeBroker").disabled = true;
		return true;		
		}
	else
		{
		return false;
		}	
}
function reDirect()
{
window.location="AdminServices.jsp";		
}
function confimation(){
	return confirm("This will remove the broker! Once done, the changes can not be reverted.\nAre you sure?");
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
<div id="header"><a href=<%=session.getAttribute("home")!=null?session.getAttribute("home").toString():"" %>><img src="home.png" height="40" width="40" alt="Home"></img>  Queue Manager Monitor</a></div>
<div id="logout"><table><tr><td>Welcome <%=session.getAttribute("username") %></td><td><a href="Logout.jsp"><img src="logg.jpg" height="25" width="25" alt="Log Out"></img></a></td></tr></table></div>
</div>
<div id="left">
<div id="centeredText">
<h1>Remove an Existing Broker</h1></div>
<form action="RemoveBroker" method="post" onsubmit="return ValidateRemoveBroker()">
<table id="adminbroker">
<tr>
<td>Broker Name<font color="Red">*</font>:</td>
<td><select name="broker" id="broker">
<option value="Broker">--Broker Name--</option>
<%
for(String br:BrokerXML.RetrievebrokerList()){%>
	<option value=<%=br %>><%=br %></option>
<%}
%>
</select>
<td><font color=red><span id="span_broker"></span></font></td>
</tr>
</table>
<table align="center">
<tr>
<td><input type="submit" name="removeBroker" id="removeBroker" value="Remove Broker" onclick="return confimation()"></td>
<td><input type=button name=back value="Go Back" onclick="reDirect()"></td>
</tr>
</table>
</form>
</div>
</body>
</html>