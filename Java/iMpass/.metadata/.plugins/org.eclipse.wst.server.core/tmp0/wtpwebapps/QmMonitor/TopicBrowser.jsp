<%@page import="com.cts.dnb.Application2.QueueBrowser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Topic Properties</title>
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
	var qm = document.getElementById("TpName").value;
	var flag=0;
	if(qm=="TopName"){
		document.getElementById("span_tp").innerHTML = " Select Topic";
		flag=1;
	}else{
		document.getElementById("span_tp").innerHTML = "";
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
</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/collapse.css" media="screen">
<body>
<%
if(session.getAttribute("username") == null){response.sendRedirect("Login.jsp");}
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
<form id="form" action="LoadTopics" method="post">
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
<form id="form0" action="GetTopicDetails" method="post" onsubmit="return ChChange()">
<td class="drop">Topic Name:<select name="TpName" id="TpName" >
<option value="TopName">--Topic--</option>
<%if(session.getAttribute("qmName")!=null){
for(String topic : QueueBrowser.getAllTopics((String)session.getAttribute("qmName"))){%>
	<option value="<%=topic%>"><%=topic%></option>
	<%
}}
%>
</select><font color=red><span id="span_tp"></span></font></td></tr>
<tr><td></td><td>
<input type="submit" name="Submit" value="Submit" id="submit"></form></td></tr></table></div>
<div id="right"><div id="brokerInfo"><table><tr><td><a href="QueueManagerInfo.jsp">Configuration Details of Queue Managers</a></td></tr></table></div></div>
</body>
</html>