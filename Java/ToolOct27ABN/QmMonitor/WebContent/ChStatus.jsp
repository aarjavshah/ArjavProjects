<%@page import="java.util.ArrayList"%>
<%@page import="com.cts.dnb.Application2.QueueBrowser"%>
<%@page import="com.cts.dnb.Application2.ChannelStatus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Channel Status</title>
</head>
<script type="text/javascript">
function makeDisable(){
	document.getElementById("qmName").disabled = true;
	document.getElementById("ChName").disabled = true;
	}
function makeEnable(){
	document.getElementById("qmName").disabled = false;
	document.getElementById("ChName").disabled = false;
	}
function reDirect(){
	window.location="ChannelBrowser.jsp";		
	}
</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/collapse.css" media="screen">
<body onload="makeDisable()">
<%if(session.getAttribute("username")== null){
	response.sendRedirect("Login.jsp");
	}
%>
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
<h1>Queue Manager and Channels</h1>
<table align="left" id="formTable">
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
</select><font color=red><span id="span_alias"></span></font></td></form>
<form id="form0" action="GetStatus" method="post">
<td class="drop">ChannelName:<select name="ChName" id="ChName" >
<option value="prefix">--Channel--</option>
<%if(session.getAttribute("qmName")!=null){
for(String channel : QueueBrowser.getAllChannels((String)session.getAttribute("qmName"))){
	if(session.getAttribute("ChName")!=null && channel.equals((String)session.getAttribute("ChName"))){
%>
	<option value="<%=channel%>" selected="selected"><%=channel%></option>
<%}else{ %>
	<option value="<%=channel%>"><%=channel%></option>
	<%
}}}
%>
</select><font color=red><span id="span_StartsWith"></span></font></td></tr>
<tr><%if(session.getAttribute("ChName")!=null){String ch = (String)session.getAttribute("ChName"); %>
<td>
<input type ="hidden" name="ChName" value=<%=ch %>>
<INPUT TYPE="submit" VALUE="Refresh"></td>
<%} %></form><td>
<button name="enable" id="enable" onclick="reDirect()" value="Change">Change</button>
</td></tr>
</table>
</div>
<div id="right1">
<%
ArrayList<ChannelStatus> chStatus = new ArrayList<ChannelStatus>();

int instances = 0,runin = 0; 
if(session.getAttribute("ChStatus")!=null){
	chStatus =(ArrayList<ChannelStatus>)session.getAttribute("ChStatus");
	instances = chStatus.size();
	if(instances == 1){
		if(chStatus.get(0).getChStatus().equals("Inactive")){
			instances-=1;
		}
	}
	for(ChannelStatus tmp : chStatus){
		if(tmp.getChStatus().equals("RUNNING")){
			runin ++;
		}
	}
}

%>
<table width=70% class="qDis" align="center"><tr>
<th>Property Name</th>
<th>Property Value</th></tr>
<tr><td class="res">Channel Name </td><td class="res"> <%=(String)session.getAttribute("ChName")%></td></tr>
<tr><td class="res">Channel Type </td><td class="res"> <%=chStatus.get(0).getChType()%></td></tr>
<tr><td class="res">Total Instances </td><td class="res"> <%=instances%></td></tr>
<tr><td class="res">Running Instances </td><td class="res"> <%=runin%></td></tr>
</table>
<%if((instances-runin)>0){%>
<div id="instance">
<ol class="tree">
<div id="textbox">
	<li>
	<label for="Instance Details">Instance Details</label><input type="checkbox" id="Instance Details">
		<ol>
		<%for(ChannelStatus tmp :chStatus){
		if(!tmp.getChStatus().equals("RUNNING")){
		%><li>
		<label for="<%=tmp.getHost() %>"><%=tmp.getHost()%></label>
		<input type="checkbox" id="<%=tmp.getHost()%>"> 
		<ol>
		<li class="file"><a href="#">Status : <%=tmp.getChStatus() %></a></li>
		<li class="file"><a href="#">Substate : <%=tmp.getSubState()%></a></li>
		<li class="file"><a href="#">Last Message Date: <%=tmp.getLstMsgDt() %></a></li>
		<li class="file"><a href="#">Last Message Time: <%=tmp.getLstMsgTm() %></a></li>
	</ol></li>
<%}}%></ol></li></div>
</ol>
</div><%} %>
</div>
</body>
</html>