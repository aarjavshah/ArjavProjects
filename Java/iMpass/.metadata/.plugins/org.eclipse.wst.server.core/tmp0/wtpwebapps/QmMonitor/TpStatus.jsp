<%@page import="com.cts.dnb.Application2.TopicProperties"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cts.dnb.Application2.QueueBrowser"%>
<%@page import="com.cts.dnb.Application2.ChannelStatus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Topic Status</title>
</head>
<script type="text/javascript">
function makeDisable(){
	document.getElementById("qmName").disabled = true;
	document.getElementById("TpName").disabled = true;
	}
function makeEnable(){
	document.getElementById("qmName").disabled = false;
	document.getElementById("TpName").disabled = false;
	}
function reDirect(){
	window.location="TopicBrowser.jsp";		
	}
</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/collapse.css" media="screen">
<body onload="makeDisable()">
<%if(session.getAttribute("username")== null){
	response.sendRedirect("Login.jsp");
	}
%>
<div id="outer">
<div id="header"><a href=<%=session.getAttribute("home")!=null?session.getAttribute("home").toString():"" %>><img src="home.png" height="40" width="40" alt="Home"></img>  iMPAS</a></div>
<div id="logout"><table><tr><td>Welcome <%=session.getAttribute("username") %></td><td><a href="Logout.jsp"><img src="logg.jpg" height="25" width="25" alt="Log Out"></img></a></td></tr></table></div>
</div>


<% 
response.setHeader("Cache-Control","no-store"); 
response.setHeader("Pragma","no-cache"); 
response.setHeader ("Expires", "0"); //prevents caching at the proxy server 
%>
<div id="left">
<h1>Queue Manager and Topics</h1>
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
<form id="form0" action="GetTopicDetails" method="post">
<td class="drop">ChannelName:<select name="TpName" id="TpName" >
<option value="prefix">--Channel--</option>
<%if(session.getAttribute("qmName")!=null){
for(String channel : QueueBrowser.getAllTopics((String)session.getAttribute("qmName"))){
	if(session.getAttribute("TpName")!=null && channel.equals((String)session.getAttribute("TpName"))){
%>
	<option value="<%=channel%>" selected="selected"><%=channel%></option>
<%}else{ %>
	<option value="<%=channel%>"><%=channel%></option>
	<%
}}}
%>
</select><font color=red><span id="span_StartsWith"></span></font></td></tr>
<tr><%if(session.getAttribute("TpName")!=null){String ch = (String)session.getAttribute("TpName"); %>
<td>
<input type ="hidden" name="TpName" value=<%=ch %>>
<INPUT TYPE="submit" VALUE="Refresh"></td>
<%} %></form><td>
<button name="enable" id="enable" onclick="reDirect()" value="Change">Change</button>
</td></tr>
</table>
</div>
<div id="right1">
<%
TopicProperties tp = (TopicProperties)session.getAttribute("TpProp");

%>
<table width=70% class="qDis" align="center"><tr>
<th>Property Name</th>
<th>Property Value</th></tr>
<tr><td class="res">Topic Name </td><td class="res"> <%=tp.getTopicName()%></td></tr>
<tr><td class="res">Topic String </td><td class="res"> <%=tp.getTopicString()%></td></tr>
<tr><td class="res">Topic Description </td><td class="res"> <%=tp.getTopicDesc()%></td></tr>
<tr><td class="res">Publication </td><td class="res"> <%=tp.getPubAllowed()%></td></tr>
<tr><td class="res">Subscription </td><td class="res"> <%=tp.getSubAllowed()%></td></tr>
</table>

</div>
</body>
</html>