<%@page import="com.cts.dnb.Application2.*"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="com.cts.dnb.Application1.BrokerDetailsVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.cts.dnb.Application1.BrokerXML" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Queue Status</title>
</head>
<script type="text/javascript">
function makeDisable(){
	document.getElementById("qmName").disabled = true;
	document.getElementById("StartsWith").disabled = true;
	document.getElementById("qName").disabled = true;
	}
function makeEnable(){
	document.getElementById("qmName").disabled = false;
	document.getElementById("StartsWith").disabled = false;
	document.getElementById("qName").disabled = false;
	}
function brokerChange(){
	document.getElementById("form").submit();
}
function egChange(){
	document.getElementById("form1").submit();
}
function reDirect()
{
window.location="QueueBrowser.jsp";		
}
</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/collapse.css" media="screen">
<body onload="makeDisable()">
<%
if(session.getAttribute("username")== null){
	response.sendRedirect("Login.jsp");
	}
%><div id="container">
<div id="outer"> 
<div id="header"><a href=<%=session.getAttribute("home")!=null?session.getAttribute("home").toString():"" %>><img src="home.png" height="40" width="40" alt="Home"></img>  Queue Manager Monitor</a></div>
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
</select><font color=red><span id="span_alias"></span></font></td></form>
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
</select><font color=red><span id="span_StartsWith"></span></font></td></form>
<form action="GetQueueDetails" method="post" id="form1">
<td class="drop">Queue:<select name="qName" id="qName">
<option value="Queue">--GENERIC QUEUE--</option>
<%if(session.getAttribute("filteredQList")!=null){
	ArrayList <String> FilteredList = (ArrayList <String>)session.getAttribute("filteredQList");
	for(String q : FilteredList){
		if(session.getAttribute("qName")!=null && session.getAttribute("qName").toString().equals(q)){%>
		<option value="<%=q%>" selected="selected"><%=q %></option>
		<%	
		}
		else{%>
		<option value="<%=q%>"><%=q%></option>
		<%
	}}
}
%>
</select>
<font color=red><span id="span_broker"></span></font></td>
</tr><%if(session.getAttribute("qName")!=null){String q=(String)session.getAttribute("qName"); %>
<tr><td><input type="hidden" name="qName" value=<%=q%>>
<INPUT TYPE="submit" VALUE="Refresh"></td><%} %></form><td>
<button name="enable" id="enable" onclick="reDirect()" value="Change">Change</button>
</td></tr>
</table>
</div>

<div id="right1">
<%
QueueProperties qProperties = null;
if(session.getAttribute("qProperties")!=null){
	qProperties =(QueueProperties)session.getAttribute("qProperties");

%>
<table width=70% class="qDis" align="center"><tr>
<th>Property Name</th>
<th>Property Value</th></tr>
<tr><td class="res">Queue Name </td><td class="res"> <%=qProperties.getQueueName() %></td></tr>
<tr><td class="res">Queue Type</td> <td class="res"> <%=qProperties.getQueueType()
%></td></tr>
<tr><td class="res">Put Messages </td><td class="res"> <%=qProperties.getInhibitPutMessage() %></td></tr>
<%
if(qProperties.getQueueType().equals("LOCAL")||qProperties.getQueueType().equals("ALIAS")){
%>
<tr><td class="res">Get Messages </td><td class="res"> <%=qProperties.getInhibitGetMessage() %></td></tr>
<%	
}if(qProperties.getQueueType().equals("LOCAL")){
%>
<tr><td class="res">Queue Depth </td><td class="res"> <%=qProperties.getCurDepth() %></td></tr>
<tr><td class="res">Maximum Depth </td><td class="res"> <%=qProperties.getMaxDepth() %></td></tr>
<tr><td class="res">Open Input Count<br>(Consumer Application Count)</td> 
<%if(qProperties.getOpenInputCount()>0){ %>
<td class="res">
<ol class="tree1">
	<li>
	<label for="<%=qProperties.getOpenInputCount() %>"><%=qProperties.getOpenInputCount() %></label><input type="checkbox" id="<%=qProperties.getOpenInputCount() %>">
		<ol>
		<%for(QueueListener ls: qProperties.getListenerList()){ 
			if(ls.getType().equals("I")||ls.getType().equals("B")){%>
				<li><label for="<%=ls.getConName() %>"><%=ls.getConName()%></label>
				<input type="checkbox" id="<%=ls.getConName()%>">
				<ol>
				<li class="file"><a href="#">Channel Name: <%=ls.getChName() %></a></li>
				
				<%
				if(ls.getType().equals("B")){
				%><li class="file"><a href="#">Listener Activity: Browse </a></li>
				
				<%} %>
				</ol></li>
			<%}
		%>
		
<%} %></ol></li></ol><%}else{%> <td style="vertical-align: middle;"><% out.print(qProperties.getOpenInputCount());} %>
</td></tr>
<tr><td class="res">Open Output Count<br>(Provider Application Count)</td>
<%if(qProperties.getOpenOutputCount()>0){ %>
<td class="res">
<ol class="tree1">
	<li>
	<label for=" <%=qProperties.getOpenOutputCount() %>"> <%=qProperties.getOpenOutputCount() %></label><input type="checkbox" id=" <%=qProperties.getOpenOutputCount() %>">
		<ol>
		<%for(QueueListener ls: qProperties.getListenerList()){ 
			if(ls.getType().equals("O")){%>
				<li><label for="<%=ls.getConName() %>"><%=ls.getConName()%></label>
				<input type="checkbox" id="<%=ls.getConName()%>">
				<ol>
				<li class="file"><a href="#">Channel Name: <%=ls.getChName() %></a></li>
				</ol></li>
			<%}
		%>
		
<%} %></ol></li></ol><%}else{ %><td style="vertical-align: middle;"><%out.print(qProperties.getOpenOutputCount());}%>
</td></tr>
<tr><td class="res">Last Get Date </td><td class="res"> <%=qProperties.getLastGetDt() %></td></tr>
<tr><td class="res">Last Get Time </td><td class="res"> <%=qProperties.getLastGetTm() %></td></tr>
<tr><td class="res">Last Put Date </td><td class="res"> <%=qProperties.getLastPutDt() %></td></tr>
<tr><td class="res">Last Put Time </td><td class="res"> <%=qProperties.getLastPutTm() %></td></tr>
<%}else if(qProperties.getQueueType().equals("ALIAS")){ 
%>
<tr><td class="res">Target Queue </td><td class="res"> <%=qProperties.getTargetQ() %></td></tr>
<%}else if(qProperties.getQueueType().equals("REMOTE")){ 
%>
<tr><td class="res">Remote Queue Manager </td><td class="res"> <%=qProperties.getRemoteQM() %></td></tr>
<tr><td class="res">Remote Queue Name </td><td class="res"> <%=qProperties.getRemoteQ() %></td></tr>
<%} }%>
</table>
<%if(session.getAttribute("isPermit")!=null && qProperties.getQueueType().equals("LOCAL")){
	if((Boolean)session.getAttribute("isPermit")){%>
	<div id="instance1"><form action="MessageQueue" method="post">
	<input type="hidden" name="qm" value="<%=(String)session.getAttribute("qmName")%>">
	<input type="hidden" name="q" value="<%=(String)session.getAttribute("qName")%>">
	<input type="submit" name="put" value="Put Messages">
	<%if(qProperties.getCurDepth()>0){ %>
		<input type="submit" name="get" value="Browse Messages">
	<%}else{ %>
		<input type="submit" name="get" value="Browse Messages" disabled="disabled"><%} %>
	</form></div>
<%		}
	}%>
</div></div>
</body>
</html>
