<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="java.util.Arrays"%>
<%@ page import="com.cts.pharma.dao.BatchDAO" %>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pharma Assist</title>
<link rel="shortcut icon" href="/PharmaAssist/img/rx-logo-hi.ico"></link>
<link href="default.css" rel="stylesheet" type="text/css" />
<link href="fonts.css" rel="stylesheet" type="text/css" />

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
	clean();
	
	var batchcode=document.getElementById("batchcode").value;
	
	var flag=0;
	
	if(batchcode.length==0)
	{	document.getElementById("span_batch").innerHTML="Select Batchcode";
		flag=1;
	}
	
	else
	{	document.getElementById("span_batch").innerHTML="";
		
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
		document.getElementById("span_batch").innerHTML="";
		
		
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

function reDirect()
{
window.location="welcome.jsp";		
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
	<td align="center"><font color=white>Logout</font>
	</table>
	</td>
	</tr>
	
	</tr>
	</table>
	
	</div>
	
<div id="banner">

<Form action=SearchBatch method=post onsubmit="return validate()">
<div style="height:75%;" id="out_search">
<div id="in_search" style="text-align:=center;">

<% response.setHeader("Cache-Control","no-cache,no-store");  
 response.setHeader("Pragma","no-cache");
 response.setDateHeader ("Expires", 0);  
%>

<%
if(request.getParameter("search")!=null)
{
String x="";
x=request.getAttribute("search").toString();

if(x.equals("searchFalse")){
	out.print("<font color=Red> <span style=\"text-align:center;\">Batch was not found.<br>Please try again.</span></font>");
}
}
if((String)session.getAttribute("session_username")==null)
{
	response.sendRedirect("login.jsp");
}
//out.print("Welcome"+(String)session.getAttribute("session_username"));
%>
<table >
<tr><td width="150px">BATCH CODE<td><select name=batchcode id="batchcode" width="175" style="width: 175px">
<option value="">--Select--
<%
String batchcode[]=new BatchDAO().getBatchCodes();
for(int i=0;i<batchcode.length;i++){
	out.println("<option value="+batchcode[i]+">"+batchcode[i]); 
}
%>
</select>
<td><font color=red><span id="span_batch"></span></font></td>
</table>

<table>
<tr>
<td width="150px"><input type=button name=cancel value=CANCEL onclick="reDirect()"></input>
<td width="100px"><input type=submit name=search value=SEARCH>
</table>
</div>
</div>
</Form>
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
















