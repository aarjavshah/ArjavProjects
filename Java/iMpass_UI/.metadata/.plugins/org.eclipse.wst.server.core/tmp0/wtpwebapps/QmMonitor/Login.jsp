<!--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ESB Queue-Manager Monitor Login</title>
</head>
<script type="text/javascript">
function GetPassword() {
	password.style.visibility = 'visible';
	adminLink.style.visibility = 'hidden';
}
function  RemovePassword() {
	password.style.visibility = 'hidden';
	adminLink.style.visibility = 'visible';
}
function ValidateLogin(){
	var userName=document.getElementById("username").value;
	var flag=0;
	if(userName.length==0)
	{	document.getElementById("span_broker").innerHTML="Enter UserName";
		flag=1;
	}else{
		document.getElementById("span_broker").innerHTML="";
	}
	if(flag==0)
	{
	return true;		
	}
else
	{
	return false;
	}
	}
</script>
 <STYLE type="text/css" media="screen">
    td{width:300px;}
    #dont{width:93px;}
    #button{width:53px;}
 </STYLE>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/collapse.css" media="screen">
<body>
<%if(session.getAttribute("username")!=null){
	if((Boolean)session.getAttribute("isAdmin")){
		response.sendRedirect("AdminServices.jsp");		
	}else{
		response.sendRedirect("Home.jsp");
	}
}	%>
<div id="header2">iMPAS : IBM Messaging Platform Access Simplified</div>
<div id="desc">
<p>
	<div id="textbox"><img src="Bullet.png" height="10px" width="10px">
	This tool gives the information about Queues, Channels, Brokers, execution groups and deployed services.</div><div id="textbox"><img src="Bullet.png"  height="10px" width="10px">
	Select an environment (dev,QA,Stag etc) which will provide list of queue managers/brokers available on this environment.</div><div id="textbox"><img src="Bullet.png"  height="10px" width="10px">
	Select a queue manager/broker from the list. </div><div id="textbox2">     <img src="Bullet.png"  height="10px" width="10px">
	On selecting broker it will display all flows ,status (running or stopped) deployed on this broker.
	Information about Services like deployment date, version, instances of the messageFlow and the status of the service will be displayed.
	</div><div id="textbox2"><img src="Bullet.png"  height="10px" width="10px">
	On selecting queue manager the information about queue properties and channel status will be displayed
	</div>
</p>
</div>
<form action="Login" method="post" onsubmit="return ValidateLogin()">
<div id="err">
<%if(session.getAttribute("AdminLoginFail")!=null){
if((Boolean)session.getAttribute("AdminLoginFail")){
	out.print("<font color=red>Admin Login Failed</font>");
	session.removeAttribute("AdminLoginFail");
}}
%></div>

<table id="adminbroker">
<tr id="user">
	<td id="dont" align="right">Username:</td>
	<td><input type="text" name="username" id="username" placeholder="Use your Employee ID"></td>
	<td><font color=red><span id="span_broker"></span></font></td><td> </td>
	<td id="adminLink" onclick="GetPassword()"><a href="#">Admin Login</a></td>
</tr>
<tr id="password" style="visibility:hidden;">
	<td id="dont" align="right">Password:</td>
	<td><input type="password" name="password" ></td><td> </td><td> </td>
	<td id="userLink" onclick="RemovePassword()"><a href="#">User Login</a></td>
