<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <!-- Adding version wise control of the form values. For Version<9 QM is mandatory param. for version 10, it is optional.
  	Similar changes will be required to the XSD and the connection method. for version 10 different connection method.
   -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>iMPAS : Add Broker</title>
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
function display_c(){
	var refresh=1000; // Refresh rate in milli seconds
	setTimeout('display_ct()',refresh)
	}

function display_ct() {
	var strcount;
	var x = new Date();
	var hour=x.getHours();

	if(hour>=0 && hour<12)
	document.getElementById('time').innerHTML = hour + ":"+ x.getMinutes() + ":" +x.getSeconds() + " am     ";
	
	else if(hour==12)
		document.getElementById('time').innerHTML = hour + ":"+ x.getMinutes() + ":" +x.getSeconds() + " pm     ";
	else
	document.getElementById('time').innerHTML = (hour-12) + ":"+ x.getMinutes() + ":" +x.getSeconds() + " pm     ";	
	
	document.getElementById('date').innerHTML = x.getDate() + "-"+ (x.getMonth()+1) + "-" +x.getFullYear() ;
	display_c();
	 }
function load()
{
		document.getElementById("about").innerHTML=
			" This is required in case you are setting up the tool for the first time or a new broker is added to the scope."+
			" You need to provide connection information about broker."+
			" Broker Name, Environment, Hostname and port are the connection parameters needed for tool to connect to the broker."+
			" <br><br><strong>#This does not facilitate the creation of a new broker, but it adds an existing broker to the scope of the tool.<strong> ";
		document.getElementById("open").innerHTML="";		
		document.getElementById("close").innerHTML="...hide";
		
}

function unload()
{
		document.getElementById("about").innerHTML="";
		document.getElementById("open").innerHTML="...learn more";		
		document.getElementById("close").innerHTML="";
		
}

</script>
<link href="default.css" rel="stylesheet" type="text/css" />
<link href="fonts.css" rel="stylesheet" type="text/css" />
<body style="overflow: hidden" onload=display_ct();>
<%if(session.getAttribute("isAdmin")==null ){
response.sendRedirect("Login.jsp");}
else if(!(Boolean)session.getAttribute("isAdmin")){
	if(session.getAttribute("username")==null){
		response.sendRedirect("Login.jsp");	
	}else{
		response.sendRedirect("Welcome.jsp");
	}
	
}	%>
<div id="wrapper">
	<div id="menu-wrapper">
		
		<table>
		<tr>
		<td>
	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo">
				<h1><a href="<%=session.getAttribute("home")!=null?session.getAttribute("home").toString():"" %>">iMPAS</a></h1>
			</div>
		</div>
	</div>
	</td>
		<td>
		<div id="menu" class="container">
			<ul>
				<li class="current_page_item"><a href="<%=session.getAttribute("home")!=null?session.getAttribute("home").toString():"" %>">Welcome Page</a></li>
				<li><a href="contact.jsp">Contact</a></li>
			</ul>
		</div>
		
	
	</td>
	<td>
	<table width="100%">
	<tr>
	<td align="center"><a href="Logout.jsp"><img src="<%= request.getContextPath()%>/img/logout-1.png" height="40" width="40" alt="logout"></img></a>
	<tr>
	<td align="center"><font color=white>Logout <%=session.getAttribute("username") %></font>
	</table>
	</td>
	</tr>
	
	</tr>
	</table>
	
	</div>
	
<div id="banner1">

<div style="height:0%;" id="out_search">
<div id="in_search" style="text-align:=center;">
<table ><tr><td width = "550px">
<table><tr><td align="center">
<h1>Add New Broker<sup>#</sup></h1></td></tr><tr><td> </td></tr><tr><td> </td></tr>
</table>
<table id="formTable">
<form action="AddBroker" method="post" onsubmit="return ValidateAddBroker()">
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
<table>
<tr>
<td width=157px"><input type="submit" name="addBroker" id="addBroker" value="Add Broker"></td>
<td><input type=button name=back value="Go Back" onclick="reDirect()"></td>
</tr>
</form>
</table>
</td><td>
<div id="define">
<p >Adding a broker to the scope of the tool can be done from here.<span id="about"></span>
<a href="javascript:load()" id="open">...learn more</a>
<a href="javascript:unload()" id="close"></a>
</br>
</p>
</div></td></tr></table>
</div>
</div>

</div>
</div>
</div>

</div>

</div>

<div id="copyright" class="container">
<div style="height:75%;" id="out_copy">
<div id="in_copy" style="text-align:=center;">
	<table>
	<tr>
	<td>
	&copy;copyright cognizant 2011-2020
	<td>
	<img src="<%= request.getContextPath()%>/img/cognizant.png" height="50" width="60" alt="Add New Batch"></img>
	<tr>
	<td>
	<span id="time"></span><span id="date"></span>
	</table>
	
</div>
</div>
</div>

</body>
</html>