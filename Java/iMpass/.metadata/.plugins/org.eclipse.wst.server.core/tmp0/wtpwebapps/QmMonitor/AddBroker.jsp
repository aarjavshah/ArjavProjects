<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Broker</title>
</head>
<script type="text/javascript">
function ValidateAddBroker(){
	var broker=document.getElementById("broker").value;
	var alias=document.getElementById("alias").value;
	var host=document.getElementById("host").value;
	var port=document.getElementById("port").value;
	var qm=document.getElementById("qm").value;
	var flag=0;
	if(alias.length==0)
	{	document.getElementById("span_alias").innerHTML="Enter Environment";
		flag=1;
	}
	else{
		document.getElementById("span_alias").innerHTML="";
	}
	if(broker.length==0)
	{	document.getElementById("span_broker").innerHTML="Enter BrokerName";
		flag=1;
	}
	else{
		document.getElementById("span_broker").innerHTML="";
	}
	if(qm.length==0){
		document.getElementById("span_qm").innerHTML="Enter Queue-Manager Name";
		flag=1;
	}
	else{
		document.getElementById("span_qm").innerHTML="";
	}
	if(host.length==0)
	{	document.getElementById("span_host").innerHTML="Enter Host IP address";
		flag=1;
	}
	else{
		document.getElementById("span_host").innerHTML="";
	}
	if(port.length==0)
	{	document.getElementById("span_port").innerHTML="Enter Port";
		flag=1;
	}
	else if(isNaN(port))
	{	document.getElementById("span_port").innerHTML="Port should be number";
		flag=1;
	}
	else{
		document.getElementById("span_port").innerHTML="";
	}
	if(flag==0)
		{
		document.getElementById("addBroker").disabled = true;
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
function disableIt() {
    document.getElementById("addBroker").disabled = true;
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
<h1>Add New Broker</h1></div>
<form action="AddBroker" method="post" onsubmit="return ValidateAddBroker()">
<table id="adminbroker">
<tr>
<td>Environment<font color="Red">*</font>:</td>
<td><input type="text" name="alias" id="alias"></td>
<td><font color=red><span id="span_alias"></span></font></td>
</tr>
<tr>
<td>Broker Name<font color="Red">*</font>:</td>
<td><input type="text" name="broker" id="broker"></td>
<td><font color=red><span id="span_broker"></span></font></td>
</tr>
<tr>
<td>Queue-Manager Name<font color="Red">*</font>:</td>
<td><input type="text" name="qm" id="qm"></td>
<td><font color=red><span id="span_qm"></span></font></td>
</tr>
<tr>
<td>Host IP<font color="Red">*</font>:</td>
<td><input type="text" name="host" id="host"></td>
<td><font color=red><span id="span_host"></span></font></td>
</tr>
<tr>
<td>Port Number<font color="Red">*</font>:</td>
<td><input type="text" name="port" id="port"></td>
<td><font color=red><span id="span_port"></span></font></td>
</tr>
</table>
<table align="center">
<tr>
<td><input type="submit" name="addBroker" id="addBroker" value="Add Broker"></td>
<td><input type=button name=back value="Go Back" onclick="reDirect()"></td>
</tr>
</table>
</form>
</div>
</body>
</html>