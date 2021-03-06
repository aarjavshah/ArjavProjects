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
</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/collapse.css" media="screen">
<body>
<%
if(session.getAttribute("username") == null){response.sendRedirect("Login.jsp");}
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
<h1>Environment and Broker</h1>
<table align="left" id="formTable">
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
<div id="right"><div id="brokerInfo"><table><tr><td><a href="BrokerInfo.jsp">Configuration Details for all available Brokers</a></td></tr></table></div></div>
</body>
</html>