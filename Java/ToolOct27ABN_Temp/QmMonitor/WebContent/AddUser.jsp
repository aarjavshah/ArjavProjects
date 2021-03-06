<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>
<script type="text/javascript">
function ValidateAddUser(){
	var usr=document.getElementById("usr").value;
	var type=document.getElementById("type").value;
	var pass=document.getElementById("password").value;
	var flag=0;
	if(usr.length==0)
	{	document.getElementById("span_user").innerHTML="Enter UserName";
		flag=1;
	}
	else{
		document.getElementById("span_user").innerHTML="";
	}
	
	if(pass.length==0){
		document.getElementById("span_qm").innerHTML="Enter Password";
		flag=1;
	}
	else{
		document.getElementById("span_qm").innerHTML="";
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
function enablePassword() {
    document.getElementById("password").disabled = false;
}
function disale(){
	document.getElementById("password").disabled = true;
}
</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/collapse.css" media="screen">
<body onload="disale()">
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
<div id="header"><a href=<%=session.getAttribute("home")!=null?session.getAttribute("home").toString():"" %>><img src="home.png" height="40" width="40" alt="Home"></img>  Queue Messaging Utility</a></div>
<div id="logout"><table><tr><td>Welcome <%=session.getAttribute("username") %></td><td><a href="Logout.jsp"><img src="logg.jpg" height="25" width="25" alt="Log Out"></img></a></td></tr></table></div>
</div>
<div id="left">
<div id="centeredText">
<h1>Add New User</h1></div>
<form action="AddUser" method="post" onsubmit="return ValidateAddUser()">
<table id="adminbroker">
<tr>
<td>Username<font color="Red">*</font>:</td>
<td><input type="text" name="user" id="user"></td>
<td><font color=red><span id="span_user"></span></font></td>
</tr>
<tr>
<td>User Type<font color="Red">*</font>:</td>
<td><input type="radio" name="type" value="admin" id="type" onclick="enablePassword()">Administrator<input type="radio" name="type" value="permit" id="type" onclick="disale()">Authorized</td>
<td><font color=red><span id="span_type"></span></font></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="password" id="password"></td>
<td><font color=red><span id="span_pass"></span></font></td>
</tr></table>
<table align="center">
<tr>
<td><input type="submit" name="addBroker" id="addBroker" value="Add User"></td>
<td><input type=button name=back value="Go Back" onclick="reDirect()"></td>
</tr>
</table>
</form>
</div>
</body>
</html>