<%@page import="com.cts.dnb.Application1.UserJaxB"%>
<%@page import="com.cts.dnb.Application1.BrokerXML"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>iMPAS : Remove User</title>
</head>
<script type="text/javascript">
function ValidateRemoveBroker(){
	var broker=document.getElementById("broker").value;
	var flag=0;
	if(broker=="Broker")
	{	document.getElementById("span_broker").innerHTML="Enter UserName";
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
	return confirm("This will remove the User! Once done, the changes can not be reverted.\nAre you sure?");
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
<body style="overflow: hidden" onload="display_ct()">
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
<h1>Remove an Existing User<sup>#</sup></h1></td></tr><tr><td> </td></tr><tr><td> </td></tr>
</table>
<table id="formTable">
<form action="RemoveUser" method="post" onsubmit="return ValidateRemoveBroker()">
<table id="adminbroker">
<tr>
<td width="94px">User Name<font color="Red">*</font>:</td>
<td><select name="user" id="broker">
<option value="Broker">--User Name--</option>
<%
for(String usr:UserJaxB.GetUserList()){
	if(usr.equals((String)session.getAttribute("username"))){;}else{
%>

	<option value=<%=usr %>><%=usr %></option>
<%}}
%>
</select>
<td><font color=red><span id="span_broker"></span></font></td>
</tr>
</table>
<table>
<tr>
<td width="94px"><input type="submit" name="removeUser" id="removeUser" value="Remove User" onclick="return confimation()"></td>
<td><input type=button name=back value="Go Back" onclick="reDirect()"></td>
</tr>
</table>
</form>
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