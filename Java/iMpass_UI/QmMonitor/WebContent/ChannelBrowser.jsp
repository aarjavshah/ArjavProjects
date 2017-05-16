<%@page import="com.cts.dnb.Application2.QueueBrowser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>iMPAS: MQ Channels</title>
</head>
<script type="text/javascript">
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
function ChChange(){
	var qm = document.getElementById("ChName").value;
	var flag=0;
	if(qm=="chaName"){
		document.getElementById("span_ch").innerHTML = " Select Channel";
		flag=1;
	}else{
		document.getElementById("span_ch").innerHTML = "";
	}
	if(flag==0){
		//document.getElementById("form").submit();
		document.getElementById("submit").disabled = true;
		return true;
	}else{
		return false;
	}
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
<link href="default.css" rel="stylesheet" type="text/css" />
<link href="fonts.css" rel="stylesheet" type="text/css" />
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
<table><tr><td>

<% 
response.setHeader("Cache-Control","no-store"); 
response.setHeader("Pragma","no-cache"); 
response.setHeader ("Expires", "0"); //prevents caching at the proxy server 
%>
<h1>Queue Manager and Channels</h1>
<table align="left" id="formTable" style="padding-top: 10px">
<tr>
<form id="form" action="LoadChannels" method="post">
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
</select><font color=red><span id="span_qm"></span></font></td></form>
<form id="form0" action="GetStatus" method="post" onsubmit="return ChChange()">
<td class="drop">ChannelName:<select name="ChName" id="ChName" >
<option value="chaName">--Channel--</option>
<%if(session.getAttribute("qmName")!=null){
for(String channel : QueueBrowser.getAllChannels((String)session.getAttribute("qmName"))){%>
	<option value="<%=channel%>"><%=channel%></option>
	<%
}}
%>
</select><font color=red><span id="span_ch"></span></font></td></tr>
<tr><td></td><td>
<input type="submit" name="Submit" value="Submit" id="submit"></form></td></tr></table>
</td></tr></table>
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