</tr>
</table>
<table align="center">
<tr>
<td id="button"><input type="submit" name ="login" value="Login"></td>
</tr>
</table>
</form>
</body>
</html>-->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pharma Assist</title>
<link rel="shortcut icon" href="<%= request.getContextPath()%>/img/rx-logo-hi.ico"></link>
<link href="default.css" rel="stylesheet" type="text/css" />
<link href="fonts.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
function GetPassword() {
	password.style.visibility = 'visible';
	adminLink.style.visibility = 'hidden';
}
function  RemovePassword() {
	password.style.visibility = 'hidden';
	adminLink.style.visibility = 'visible';
}
function ValidateLogin(){
	var userName=document.getElementById("username").value;
	var flag=0;
	if(userName.length==0)
	{	document.getElementById("span_broker").innerHTML="Enter UserName";
		flag=1;
	}else{
		document.getElementById("span_broker").innerHTML="";
	}
	if(flag==0)
	{
	return true;		
	}
else
	{
	return false;
	}
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
	

function validate()
{
	var name=document.getElementById("username").value;
	var pass=document.getElementById("password").value;
	var flag=0;
	
	if(pass.length==0)
		{
		document.getElementById("span_pass").innerHTML="Password is Compulsory";
		flag=1;
		}
	else if(pass.length < 8)
		{
		document.getElementById("span_pass").innerHTML="Password is Length less than 8 !";
		flag=1;
		}
	else if(pass.length >16)
		{
		document.getElementById("span_pass").innerHTML="Password Length exceeds 16 !";
		flag=1;
		}
	 
	if(name.length==0)
		{
		document.getElementById("span_name").innerHTML="Username is Compulsory";
		flag=1;
		}

	if(flag==0)
		{
			return true;
		}	
	else
		{
		return false;
		}
}


function clean()
{
		document.getElementById("span_name").innerHTML="";
		document.getElementById("span_pass").innerHTML="";
		document.getElementById("username").value="";
		document.getElementById("password").value="";
		
}

function load()
{
		document.getElementById("about").innerHTML=
			" This Utility facilitates virtual read only access to IBM Messaging Platform (WMQ and WMB/IIB). "+
			"Utility will enable access to objects and messages for live data. "+
			"It provides on demand data view and object health check.";
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
</head>
<body onload=display_ct();>

<div id="wrapper">
	<div id="menu-wrapper">
		
		<table>
		<tr>
		<td>
	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo">
				<h1><a>iMPAS</a></h1>
				
			</div>
		</div>
	</div>
	</td>
		<td>
		<div id="menu" class="container">
			<ul>
				<li class="current_page_item"><a href="login.jsp">Homepage</a></li>
				<li><a href="contact1.jsp">Contact</a></li>
			</ul>
		</div>
		
	
	</td>
	
	</tr>
	</table>
	
	</div>
	
<div id="banner">

<table style="height:75%;">

<td>
<div id="define">
<p >iMPAS (IBM Messaging Platform Access Simplified) is an utility designed by Cognizant.<span id="about"></span>
<a href="javascript:load()" id="open">...learn more</a>
<a href="javascript:unload()" id="close"></a>
</br>
</p>
</div>
</td>

<td>

<div style="height:75%;" id="out_index">
<div id="in_index" style="text-align:=center;">

<form action="Login" method="post" onsubmit="return ValidateLogin()">



<table align=center>
<tr>
<td>
<%if(session.getAttribute("AdminLoginFail")!=null){
if((Boolean)session.getAttribute("AdminLoginFail")){
	out.print("<font color=red>Admin Login Failed</font>");
	session.removeAttribute("AdminLoginFail");
}}
%>

<table id="adminbroker">
<tr id="user">
	<td id="dont" align="right">Username:</td>
	<td><input type="text" name="username" id="username" placeholder="Use your Employee ID"></td>
	<td><font color=red><span id="span_broker"></span></font></td><td> </td>
	<td id="adminLink" onclick="GetPassword()"><a href="#">Admin Login</a></td>
</tr>
<tr id="password" style="visibility:hidden;">
	<td id="dont" align="right">Password:</td>
	<td><input type="password" name="password" ></td><td> </td><td> </td>
	<td id="userLink" onclick="RemovePassword()"><a href="#">User Login</a></td>
</tr>
</table>
<table align="center">
<tr>
<td id="button"><input type="submit" name ="login" value="Login"></td>
</tr>
</table>

</td>
</tr>
</table>


</form>
</div>
</div>

</td>
</table>
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
	<img src="<%= request.getContextPath()%>/img/cognizant.png" height="50" width="60" alt="cts_logo"></img>
	<tr>
	<td>
	<span id="time"></span><span id="date"></span>
	</table>
	
</div>
</div>
</div>

</body>
</html>






