<%@page import="java.util.LinkedHashSet"%>
<%@page import="com.cts.dnb.Application1.BrokerXML"%>
<%@page import="com.cts.dnb.Application1.BrokerDetailsVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.cts.dnb.Application1.jaxB" %>
<%@ page import="com.cts.dnb.model1.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Broker</title>
</head>
<script type="text/javascript">
function aliasChange(){
	var alias = document.getElementById("alias").value;
	//var broker = document.getElementById("brokerName").value;
	var flag=0;
	if(alias=="Env"){
		document.getElementById("span_alias").innerHTML=" Select Environment";
		flag=1;
	}
	else{
		document.getElementById("span_alias").innerHTML="";
	}
	
	if(flag==0){
		document.getElementById("form0").submit();
	}
}
function brokerChange(){
	var broker = document.getElementById("brokerName").value;
	var flag=0;
	if(broker=="B"){
		document.getElementById("span_broker").innerHTML="Select the broker";
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
function egChange(){
	document.getElementById("form1").submit();
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
<link href="default.css" rel="stylesheet" type="text/css" />
<link href="fonts.css" rel="stylesheet" type="text/css" />
<body style="overflow: hidden" onload=display_ct();>
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
<h1>Environment and Broker</h1>
<table align="left" id="formTable" style="padding-top: 10px">
<tr>
<form  id="form0" action="GetBrokers" method="post">
<td class="drop">Environment:<select name="alias" id="alias" onchange="aliasChange();">
<option value="Env">--Environments--</option>
<%
LinkedHashSet<String> aliasList = jaxB.getAliasList(); 
for(String alias:aliasList){
	if(session.getAttribute("alias")!=null && session.getAttribute("alias").toString().equals(alias)){%>
		<option value="<%=alias%>" selected="selected"><%=alias%></option>
	<%}else{%>
		<option value="<%=alias%>"><%=alias%></option>
	<%}
}
%>
</select><font color=red><span id="span_alias"></span></font></td></form>
<form  id="form" action="GetEgs" method="post" onsubmit="return brokerChange()">
<td class="drop">Broker-Name:<select name="broker" id="brokerName" >
<option value="B">--Brokers--</option>
<%
if(session.getAttribute("brokerList")!=null){
ArrayList<String> tmp =(ArrayList<String>) session.getAttribute("brokerList");
for(String broker :tmp){
	if(session.getAttribute("broker")!=null && session.getAttribute("broker").toString().equals(broker)){%>
<option value="<%=broker%>" selected="selected"><%=broker %></option>
<%	
}
else{%>
	<option value="<%=broker%>"><%=broker %></option><%
}
}}
%>
</select>
<font color=red><span id="span_broker"></span></font></td>
</tr>
<tr><td></td><td><input type="submit" value="Submit" id="submit"></td></tr></form>
</table>
</div>
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