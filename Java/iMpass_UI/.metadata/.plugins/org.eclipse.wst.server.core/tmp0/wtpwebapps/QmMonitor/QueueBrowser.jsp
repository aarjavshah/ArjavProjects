<%@page import="com.cts.dnb.Application2.QueueBrowser"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="com.cts.dnb.Application1.BrokerXML"%>
<%@page import="com.cts.dnb.Application1.BrokerDetailsVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.cts.dnb.Application1.jaxB" %>
<%@ page import="com.cts.dnb.model1.*" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Queue Browser</title>
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
	


/*function PrefixChange(){
	var StartsWith = document.getElementById("StartsWith").value;
	//var broker = document.getElementById("brokerName").value;
	var flag=0;
	if(alias=="prefix"){
		document.getElementById("span_StartsWith").innerHTML=" Select the starting letter of the queue";
		flag=1;
	}
	else{
		document.getElementById("span_StartsWith").innerHTML="";
	}
	
	if(flag==0){
		document.getElementById("form0").submit();
	}
}*/
function PrefixChange(){
	var px = document.getElementById("StartsWith").value;
	var flag=0;
	if(px=="prefix"){
		document.getElementById("span_Sw").innerHTML = " Select the starting letter";
		flag=1;
	}else{
		document.getElementById("span_Sw").innerHTML = "";
	}
	if(flag==0){
		document.getElementById("form0").submit();
	}
}
function qChange(){
	var q = document.getElementById("qName").value;
	var flag=0;
	if(q=="Queue"){
		document.getElementById("span_broker").innerHTML="Select the Queue";
		flag=1;
	}
	else{
		document.getElementById("span_broker").innerHTML="";
	}
	if(flag==0){
		document.getElementById("submit").disabled = true;
		return true;
		//document.getElementById("form").submit();
	}
	else{
		return false;
	}
}
function QmChange(){
	var qm = document.getElementById("qmName").value;
	var flag=0;
	if(qm=="val"){
		document.getElementById("span_qm").innerHTML = " Select Queue Manager";
		flag=1;
	}else{
		document.getElementById("span_qm").innerHTML = "";
	}
	if(flag==0){
		document.getElementById("form").submit();
	}
}
function appChange(){
	document.getElementById("form2").submit();
}
function disableIt() {
    document.getElementById("submit").disabled = true;
}
</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/collapse.css" media="screen"></head>
<body onload=display_ct();>
<%
if(session.getAttribute("username") == null){response.sendRedirect("Login.jsp");}
%>
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

<% 
response.setHeader("Cache-Control","no-store"); 
response.setHeader("Pragma","no-cache"); 
response.setHeader ("Expires", "0"); //prevents caching at the proxy server 
%>

