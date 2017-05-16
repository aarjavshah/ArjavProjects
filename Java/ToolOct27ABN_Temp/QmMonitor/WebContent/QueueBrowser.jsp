<%@page import="com.cts.dnb.Application2.QueueBrowser"%>
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
<title>Queue Browser</title>
</head>
<script type="text/javascript">
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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/collapse.css" media="screen">
<body>
<%
if(session.getAttribute("username") == null){response.sendRedirect("Login.jsp");}
%>
<div id="outer"> 
<div id="header"><a href=<%=session.getAttribute("home")!=null?session.getAttribute("home").toString():"" %>><img src="home.png" height="40" width="40" alt="Home"></img>  Queue Messaging Utility</a></div>
<div id="logout"><table><tr><td>Welcome <%=session.getAttribute("username") %></td><td><a href="Logout.jsp"><img src="logg.jpg" height="25" width="25" alt="Log Out"></img></a></td></tr></table></div>
</div>

<% 
response.setHeader("Cache-Control","no-store"); 
response.setHeader("Pragma","no-cache"); 
response.setHeader ("Expires", "0"); //prevents caching at the proxy server 
%>
<div id="left">
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
</tr><tr><td><!-- <input type="submit" name="Submit" id="submit" value="Get Properties"> --></td><td><input type="submit" name="get" value="Browse Messages"></td><td><input type="submit" name="put" value="Put Messages"></td></tr>
</form>
</table>
</div>
<div id="right"><div id="brokerInfo"><table><tr><td><a href="QueueManagerInfo.jsp">Configuration Details of Queue Managers</a></td></tr></table></div></div>
</body>
</html>