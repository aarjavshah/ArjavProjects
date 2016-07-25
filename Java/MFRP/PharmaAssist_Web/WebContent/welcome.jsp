<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pharma Assist</title>
<link rel="shortcut icon" href="/PharmaAssist/img/rx-logo-hi.ico"></link>
<link href="default.css" rel="stylesheet" type="text/css" />
<link href="fonts.css" rel="stylesheet" type="text/css" />
<!--  
 * CSS and Java Script
 * 
 * @version 1
 * @author 455185(Somasri Kar)
 * */ -->
<script type="text/javascript">

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
	
	if(pass.length==0)
		document.getElementById("span_pass").innerHTML="Password is Compulsory";
	
	else if(pass.length < 8)
		document.getElementById("span_pass").innerHTML="Password is Length less than 8 !";
	
	else if(pass.length >16)
		document.getElementById("span_pass").innerHTML="Password Length exceeds 16 !";
	 
	if(name.length==0)
		document.getElementById("span_name").innerHTML="Username is Compulsory";

	
		
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
		document.getElementById("about").innerHTML="You can learn more here................!!!!!:-)";
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

<!--  
 * Login JSP page Business Logic
 * 
 * @version 1
 * @author 454579(Fenil Tailor)
 * */ -->

<body onload="display_ct();">

<div id="wrapper">
	<div id="menu-wrapper">
		
		<table>
		<tr>
		<td>
	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo">
				<h1><a>Pharma Assist</a></h1>
				
			</div>
		</div>
	</div>
	</td>
		<td>
		<div id="menu" class="container">
			<ul>
				<li class="current_page_item"><a href="welcome.jsp">Welcome Page</a></li>
				<li><a href="contact.jsp">Contact</a></li>
			</ul>
		</div>
		
	
	</td>
	
	<td>
	<table width="100%">
	<tr>
	<td align="center"><a href="Logout.jsp"><img src="<%= request.getContextPath()%>/img/logout-1.png" height="40" width="40" alt="Add New Batch"></img></a>
	<tr>
	<td align="center"><font color=white>Welcome 
	<%
	if(session.getAttribute("session_username")!=null)
	out.println(session.getAttribute("session_username").toString());%></font>
	</table>
	</td>
	</tr>
	
	</table>
	
	</div>
	
<div class="banner" id="banner">

<div style="height:75%;" id="out_wel">
<div id="in_wel" style="text-align:=center;">
<table align="center" width="100%">
<tr>
<td align="center" width="200px">

<% response.setHeader("Cache-Control","no-cache,no-store");  
 response.setHeader("Pragma","no-cache");
 response.setDateHeader ("Expires", 0);  
%>

<%
if(request.getParameter("search")!=null||request.getParameter("update")!=null||request.getParameter("delete")!=null||request.getParameter("add")!=null)
{
String x="";
x=request.getAttribute("welcome").toString();

if(x.equals("updateTrue")){
	out.print("<font color=green> <span style=\"text-align:center;\">Batch updated successfully.</span></font>");
}
else if(x.equals("updateFalse")){
	out.print("<font color=red> <span style=\"text-align:center;\">Batch can not be updated.Entered batchcode already exist</span></font>");
}
else if(x.equals("addTrue")){
	out.print("<font color=green> <span style=\"text-align:center;\">Batch added successfully.</span></font>");
}
else if(x.equals("addFalse")){
	out.print("<font color=red> <span style=\"text-align:center;\">Batch can not be added.Entered batchcode already exist.</span></font>");
}
else if(x.equals("deleteTrue")){
	out.print("<font color=green> <span style=\"text-align:center;\">Batch deleted successfully.</span></font>");
}
else if(x.equals("deleteFalse")){
	out.print("<font color=red> <span style=\"text-align:center;\">Batch can not be deleted.</span></font>");
}
}
/*if(request.getParameter("login")!=null){
String username=(String)request.getParameter("username");
session.setAttribute("session_username", username);
session.setMaxInactiveInterval(180);}*/
if((String)session.getAttribute("session_username")==null)
{
	response.sendRedirect("login.jsp");
}
//out.print("Welcome"+(String)session.getAttribute("session_username"));
%>
</td>
</tr>
</table>
<br></br>
<br></br>
<table width="130%">
<tr><td width="25%" align="center"><a href="addbatch.jsp"><img src="<%= request.getContextPath()%>/img/add_folder.png" height="100" width="100" alt="Add New Batch"></img></a>
<td width="25%" align="center"><a href="searchbatch.jsp"><img src="<%= request.getContextPath()%>/img/search.png" height="100" width="100" alt="Search Batch"></img></a>
<td width="25%" align="center"><a href="deletebatch.jsp"><img src="<%= request.getContextPath()%>/img/delle.png" height="100" width="100" alt="Delete Batch"></img></a>
<td width="25%" align="center"><a href="Logout.jsp"><img src="<%= request.getContextPath()%>/img/logg.jpg" height="100" width="100" alt="Logout"></img></a>
</table>
<table width="130%">
<tr>
<td width="25%" align="center">Add New Batch
<td width="25%" align="center">Search Batch
<td width="25%" align="center">Delete Batch
<td width="25%" align="center">Logout
</table>
</div>
</div>
</div>

</div>

</div>

<div id="copyright" class="container">
<div id="out_copy">
<div id="in_copy" style="text-align:=center;">
	<table>
	<tr>
	<td>
	&copy;copyright cognizant 2011-2020
	<td>
	<img src="<%= request.getContextPath()%>/profile/cognizant.png" height="50" width="60" alt="Add New Batch"></img>
	<tr>
	<td>
	<span id="time"></span><span id="date"></span>
	</table>
	
</div>
</div>
</div>

</body>
</html>