<h1>Queue Manager and Queues</h1>
<table align="left" id="formTable">
<tr>
<form id="form" action="SelectQM" method="post">
<td class="drop">Queue Manager:<select name="qmName" id="qmName" onchange="QmChange()">
<option value="val">--Queue Manager--</option>
<%
for(String qm : QueueBrowser.getQmList()){
	if(session.getAttribute("qmName")!=null && session.getAttribute("qmName").toString().equals(qm)){%>
<option value="<%=qm%>" selected="selected"><%=qm %></option>
<%	
}
else{%>
	<option value="<%=qm%>"><%=qm%></option>
	<%
}}
%>
</select></td></form>
<form id="form0" action="FilterQueues" method="post">
<td class="drop">Start of QueueName:<select name="StartsWith" id="StartsWith" onchange="PrefixChange()">
<option value="prefix">Choose First Letter</option>
<%if(session.getAttribute("qmName")!=null){
for(String prefix : QueueBrowser.getAlphabateList()){
	if(session.getAttribute("prefix")!=null && session.getAttribute("prefix").toString().equals(prefix)){%>
<option value="<%=prefix%>" selected="selected"><%=prefix %></option>
<%	
}
else{%>
	<option value="<%=prefix%>"><%=prefix%></option>
	<%
}}}
%>
</select></td></form>
<form action="GetQueueDetails" method="post" id="form1" onsubmit="return qChange()">
<td class="drop">Queue:<select name="qName" id="qName">
<option value="Queue">--GENERIC QUEUE--</option>
<%if(session.getAttribute("filteredQList")!=null){
	ArrayList <String> FilteredList = (ArrayList <String>)session.getAttribute("filteredQList");
	for(String q : FilteredList){
		if(session.getAttribute("qName")!=null && session.getAttribute("qName").toString().equals(q)){
		%><option value="<%=q%>" selected="selected"><%=q%></option>
		<%}else{ %>
		<option value="<%=q%>"><%=q%></option>
		<%}
	}
}
%>
</select>
</td>
</tr>
<tr>
<td><font color=red><span id="span_qm"></span></font></td>
<td><font color=red><span id="span_Sw"></span></font></td>
<td><font color=red><span id="span_broker"></span></font></td>
</tr><tr><td><input type="radio" name="action" id="act" value="properties">Queue Properties</td><td><input type="radio" name="action" value="browsemsg">Browse Message</td><td><input type="radio" name="action" value="putmsg">Put Message</td></tr>
<tr><td></td><td></td><td></td></tr>
</form>
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
</html>-->


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>iMPAS</title>
<link rel="shortcut icon" href="/PharmaAssist/img/rx-logo-hi.ico"></link>
<link href="default.css" rel="stylesheet" type="text/css" />
<link href="fonts.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
function PrefixChange(){
	var px = document.getElementById("StartsWith").value;
	var flag=0;
	if(px=="prefix"){
		document.getElementById("span_Sw").innerHTML = " Select the starting letter";
		flag=1;
	}else{
		document.getElementById("span_Sw").innerHTML = "";
	}
	if(flag==0){
		document.getElementById("form0").submit();
	}
}
function qChange(){
	var q = document.getElementById("qName").value;
	var flag=0;
	if(q=="Queue"){
		document.getElementById("span_broker").innerHTML="Select the Queue";
		flag=1;
	}
	else{
		document.getElementById("span_broker").innerHTML="";
	}
	if(flag==0){
		document.getElementById("submit").disabled = true;
		return true;
		//document.getElementById("form").submit();
	}
	else{
		return false;
	}
}
function QmChange(){
	var qm = document.getElementById("qmName").value;
	var flag=0;
	if(qm=="val"){
		document.getElementById("span_qm").innerHTML = " Select Queue Manager";
		flag=1;
	}else{
		document.getElementById("span_qm").innerHTML = "";
	}
	if(flag==0){
		document.getElementById("form").submit();
	}
}
function appChange(){
	document.getElementById("form2").submit();
}
function disableIt() {
    document.getElementById("submit").disabled = true;
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
<table><tr><td align="center">
<h1>Queue Manager and Queues</h1></td></tr><tr><td> </td></tr><tr><td> </td></tr>
</table>
<table align="left" id="formTable">
<tr>
<form id="form" action="SelectQM" method="post">
<td class="drop">Queue Manager:<select name="qmName" id="qmName" onchange="QmChange()">
<option value="val">--Queue Manager--</option>
<%
for(String qm : QueueBrowser.getQmList()){
	if(session.getAttribute("qmName")!=null && session.getAttribute("qmName").toString().equals(qm)){%>
<option value="<%=qm%>" selected="selected"><%=qm %></option>
<%	
}
else{%>
	<option value="<%=qm%>"><%=qm%></option>
	<%
}}
%>
</select></td></form>

<td class="drop">Filter:<input type="text" name="filter"></td>
<form action="GetQueueDetails" method="post" id="form1" onsubmit="return qChange()">
<td class="drop">Queue:<select name="qName" id="qName">
<option value="Queue">--GENERIC QUEUE--</option>
<%if(session.getAttribute("filteredQList")!=null){
	ArrayList <String> FilteredList = (ArrayList <String>)session.getAttribute("filteredQList");
	for(String q : FilteredList){
		if(session.getAttribute("qName")!=null && session.getAttribute("qName").toString().equals(q)){
		%><option value="<%=q%>" selected="selected"><%=q%></option>
		<%}else{ %>
		<option value="<%=q%>"><%=q%></option>
		<%}
	}
}
%>
</select>
</td>
</tr>
<tr>
<td><font color=red><span id="span_qm"></span></font></td>
<td><font color=red><span id="span_Sw"></span></font></td>
<td><font color=red><span id="span_broker"></span></font></td>
</tr><tr><td><input type="radio" name="action" id="act" value="properties">Queue Properties</td><td><input type="radio" name="action" value="browsemsg">Browse Message</td><td><input type="radio" name="action" value="putmsg">Put Message</td></tr>
<tr><td class="drop"></td><td class=""></td><td class="res1" align="left"><input type="submit" name="submit" value="Submit" /></td></tr></table>
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