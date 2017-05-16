<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<div id="header">Queue Manager Monitor</div>
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
</html>