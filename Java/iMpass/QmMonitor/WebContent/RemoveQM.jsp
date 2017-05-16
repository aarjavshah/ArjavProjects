<%@page import="com.cts.dnb.AdminService.GetConnectionConfigList"%>
<%@page import="com.cts.dnb.Application1.UserJaxB"%>
<%@page import="com.cts.dnb.Application1.BrokerXML"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Queue-Manager</title>
</head>
<script type="text/javascript">
function ValidateRemoveBroker(){
	var broker=document.getElementById("broker").value;
	var flag=0;
	if(broker=="Broker")
	{	document.getElementById("span_broker").innerHTML="Select Queue-Manager";
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
	return confirm("This will remove the Queue-Manager! Once done, the changes can not be reverted.\nAre you sure?");
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
<div id="header"><a href=<%=session.getAttribute("home")!=null?session.getAttribute("home").toString():"" %>><img src="home.png" height="40" width="40" alt="Home"></img>  iMPAS</a></div>
<div id="logout"><table><tr><td>Welcome <%=session.getAttribute("username") %></td><td><a href="Logout.jsp"><img src="logg.jpg" height="25" width="25" alt="Log Out"></img></a></td></tr></table></div>
</div>
<div id="left">
<div id="centeredText">
<h1>Remove an Existing Queue-Manager</h1></div>
<form action="RemoveQM" method="post" onsubmit="return ValidateRemoveBroker()">
<table id="adminbroker">
<tr>
<td>Queue-Manager Name<font color="Red">*</font>:</td>
<td><select name="qmn" id="broker">
<option value="Broker">--QM Name--</option>
<%
for(String usr:GetConnectionConfigList.getQMName()){	
%>

	<option value=<%=usr %>><%=usr %></option>
<%}
%>
</select>
<td><font color=red><span id="span_broker"></span></font></td>
</tr>
</table>
<table align="center">
<tr>
<td><input type="submit" name="removeUser" id="removeUser" value="Remove Queue-Manager" onclick="return confimation()"></td>
<td><input type=button name=back value="Go Back" onclick="reDirect()"></td>
</tr>
</table>
</form>
</div>
</body>
</html>