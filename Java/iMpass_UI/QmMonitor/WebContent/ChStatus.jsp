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
<table align="left" id="formTable">
<tr>
<form id="form" action="LoadChannels" method="post">
<td class="drop">Queue Manager:<select name="qmName" id="qmName" onchange="QmChange()" disabled="disabled">
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
<td class="drop">ChannelName:<select name="ChName" id="ChName" disabled="disabled">
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